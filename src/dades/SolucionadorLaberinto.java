package dades;
/**
*
* @author Cristhian y Arnau
*/
public class SolucionadorLaberinto {
	private Laberinto lab;
	private Pila pila;
	private Posicion[] visited;
	int visitats;

	public SolucionadorLaberinto(Laberinto lab) {
		this.lab = lab;
		this.pila = new Pila((lab.getAlto() + 1) * (lab.getAncho() + 1)*4);
		this.visited = new Posicion[(lab.getAlto() + 1) * (lab.getAncho() + 1)];
		visitats = 0;
	}

	//es exactamente igual que el solDfs excepto por que no utilizo la pila
	public String greddy() {
		//Posición de inicio
		Posicion actual = lab.getEntrada();
		
		//acumulamos la primera posición a tus puntos
		actual.setScore(actual.combinaScore(lab.getAt(lab.getEntrada())));
		
		//Camino seguido
		String cami;

		PosBacktracking aux = new PosBacktracking(actual, lab.getAt(lab.getEntrada()));

		boolean fi = false;
		while (!fi) {
			//nos situamos en la posicion actual
			actual = aux.getPos();
			//camino recorrido de momento
			cami = aux.getCaselles();
			
			System.out.println("Visito: " + actual + " hi ha: " + lab.getAt(actual) + " Score: " + actual.getScore());
			//Visito una nueva posición
			visit(actual);
			
			//si ya está resuelto acabo la resolucion e imprimo el camino y los puntos finales
			if (Laberinto.IsSolved(actual, lab)) {
				return (cami + " SCORE: " + actual.getScore());
			}
			
			//recojo los hijos de la posición actual
			Posicion[] hijos = Laberinto.GetSuccessors(actual, lab);
			System.out.println("Els fill son:");
			
			Posicion hijo = null;
			aux = null;
			//Como es greddy tenemos que mirar los elementos de la lista de getSucessors desde el ultimo hasta el primero 
			//(la lista coloca en la ultima posicion el que deja la mejor puntuación)
			int i = hijos.length - 1;
			boolean trobat = false;
			//en este bucle decido que hijo es el escogido para avanzar
			while (i >= 0 && !trobat) {
				hijo = hijos[i];
				System.out.print(hijo + " " + hijo.getScore() + " -- ");
				//compruebo si lo he visitado y si acumulando su puntuación llego a 0. si es así me posiciono ahí
				if (!isVisited(hijo) && hijo.getScore() > 0) {
					aux = new PosBacktracking(hijo, cami + " " + lab.getAt(hijo));
					trobat = true;
				} else
					i--;
				System.out.println();
			}
			fi=aux==null;
		}
		//si salgo del bucle es que no tiene mas hijos para desplazarme
		return ("NO TE SOLUCIO");
	}

	public String solveDfs() {
		// POSICION DE INICIO
		Posicion actual = lab.getEntrada();
		// RECOGEMOS PUNTUACION DE LA PRIMERA POSICION
		actual.setScore(actual.combinaScore(lab.getAt(lab.getEntrada())));
		// CAMINO SEGUIDO PARA IMPRIMIR
		String cami;

		pila.push(new PosBacktracking(actual, lab.getAt(lab.getEntrada())));
		//buscaré un camino hasta que la pila se quede vacia
		while (!pila.isEmpty()) {
			PosBacktracking aux = pila.pop();
			actual = aux.getPos();
			cami = aux.getCaselles();
			
			System.out.println("Visito: " + actual + " hi ha: " + lab.getAt(actual) + " Score: " + actual.getScore()+" camino es: "+cami);
			//Marcamos otra casilla como visitada
			visit(actual);
			
			//si ya esta resuelto acabamos
			if (Laberinto.IsSolved(actual, lab)) {
				return (cami + " SCORE: " + actual.getScore());
			}
			
			//Recojo los hijos de esta posición y los muestro, luego decido cual escoger
			Posicion[] hijos = Laberinto.GetSuccessors(actual, lab);
			System.out.println("Els fills son:");
			
			//Acumulo los hijos en la pila para visitarlos en caso de que tenga que volver
			for (int i = 0; i < hijos.length; i++) {
				Posicion hijo = hijos[i];
				System.out.print(hijo + " " + hijo.getScore() + " -- ");
				if (!isVisited(hijo) && hijo.getScore() > 0) {
					pila.push(new PosBacktracking(hijo, cami + " " + lab.getAt(hijo)));
				}
			}
			System.out.println();
		}
		return ("NO TE SOLUCIO");
	}

	//Añadimos uno a la lista de visitados
	private void visit(Posicion p) {
		visited[visitats] = p;
		visitats++;
	}
	
	//Comprobamos si lo hemos visitado
	private boolean isVisited(Posicion p) {
		int i = 0;
		boolean trobat = false;

		while (i < visitats && !trobat) {
			if (visited[i].equals(p))
				trobat = true;
			i++;
		}

		return trobat;
	}

	//Clase interna Pila
	class Pila {
		//array de PosBacktraking para volver atras
		PosBacktracking[] array;
		int mida; // primera posicio buida
		int midaMax;

		Pila(int midaMax) {
			array = new PosBacktracking[midaMax];
			this.midaMax = midaMax;
			mida = 0;
		}

		//Añadimos una posicion a la pila
		void push(PosBacktracking p) {
			if (mida < 100) {
				array[mida] = p;
				mida++;
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
		
		//Eliminamos la ultima posicion
		PosBacktracking pop() {
			if (mida > 0) {
				mida--;
				return array[mida];
			}
			return null;
		}
		
		//Esta vacia?
		boolean isEmpty() {
			return mida == 0;
		}

	}

}
