package aplicacio;

import dades.Laberinto;
import dades.Posicion;
import dades.SolucionadorLaberinto;

public class Main {

	public static void main(String[] args) {
        String[][] laberint = {
        		{"NA", "NA", "-1", "/2", "+1", "NA", "NA"},
                {"-7", "NA", "*3", "NA", "+2", "+1", "-1"},
                {"+4", "*2", "-8", "+3", "-7", "-1", "+4"},
                {"+9", "-2", "+5", "-1", "+9", "NA", "-2"},
                {"/1", "*7", "NA", "NA", "+4", "NA", "NA"}};
            Laberinto lab = new Laberinto(laberint, 6, 4,new Posicion(3,0), new Posicion(1,6));
            SolucionadorLaberinto solv = new SolucionadorLaberinto(lab);
            System.out.print("COMENZAMOS\n");
            System.out.println("Ho he resolt dfs: "+ solv.solveDfs() );
        }
        
    }
