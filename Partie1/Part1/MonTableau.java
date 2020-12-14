package Part1;

public class MonTableau implements EstComparable{
	
    int [] tableau;
    
    //constructeur
    public MonTableau(int [] tableau) {
        this.tableau = tableau;
        
    }
    
    public int compareA(Object tab)  throws ClassCastException, NullPointerException{

        int somme1 = 0;
        int somme2 = 0;
        int res = 0;

        if (tab == null) {
            throw new NullPointerException("L'objet passée en parametre est nulle ");
        }
        else {
            try {
                for(int i : this.tableau) {
                    somme1 += i;
                }
                
                for(int i : ((MonTableau)tab).tableau) {
                    somme2 += i;
                }
                
                if(somme1<somme2)
                    res = -1;
                else if(somme1>somme2)
                    res = 1;
                else 
                    res = 0;
                
                
            } catch (ClassCastException e) {
                throw new ClassCastException("L'objet passée en parametre n'est pas de type MonTableau ");
                
            }

            return res; 
        }
        
               
    }

    public static void main(String args[]) {
        int [] a = new int [] {1,3};
        MonTableau tab1 = new MonTableau(a);
        int [] b = new int [] {1,3};
        MonTableau tab2 = new MonTableau(b);
        System.out.print(tab1.compareA(tab2));
      
    }
    
    
    

}

