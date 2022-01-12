package dades;

public class Laberinto {
	private String[][] laberinto;
	private int ancho;
	private int alto;
	private Posicion entrada;
	private Posicion salida;
	private Posicion actual;

	public Laberinto(String[][] lab, int ancho, int alto, Posicion entrada, Posicion salida) {
		this.laberinto = lab;
		this.ancho = ancho;
		this.alto = alto;
		this.entrada = entrada;
		this.salida = salida;
		this.actual = entrada;
	}

	public Posicion getActual() {
		return actual;
	}

	public void setActual(Posicion actual) {
		this.actual = actual;
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

	public boolean isSolved() {
		return this.actual.getX() == this.salida.getX() && this.actual.getY() == this.salida.getY();
	}

}
