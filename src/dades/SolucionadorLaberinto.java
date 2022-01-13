package dades;

public class SolucionadorLaberinto {
	// BACKTRAKING-DFS
	private Posicion[] pila;
	private Posicion[] recorrido;
	private Posicion posicionActual;
	private int numElemPila;
	private int numElemRecorrido;
	private double puntos;
	// BACKTRAKING-DFS

	public SolucionadorLaberinto(Laberinto l) {
		pila = new Posicion[l.getAlto() * l.getAncho()];
		recorrido = new Posicion[l.getAlto() * l.getAncho()];
		posicionActual = new Posicion(l.getEntrada().getX(), l.getEntrada().getY());
		numElemPila = 0;
		numElemRecorrido = 0;
	}

	public Posicion[] greddy(Laberinto l) {
		while (!l.isSolved()) {
		}
		return null;
	}

	public Posicion[] backTracking_DFS(Laberinto l) {
		this.puntos = Double.parseDouble(l.getLaberinto()[l.getEntrada().getX()][l.getEntrada().getY()]);
		recorrido[0] = posicionActual;
		while (!l.isSolved() && puntos > 0) {
			if(comprobarMejorCamino(l, puntos) == 0) {
				//VAMOS PARRIBA
				posicionActual.setX(posicionActual.getX()+1);
				apilarPosicion(posicionActual);
			}else if(comprobarMejorCamino(l, puntos) == 1) {
				//VAMOS PABAJO
				posicionActual.setX(posicionActual.getX()-1);
				apilarPosicion(posicionActual);
			}else if(comprobarMejorCamino(l, puntos) == 2) {
				//VAMOS PAL LAO IZQUIERDO
				posicionActual.setY(posicionActual.getY()-1);
				apilarPosicion(posicionActual);
			}else if(comprobarMejorCamino(l, puntos) == 3) {
				//VAMOS PAL LAO DERECHO
				posicionActual.setY(posicionActual.getY()+1);
				apilarPosicion(posicionActual);
			}else {
				desapilarUltimo();
			}
		}
		return recorrido;
	}

	private void apilarPosicion(Posicion p) {
		pila[numElemPila] = p;
		numElemPila++;
		posicionActual = p;
		recorrido[numElemRecorrido] = p;
		numElemRecorrido++;
	}

	private void desapilarUltimo() {
		numElemPila--;
		posicionActual = pila[numElemPila];
	}

	private int comprobarMejorCamino(Laberinto l, double puntos) {
		double camino1 = puntos; // ARRIBA
		double camino2 = puntos; // ABAJO
		double camino3 = puntos; // IZQUIERDA
		double camino4 = puntos; // DERECHA

		// COMPROBAR ARRIBA
		if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '*') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino1 = camino1 * Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '+') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino1 = camino1 + Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '-') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino1 = camino1 - Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '/') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino1 = camino1 / Double.parseDouble(num);
		} else
			camino1 = Double.MIN_VALUE;
		// COMPROBAR ARRIBA

		// COMPROBAR ABAJO
		if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '*') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino2 = camino2 * Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '+') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino2 = camino2 + Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '-') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino2 = camino2 - Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '/') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino2 = camino2 / Double.parseDouble(num);
		} else
			camino2 = Double.MIN_VALUE;
		// COMPROBAR ABAJO

		// COMPROBAR IZQUIERDA
		if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '*') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino3 = camino3 * Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '+') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino3 = camino3 + Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '-') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino3 = camino3 - Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '/') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino3 = camino3 / Double.parseDouble(num);
		} else
			camino3 = Double.MIN_VALUE;
		// COMPROBAR IZQUIERDA

		// COMPROBAR DERECHA
		if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '*') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino4 = camino4 * Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '+') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino4 = camino4 + Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '-') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino4 = camino4 - Double.parseDouble(num);
		} else if (l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].charAt(0) == '/') {
			String num = "";
			for (int i = 0; i < l.getLaberinto()[posicionActual.getX()][posicionActual.getY()]
					.toCharArray().length; i++) {
				num = num + l.getLaberinto()[posicionActual.getX()][posicionActual.getY()].toCharArray()[1 + i];
			}
			camino4 = camino4 / Double.parseDouble(num);
		} else
			camino4 = Double.MIN_VALUE;
		// COMPROBAR DERECHA

		if (camino1 >= camino2 && camino1 >= camino3 && camino1 >= camino4
				&& !celdaYaRecorrida(new Posicion(posicionActual.getX() + 1, posicionActual.getY()))) {
			this.puntos += camino1;
			return 0; // IR PARA ARRIBA
		}
			
		else if (camino2 > camino1 && camino2 > camino3 && camino2 > camino4
				&& !celdaYaRecorrida(new Posicion(posicionActual.getX() - 1, posicionActual.getY()))) {
			return 1;// IR PARA ABAJO
		}
			
		else if (camino3 > camino1 && camino3 > camino2 && camino3 > camino4
				&& !celdaYaRecorrida(new Posicion(posicionActual.getX(), posicionActual.getY() - 1))) {
			return 2;//IR PARA LA IZQUIERDA
		}
			
		else if (camino4 > camino1 && camino4 > camino2 && camino4 > camino3
				&& !celdaYaRecorrida(new Posicion(posicionActual.getX(), posicionActual.getY() + 1))) {
			return 3;//IR PARA LA DERECHA
		}
			
		else
			return 4;

	}

	private boolean celdaYaRecorrida(Posicion p) {// TRUE = CELDA YA RECORRIDA //FALSE = CELDA NO RECORRIDA
		int i = 0;
		boolean trobat = false;
		while (i < numElemRecorrido && !trobat) {
			if (recorrido[i].getX() == p.getX() && recorrido[i].getY() == p.getY())
				trobat = true;
			i++;
		}
		return trobat;
	}
}
