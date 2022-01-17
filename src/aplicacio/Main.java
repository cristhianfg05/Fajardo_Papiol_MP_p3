package aplicacio;

/**
*
* @author Cristhian y Arnau
*/
import dades.Laberinto;
import dades.Posicion;
import dades.SolucionadorLaberinto;

public class Main {

	public static void main(String[] args) {
		String[][] laberint = { { "NA", "NA", "-1", "/2", "+1", "NA", "NA" },
				{ "-7", "NA", "*3", "NA", "+2", "+1", "-1" }, { "+4", "*2", "-8", "+3", "+7", "-1", "+4" },
				{ "+9", "-2", "+5", "-1", "+9", "+8", "-2" }, { "/1", "*7", "NA", "NA", "+4", "NA", "NA" } };

		String[][] laberint2 = { { "NA", "NA", "-1", "/2", "+1", "NA", "NA" },
				{ "-7", "NA", "*3", "NA", "+2", "+1", "-1" }, { "+4", "*2", "-8", "+3", "+7", "-1", "+4" },
				{ "+9", "-2", "+5", "-1", "+9", "+8", "-2" }, { "/1", "*7", "NA", "NA", "+4", "NA", "NA" } };

		String[][] laberint3 = { { "NA", "NA", "-1", "/2", "+1", "NA", "NA" },
				{ "*3", "NA", "*3", "NA", "+2", "+1", "-1" }, { "+53", "-5", "-8", "+3", "+7", "-1", "+4" },
				{ "+129", "-2", "+5", "-1", "+9", "+8", "-2" }, { "/1", "-7", "NA", "NA", "+4", "NA", "NA" } };
		Laberinto lab = new Laberinto(laberint3, 6, 4, new Posicion(3, 0), new Posicion(1, 6));

		System.out.print("COMENZAMOS\n");

		Laberinto lab2 = new Laberinto(7, 7);
		for (int i = 0; i <= lab2.getAlto(); i++) {
			for (int j = 0; j <= lab2.getAncho(); j++) {
				System.out.print(lab2.getLaberinto()[i][j] + " ");
			}
			System.out.println();
		}
		SolucionadorLaberinto solv = new SolucionadorLaberinto(lab2);
		System.out.println("Ho he resolt greedy: " + solv.solveDfs());
	}

}
