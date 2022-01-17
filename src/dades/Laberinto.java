package dades;

import java.util.Iterator;

/**
 *
 * @author Cristhian y Arnau
 */

public class Laberinto {
	private String[][] laberinto;
	private int ancho; // Columnas
	private int alto; // Filas
	private Posicion entrada; // Posicion de entrada del laberinto
	private Posicion salida; // Posicion de salida del laberinto

	//Por falta de tiempo he implementado un algoritmo algo mas simple pero en mayor medida funcional
	public Laberinto(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		laberinto = new String[alto+1][ancho+1];
		for (int i = 0; i <= alto; i++) {
			for (int j = 0; j <= ancho; j++) {
				int aleatorio = (int) (Math.random() * 5) + 1;
				if (aleatorio == 1) {
					laberinto[i][j] = "NA";
				} else
					laberinto[i][j] = generarPosRandom();
			}

		}
		boolean inicial = false;
		for (int i = 0; i <= alto; i++) {
			for (int j = 0; j <= ancho; j++) {
				if(laberinto[i][j] != "NA" && !inicial && laberinto[i][j].charAt(0) == '+') {
					entrada = new Posicion(i, j);
					inicial = true;
				}else
					salida = new Posicion(i, j);
			}

		}
		System.out.print(entrada+" "+salida+"\n");
	}

	//Metodo para generar
	private String generarPosRandom() {
		int aleatorio = (int) (Math.random() * 4)+1;	//Random para escoger que operacion a realizar
		String caracterOp = "";
		int numRandom =(int)(Math.random()*15)+1;	//random para el numero en la posicion
		switch (aleatorio) {
		case 0:
			caracterOp = "+"+String.valueOf(numRandom);
			System.out.println("He escogido + " + aleatorio);
			break;
		case 1:
			caracterOp = "-"+String.valueOf(numRandom);
			System.out.println("He escogido - " + aleatorio);
			break;
		case 2:
			caracterOp = "*"+String.valueOf(numRandom);
			System.out.println("He escogido x "+ aleatorio);
			break;
		case 3:
			caracterOp = "+"+String.valueOf(numRandom);
			System.out.println("He escogido + " + aleatorio);
			break;
		default:
			caracterOp = "/"+String.valueOf(numRandom);
			System.out.println("He escogido / "+ aleatorio);
			break;
		}
		return caracterOp;
	}

	public Laberinto(String[][] lab, int ancho, int alto, Posicion entrada, Posicion salida) {
		this.laberinto = lab;
		this.ancho = ancho; // maxima posicio habitable
		this.alto = alto; // maxima posicion habitable
		this.entrada = entrada;
		this.salida = salida;
	}

	public String getAt(Posicion p) {
		return laberinto[p.getX()][p.getY()];
	}

	public Posicion getEntrada() {
		return entrada;
	}

	public void setEntrada(Posicion entrada) {
		this.entrada = entrada;
	}

	public Posicion getSalida() {
		return salida;
	}

	public void setSalida(Posicion salida) {
		this.salida = salida;
	}

	public String[][] getLaberinto() {
		return laberinto;
	}

	public void setLaberinto(String[][] laberinto) {
		this.laberinto = laberinto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	// Mira si el laberinto esta solucionado
	public static boolean IsSolved(Posicion actual, Laberinto lab) {
		return actual.getX() == lab.getSalida().getX() && actual.getY() == lab.getSalida().getY();
	}

	// Devuelve los hijos del nodo actual para despues decidir a cual nos movemos.
	public static Posicion[] GetSuccessors(Posicion actual, Laberinto lab) {
		boolean[] valids = { false, false, false, false }; // inf, sup, izq, der
		int conta = 0;
		if (actual.getX() != lab.getAlto() && !lab.getAt(actual.getInferior()).equals("NA")) {
			valids[0] = true;
			conta++;
		}
		if (actual.getX() != 0 && !lab.getAt(actual.getSuperior()).equals("NA")) {
			valids[1] = true;
			conta++;
		}
		if (actual.getY() != 0 && !lab.getAt(actual.getIzquierda()).equals("NA")) {
			valids[2] = true;
			conta++;
		}
		if (actual.getY() != lab.getAncho() && !lab.getAt(actual.getDerecha()).equals("NA")) {
			valids[3] = true;
			conta++;
		}
		Posicion[] retorn = new Posicion[conta];
		conta = 0;
		for (int i = 0; i < 4; i++) {
			if (valids[i]) {
				if (i == 0) {
					retorn[conta] = actual.getInferior();
					retorn[conta].setScore(actual.combinaScore(lab.getAt(actual.getInferior())));
					conta++;
				} else if (i == 1) {
					retorn[conta] = actual.getSuperior();
					retorn[conta].setScore(actual.combinaScore(lab.getAt(actual.getSuperior())));
					conta++;
				} else if (i == 2) {
					retorn[conta] = actual.getIzquierda();
					retorn[conta].setScore(actual.combinaScore(lab.getAt(actual.getIzquierda())));
					conta++;
				} else if (i == 3) {
					retorn[conta] = actual.getDerecha();
					retorn[conta].setScore(actual.combinaScore(lab.getAt(actual.getDerecha())));
					conta++;
				}
			}
		}

		return sort(retorn, conta);
	}

	// Buble sort para ordenar la pila
	private static Posicion[] sort(Posicion[] p, int mida) {
		for (int i = 0; i < mida; i++) {
			for (int j = i; j < mida; j++) {
				if (p[j].getScore() < p[i].getScore()) {
					Posicion aux = p[j];
					p[j] = p[i];
					p[i] = aux;
				}
			}
		}
		return p;
	}
	
}