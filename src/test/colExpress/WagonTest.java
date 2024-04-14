package colExpress;

import modele.Modele;
import plateau.Plateau;
import org.junit.jupiter.api.Test;

class WagonTest {

    @Test
    void getPlaceOcuppedByWagonInPlateau() {
    Modele m =new Modele();
    Plateau plateau=new  Plateau(m);
        Wagon w1=new Wagon();
        //w1.setPlaceOcuppedByWagonInPlateau();
        Personne p=new Personne("alhas");
        w1.addPersonneInWagon(p);

       System.out.println( p.getPlaceOfPersonneInWagon());
        //System.out.println( w1.getPlaceOcuppedByWagonInPlateau());
        w1.printPlacesOccopedByWagon();

        Wagon w2=new Wagon();
        //w1.setPlaceOcuppedByWagonInPlateau();
        Personne p2=new Personne("alhas");
        w2.addPersonneInWagon(p2);

        System.out.println( p2.getPlaceOfPersonneInWagon());
        //System.out.println( w1.getPlaceOcuppedByWagonInPlateau());
        w2.printPlacesOccopedByWagon();

        Wagon w3=new Wagon();
        //w1.setPlaceOcuppedByWagonInPlateau();
        Personne p3=new Personne("alhas");
        w2.addPersonneInWagon(p2);

        System.out.println( p3.getPlaceOfPersonneInWagon());
        //System.out.println( w1.getPlaceOcuppedByWagonInPlateau());
        w3.printPlacesOccopedByWagon();






    }

    @Test
    void setPlaceOcuppedByWagonInPlateau() {
    }

    @Test
    void getListPlaceOccuppedByWagon() {
    }

    @Test
    void setListPlaceOccuppedByWagon() {
    }

    @Test
    void addPersonneInWagon() {
    }
}