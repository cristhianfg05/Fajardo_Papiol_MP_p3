package dades;

/**
 *
 * @author Cristhian y Arnau
 */
public class PosBacktracking {
	private Posicion pos;
	private String caselles;

	public PosBacktracking(Posicion pos, String caselles) {
		this.pos = pos;
		this.caselles = caselles;
	}

	public PosBacktracking(Posicion pos) {
		this.pos = pos;
		this.caselles = "";
	}

	public Posicion getPos() {
		return pos;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}

	public String getCaselles() {
		return caselles;
	}

	public void setCaselles(String caselles) {
		this.caselles = caselles;
	}

}
