package dades;

public class Posicion {
	private int x;
	private int y;
        private int score;
	
	public Posicion (int x, int y) {
		this.x = x;
		this.y = y;
                score = 0;
	}

    public Posicion(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
        
        
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
        public Posicion getSuperior(){
            return new Posicion(x-1, y);
        }
        
        public Posicion getInferior(){
            return new Posicion(x+1, y);
        }
        
        public Posicion getDerecha(){
            return new Posicion(x, y+1);
        }
        
        public Posicion getIzquierda(){
            return new Posicion(x, y-1);
        }
	
        @Override
        public String toString(){
            return("("+x+", "+y+")");
        }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Posicion){
            Posicion p = (Posicion)obj;
            return(p.x == this.x && p.y == this.y);
        }
        return false;
    }
        
    public int combinaScore(String s){
        char op = s.charAt(0);
        int numero = Character.getNumericValue(s.charAt(1));//feeling Lazy
        if(op == '+')
            return score+numero;
        if(op == '-')
            return score - numero;
        if(op == '*')
            return score * numero;
        return score / numero;
    }
}