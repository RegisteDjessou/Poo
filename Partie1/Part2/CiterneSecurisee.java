package Part2;

public class CiterneSecurisee extends Citerne implements Cloneable{

    Citerne cuveTropPlein ;

    //constructeurs
    public CiterneSecurisee(int capacite, type_liquide type, Citerne cuveTropPlein){
        super(capacite,type);
        this.cuveTropPlein = cuveTropPlein;

    }


    //setters
    public Citerne getCuveCiterneSecurisee(){
        return this.cuveTropPlein;
    }

    //methode ajouterLiquide
    public void ajouterLiquide(int ajout){

        if(ajout<0)
            throw new IllegalArgumentException("Ajout cannot be negative");

        if((this.volume + ajout)>this.capacite){
            int surplus = (this.volume + ajout) - this.capacite;
            this.volume = this.capacite;
            System.err.println("Capacite maximale atteinte");
            this.cuveTropPlein.ajouterLiquide(surplus);

            if(surplus>this.cuveTropPlein.volume)
                this.cuveTropPlein = new Citerne ((int)(0.1*this.capacite), this.type);

            if(this.cuveTropPlein.volume > this.cuveTropPlein.capacite/2)
                System.err.println("Cuve Trop Plein a moitie vide");
            //throw new IllegalArgumentException("Capacite is superior of :" + surplus );
        }

        if(this.type == null)
            throw new NullPointerException("Cuve is null");

        this.volume = this.volume + ajout;

    }


    //comparaison
    public int compareA(Object citerne) {

        if(citerne instanceof CiterneSecurisee){
            int somme1 = this.volume + this.cuveTropPlein.volume;
            int somme2 = ((CiterneSecurisee)citerne).volume  +  ((CiterneSecurisee)citerne).cuveTropPlein.volume;
            int sommeC1 = this.capacite + this.cuveTropPlein.capacite;
            int sommeC2 = ((CiterneSecurisee)citerne).capacite  +  ((CiterneSecurisee)citerne).cuveTropPlein.capacite;
            int res = 0;
            if( somme1 < somme2) 
                res = -1;
            else if(somme1 > somme2)
                res = 1;
            else
                if(sommeC1 < sommeC2) 
                    res = -1;
                else if(sommeC1 > sommeC2)
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
    public String toString() {
        return ("Citerne n°" + this.identifiant + ", " + this.type 
        + ", capacité : " + this.capacite + " m3, mise en service :" 
        + this.date+ ", volume occupé :" + this.volume + ", Cuve Trop Plein:" + this.cuveTropPlein.toString());
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CiterneSecurisee){
            boolean res = false;
            if(this.capacite == ((CiterneSecurisee)obj).capacite && 
            this.date == ((CiterneSecurisee)obj).date && 
            this.type == ((CiterneSecurisee)obj).type &&
            this.volume == ((CiterneSecurisee)obj).volume && 
            this.cuveTropPlein.equals(((CiterneSecurisee)obj).cuveTropPlein) )

                res = true;

            return res;

        }
        else{
            throw new IllegalArgumentException("Object type is not Citerne");
        }
    }

    //clonage en profondeur
    @Override
    public Object clone() throws CloneNotSupportedException {
        
            CiterneSecurisee citerneSecurisee = null;
            try {
                citerneSecurisee = (CiterneSecurisee) super.clone();
            } catch (CloneNotSupportedException e) {
                citerneSecurisee = new CiterneSecurisee(
                this.getCapacite(), this.getType(), this.getCuveCiterneSecurisee());
            }
            
            return citerneSecurisee;   
    }

    
    
}
