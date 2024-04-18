package modele;

import colExpress.Bandit;
import colExpress.Direction;
import colExpress.Personne;
import colExpress.Wagon;
import org.junit.jupiter.api.Test;
import plateau.Plateau;

import javax.swing.text.Style;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ModeleTest {

    @Test
    void addPersonInWagonModele() {

        Modele m=new Modele();
        Plateau plateau=new Plateau(m);
         //LinkedList<Wagon> trains= new LinkedList<>();
         Wagon w1=new Wagon();
         Wagon w2=new Wagon();
        Wagon w3=new Wagon();


        Personne p1=new Personne("alhas");
        Personne p2=new Personne("alhous");
        Personne p3=new Personne("dios");
        Personne p4=new Personne("fily");
        Personne p5=new Bandit("Bandit");


        m.addPersonInWagonModele(p1,w1);
        m.addPersonInWagonModele(p2,w2);
        m.addPersonInWagonModele(p3,w3);
        m.addPersonInWagonModele(p4,w1);
        m.addPersonInWagonModele(p1,w3);
        m.addPersonInWagonModele(p5,w2);

        /**
         *         LinkedList<Wagon> restAttendu= new LinkedList<>();
         *         restAttendu.add(w1);restAttendu.get(0).addPersonneInWagon(p3);
         *         restAttendu.add(w2);restAttendu.get(1).addPersonneInWagon(p2);
         *         restAttendu.add(w3);restAttendu.get(2).addPersonneInWagon(p1);
          */

        //assertEquals(trains,m.getTrains());
        System.out.println(m.getPersonnes());
        System.out.println(m.getTrains());





    }

    @Test
    void move() {
       // move(Personne b, Direction d)
        Modele m=new Modele();
        Plateau plateau=new Plateau(m);
        LinkedList<Wagon> trains= new LinkedList<>();
        Wagon w1=new Wagon();
        Wagon w2=new Wagon();
        Wagon w3=new Wagon();


        Personne p1=new Personne("alhas");
        Personne p2=new Personne("alhous");
        Personne p3=new Personne("dios");



        System.out.println("Deplacement personne "+p1.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit ");
        System.out.println(p1.getPlaceOfPersonneInWagon());
        m.move(p1,Direction.AVANT);
        System.out.println("position bandit apres avancer ");
        System.out.println(p1.getPlaceOfPersonneInWagon());
        //m.move(p1,Direction.AVANT);

        Bandit bandit=new Bandit("bandit1");
        Bandit bandit1=new Bandit("bandit2");

        /** cest test ajoute aleatoirement des position  **/
       // m.addPersonInWagonModele(bandit,w3);
        //m.addPersonInWagonModele(bandit1,w1);
       // m.addPersonInWagonModele(p2,w2);


        m.addMarshaltWithPosInWagon(p1,w1,1);
        m.addBanditWithPosInWagon(bandit,w1,1);
        m.addBanditWithPosInWagon(bandit1,w2,2);
        m.addVoyageurWithPosInWagon(p2,w3,1);



        System.out.println("Deplacement personne "+p1.getName());
        System.out.println("------------------ Les autres personnes ne bougent pas sauf les bandits ---------------------");
        System.out.println("position initiale personne ");
        System.out.println(bandit.getPlaceOfPersonneInWagon());
        //m.move(bandit, Direction.AVANT);
        m.move(p1,Direction.AVANT);
        System.out.println("position personne apres avancer ");
        System.out.println(bandit.getPlaceOfPersonneInWagon());



        System.out.println("Deplacement bandit "+bandit.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit ");

        //m.move(bandit, Direction.AVANT);
        //m.move(bandit,Direction.AVANT);
        for ( int i= 0; i<Wagon.getLongueurTotalWagon()+1;i++){
            System.out.println(bandit.getPlaceOfPersonneInWagon());
            m.move(bandit,Direction.AVANT);
            System.out.println("position bandit apres avancer ");
        }






    }



    @Test
    void testAddPersonInWagonModele() {
    }

    @Test
    void evoluer() {
    }

    @Test
    void testMove() {
    }

    @Test
    void avancer() {


    }

    @Test
    void reculer() {
    }

    @Test
    void monter() {
    }

    @Test
    void descendre() {
    }

    @Test
    void addPersonneWithPosInWagon() {

        Modele m=new Modele();
        Plateau plateau=new Plateau(m);
        //LinkedList<Wagon> trains= new LinkedList<>();
        Wagon w1=new Wagon();
        Wagon w2=new Wagon();
        Wagon w3=new Wagon();


        Personne p1=new Personne("alhas");
        Personne p2=new Personne("alhous");
        Personne p3=new Personne("dios");
        Personne p4=new Personne("fily");
        Personne p5=new Bandit("Bandit");


        m.addPersonInWagonModele(p1,w1);
        m.addPersonInWagonModele(p2,w2);
        m.addPersonInWagonModele(p3,w3);
        m.addPersonInWagonModele(p4,w1);
        m.addPersonInWagonModele(p1,w3);
        m.addPersonInWagonModele(p5,w2);

        //assertEquals(trains,m.getTrains());
        System.out.println(m.getPersonnes());
        System.out.println(m.getTrains());




    }

    @Test
    void createPersonneWithPosInWagon() {

        Modele m=new Modele();
        Plateau p=new Plateau(m);
        Wagon w=new Wagon();
        Wagon w2=new Wagon();
        Personne v= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.VOYAGEUR,w,1);
        Personne b= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.BANDIT,w,2);
       // Personne marshal= m.createPersonneWithPosInWagon(TYPEPERSONNE.MARSHAL,w2,2);


        //System.out.println(v);
    }

    @Test
    void addVoyageurWithPosInWagon() {
        Modele m=new Modele();
        Plateau p=new Plateau(m);
        Wagon w=new Wagon();
        Wagon w2=new Wagon();
        Personne v= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.VOYAGEUR,w,1);
        Personne b= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.BANDIT,w,2);
    }

    @Test
    void addBanditWithPosInWagon() {
    }

    @Test
    void addMarshaltWithPosInWagon() {
    }
}