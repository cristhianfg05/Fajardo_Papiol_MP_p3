package dades;



public class SolucionadorLaberinto {
    private Laberinto lab;
    private Pila pila;
    private Posicion[] visited;
    int visitats;

    public SolucionadorLaberinto(Laberinto lab) {
        this.lab = lab;
        this.pila = new Pila((lab.getAlto()+1)*(lab.getAncho()+1));
        this.visited = new Posicion[(lab.getAlto()+1)*(lab.getAncho()+1)];
        visitats = 0;
    }
    
	public String greddy() {
    	//POSICION DE INICIO
        Posicion actual = lab.getEntrada();
        //RECOGEMOS PUNTUACION DE LA PRIMERA POSICION
        actual.setScore(actual.combinaScore(lab.getAt(lab.getEntrada())));
        //CAMINO SEGUIDO PARA IMPRIMIR
        String cami;
        
        pila.push(new PosBacktracking(actual, lab.getAt(lab.getEntrada())));
        while(! pila.isEmpty()){
            PosBacktracking aux = pila.pop();
            actual = aux.getPos();
            cami = aux.getCaselles();
            
            System.out.println("Visito: "+actual+" hi ha: "+lab.getAt(actual)+ " Score: "+ actual.getScore());
            visit(actual);
            
            if(Laberinto.IsSolved(actual, lab)){
                return (cami + " SCORE: " + actual.getScore());
            }
            
            Posicion[] hijos = Laberinto.GetSuccessors(actual, lab);
            System.out.println("Els fill son:");
            
            Posicion hijo= hijos[0];
            int i=0;
            for(i = 0; i < hijos.length; i++){
            	hijo = hijos[i];
            }
            
            System.out.print(hijo+" "+ hijo.getScore()+" -- ");
            if(! isVisited(hijo) && hijo.getScore() > 0){
                pila.push(new PosBacktracking(hijo, cami+" "+lab.getAt(hijo)));
            }
            System.out.println();
        }
        return("NO TE SOLUCIO");
		}
    
    public String solveDfs(){
    	//POSICION DE INICIO
        Posicion actual = lab.getEntrada();
        //RECOGEMOS PUNTUACION DE LA PRIMERA POSICION
        actual.setScore(actual.combinaScore(lab.getAt(lab.getEntrada())));
        //CAMINO SEGUIDO PARA IMPRIMIR
        String cami;
        
        pila.push(new PosBacktracking(actual, lab.getAt(lab.getEntrada())));
        while(! pila.isEmpty()){
            PosBacktracking aux = pila.pop();
            actual = aux.getPos();
            cami = aux.getCaselles();
            
            System.out.println("Visito: "+actual+" hi ha: "+lab.getAt(actual)+ " Score: "+ actual.getScore());
            visit(actual);
            
            if(Laberinto.IsSolved(actual, lab)){
                return (cami + " SCORE: " + actual.getScore());
            }
            
            Posicion [] hijos = Laberinto.GetSuccessors(actual, lab);
            System.out.println("Els fills son:");
            
            for(int i = 0; i < hijos.length; i++){
                Posicion hijo = hijos[i];
                System.out.print(hijo+" "+ hijo.getScore()+" -- ");
                if(! isVisited(hijo) && hijo.getScore() > 0){
                    pila.push(new PosBacktracking(hijo, cami+" "+lab.getAt(hijo)));
                }
            }
            System.out.println();
        }
        return("NO TE SOLUCIO");
    }
    
    private void visit(Posicion p){
        visited[visitats] = p;
        visitats ++;
    }
    
    private boolean isVisited(Posicion p){
        int i = 0;
        boolean trobat = false;
        
        while(i < visitats && !trobat){
            if(visited[i].equals(p))
                trobat = true;
            i++;
        }
        
        return trobat;
    }
    
    //Si, una classe interna, soc aixi de vaga
    class Pila {
       PosBacktracking [] array;
       int mida; //primera posicio buida
       int midaMax;
       
       Pila(int midaMax){
           array = new PosBacktracking [midaMax];
           this.midaMax = midaMax;
           mida = 0;
       }
       
       void push(PosBacktracking p){
           if(mida < 100){
               array[mida] = p;
               mida ++;
           } else{
               throw new IndexOutOfBoundsException();
           }
       }
       
       PosBacktracking pop(){
           if(mida > 0){
               mida --;
               return array[mida];
           }
           return null;
       }
       
       boolean isEmpty(){
           return mida == 0;
       }
       
    }
           
}
