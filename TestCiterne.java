import Part2.Citerne;
import Part2.CiterneSecurisee;
import Part2.Citerne.type_liquide;

public class TestCiterne  {
    public static void main (String[] args)  throws CloneNotSupportedException{
        
        Citerne citerne1 = new Citerne(15000,type_liquide.eau);
        Citerne citerne2 = new Citerne(12000,type_liquide.vin);


        assert citerne1.equals(citerne2) == false : "False";
        assert citerne2.compareA(citerne1) == -1 : "False";

        citerne1.ajouterLiquide(4000);
        citerne2.ajouterLiquide(4000);
        citerne2.enleverLiquide(2500);
        
        CiterneSecurisee citerneSecurisee1 = new CiterneSecurisee(20000, type_liquide.eau, citerne1);
        CiterneSecurisee citerneSecurisee2 = new CiterneSecurisee(20000, type_liquide.eau, citerne2);

        assert citerneSecurisee1.equals(citerneSecurisee2) == false : "False";
        assert citerneSecurisee2.compareA(citerneSecurisee1) == -1 : "False";

        citerneSecurisee1.ajouterLiquide(6000);
        citerneSecurisee2.ajouterLiquide(6000);
        citerneSecurisee2.enleverLiquide(2500);

        CiterneSecurisee citerneSecurisee3 =(CiterneSecurisee)(citerneSecurisee1.clone());

        citerneSecurisee3.nettoyage();
   
        System.out.println(citerne1);
        System.out.println(citerne2);
        System.out.println(citerneSecurisee1);
        System.out.println(citerneSecurisee2);
        System.out.println(citerneSecurisee3);



        

        
    }

    
}
