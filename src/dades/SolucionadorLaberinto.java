package dades;

import java.util.PriorityQueue;

public class SolucionadorLaberinto {
	private PriorityQueue GreddyQueue;
	private Laberinto laberinto;
	
	public SolucionadorLaberinto (Laberinto l) {
		laberinto = l;
		GreddyQueue = new PriorityQueue<>();
	}
}
