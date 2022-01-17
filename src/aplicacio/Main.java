package aplicacio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*
* @author Cristhian y Arnau
*/
import dades.Laberinto;
import dades.Posicion;
import dades.SolucionadorLaberinto;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("fitxer.txt");
		Scanner lector = new Scanner(file);
		Laberinto[] listaLab = new Laberinto[10];
		int contadorLaberintos = 0;
		while (lector.hasNext()) {
			String[] atributos = lector.nextLine().split(", ");
			int alto = Integer.parseInt(atributos[0]) - 1;
			int ancho = Integer.parseInt(atributos[1]) - 1;
			int xposicionentrada = Integer.parseInt(atributos[2]);
			int yposicionentrada = Integer.parseInt(atributos[3]);
			int xposicionsalida = Integer.parseInt(atributos[4]);
			int yposicionsalida = Integer.parseInt(atributos[5]);
			String[][] laberinto = new String[alto + 1][ancho + 1];
			int contadorFila = 0;
			while (lector.hasNextLine() && contadorFila <= alto) {
				atributos = lector.nextLine().split(", ");
				for (int i = 0; i <= ancho; i++) {
					laberinto[contadorFila][i] = atributos[i];
				}
				contadorFila++;

			}

			listaLab[contadorLaberintos] = new Laberinto(laberinto, ancho, alto,
					new Posicion(xposicionentrada, yposicionentrada), new Posicion(xposicionsalida, yposicionsalida));
			contadorLaberintos++;
		}
		lector.close();

		for(int i = 0; i<contadorLaberintos; i++) {
			SolucionadorLaberinto solv = new SolucionadorLaberinto(listaLab[i]);
			System.out.print("COMENZAMOS con el laberinto con dfs/backtraking"+i+"\n");
			System.out.println("Ho he resolt dfs/backtraking: " + solv.solveDfs()+"\n");
			solv = new SolucionadorLaberinto(listaLab[i]);
			System.out.print("COMENZAMOS con el laberinto con greddy "+i+"\n");
			System.out.println("Ho he resolt greddy: " + solv.greddy());
			System.out.println();
		}
		
		

	}

}
