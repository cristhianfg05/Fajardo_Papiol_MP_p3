package aplicacio;

import dades.Laberinto;
import dades.Posicion;
import dades.SolucionadorLaberinto;

public class Main {

	public static void main(String[] args) {
		String[][]laberinto = {{"Na","Na","Na","Na","Na"},
								{"Na","5","+1","-1","Na"},
								{"Na","+4","+1","-1","Na"},
								{"Na","+3","+3","+4","Na"},
								{"Na","Na","Na","Na","Na"}};
		Laberinto l = new Laberinto(null, 5, 5, new Posicion(1,1),new Posicion(3, 3));
		SolucionadorLaberinto sol = new SolucionadorLaberinto(l);
		sol.backTracking_DFS(l);

	}

}
