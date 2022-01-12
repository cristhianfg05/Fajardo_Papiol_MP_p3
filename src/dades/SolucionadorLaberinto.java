package dades;


public class SolucionadorLaberinto {
	private Laberinto laberinto;
	
	public SolucionadorLaberinto (Laberinto l) {
		laberinto = l;
	}
	
	public Posicion[] greddy () {
		while(!laberinto.isSolved()){}
		return null;
	}
}
