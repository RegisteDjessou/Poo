package Part2;
import java.time.LocalDate;

import Part1.EstComparable;

public class Citerne implements EstComparable{
    protected static int instanceNumber = 0;
    protected int identifiant; 
    protected int capacite = 0;
    public enum type_liquide {eau, vin, huile};
    protected type_liquide type;
    protected LocalDate date;
    protected int volume;
    

    //constructeurs

    public Citerne(){ 
            instanceNumber++;
            this.identifiant = instanceNumber;
            this.capacite = 5000;
            this.type = type_liquide.eau;
            this.volume = 0;
            date = LocalDate.now();      

    }


    public Citerne (int capacite, type_liquide type){

        if(capacite<=0)
            throw new IllegalArgumentException("Capacite cannot be negative or null.");
        else if(capacite >20000)
            throw new IllegalArgumentException("Capacite cannot be superior at 20000.");
        
        try {
            instanceNumber++;
            this.identifiant = instanceNumber;
            this.capacite = capacite;
            this.type = type;
            this.volume = 0;
            date = LocalDate.now();      
            
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            
        }
         

    }

    //plus_ancienne
    public static Citerne plus_ancienne(Citerne c1, Citerne c2){

        if(c1.date.isBefore(c2.date))
            return c1;
        else
            return c2;

    }

    //getters et setters 
    

    public int getCapacite(){
        return this.capacite;
    }

    public LocalDate getDate(){
         return this.date;
    }

    public type_liquide getType(){
        return this.type;
    }

    public int nombreInstance(){
        return instanceNumber;

    }


    //methode nettoyage
    public void nettoyage(){
        this.volume = 0 ;
        this.type = null;
    }

    //methode ajouterLiquide 
    public void ajouterLiquide(int ajout){

        if(ajout<0)
            throw new IllegalArgumentException("Ajout cannot be negative");

        if((this.volume + ajout)>this.capacite){
            int surplus = (this.volume + ajout) - this.capacite;
            this.volume = this.capacite;
            throw new IllegalArgumentException("Capacite is superior of :" + surplus );
        }

        if(this.type == null)
            throw new NullPointerException("Cuve is null");

        this.volume = this.volume + ajout;

    }


    //methode enleverLiquide

    public void enleverLiquide(int retrait){

        if(retrait<0)
            throw new IllegalArgumentException("Retrait cannot be negative");

        if((this.volume - retrait)<0){
            int surplus = (retrait - this.volume);
            this.volume = 0;
            throw new IllegalArgumentException("Capacite is superior of :" + surplus );
        }

        if(this.type == null)
            throw new NullPointerException("Cuve is null");

        this.volume = retrait - this.volume;

    }


    //comparer deux citernes avec EstComparable
    public int compareA(Object citerne) {

        if(citerne instanceof Citerne){
            int res = 0;
            if(this.volume < ((Citerne)citerne).volume) 
                res = -1;
            else if(this.volume > ((Citerne)citerne).volume)
                res = 1;
            else
                if(this.capacite < ((Citerne)citerne).capacite) 
                    res = -1;
                else if(this.capacite > ((Citerne)citerne).capacite)
                    res = 1;
                else 
                    res = 0;

            return res;   

        }else{
            throw new IllegalArgumentException("Object type is not Citerne");
        }

    }

    //redefinition

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Citerne){
            boolean res = false;
            if(this.capacite == ((Citerne)obj).capacite && 
            this.date == ((Citerne)obj).date && 
            this.type == ((Citerne)obj).type &&
            this.volume == ((Citerne)obj).volume )

                res = true;

            return res;

        }
        else{
            throw new IllegalArgumentException("Object type is not Citerne");
        }
    }


    @Override
    public String toString() {
        return ("Citerne n°" + this.identifiant + ", " + this.type 
        + ", capacité : " + this.capacite + " m3, mise en service :" 
        + this.date+ ", volume occupé :" + this.volume);
    }
  
}
