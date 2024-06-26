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
/**
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
 **/
        /**
         *         LinkedList<Wagon> restAttendu= new LinkedList<>();
         *         restAttendu.add(w1);restAttendu.get(0).addPersonneInWagon(p3);
         *         restAttendu.add(w2);restAttendu.get(1).addPersonneInWagon(p2);
         *         restAttendu.add(w3);restAttendu.get(2).addPersonneInWagon(p1);
          */

        /**
        //assertEquals(trains,m.getTrains());
        System.out.println(m.getPersonnes());
        System.out.println(m.getTrains());
         */


    }

    @Test
    void move() {
        LinkedList<Wagon> trins=new LinkedList<>();
       // move(Personne b, Direction d)
        Modele m=new Modele();
        Plateau plateau=new Plateau(m);
        //LinkedList<Wagon> trains= new LinkedList<>();
        Wagon w1=new Wagon();
        Wagon w2=new Wagon();
        Wagon w3=new Wagon();



        Personne p1=new Personne("alhas");
        Personne p2=new Personne("alhous");
        Personne p3=new Personne("dios");


        Bandit bandit=new Bandit("bandit");
        Bandit bandit1=new Bandit("bandit2");

        //m.addTrain(w1);
       // m.addTrain(w2);
        //m.addTrain(w3);
       //m.addMarshaltWithPosInWagon(p1,w1,1);
       m.addBanditWithPosInWagon(bandit,w1,2);
       m.addWagonInTrain(w2);
       m.addBanditWithPosInWagon(bandit1,w3,2);
       //m.addVoyageurWithPosInWagon(p1,w3,1);

       //   for(int i=0;i<6;i++) {
             //System.out.println("----------------------------i = "+i);
              m.move(bandit, Direction.AVANT, w1);
             // System.out.println("----------------------------i = "+i);
          //}












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
       // m.addPersonInWagonModele(p2,w2);
       // m.addPersonInWagonModele(p3,w3);
       // m.addPersonInWagonModele(p4,w1);
        //m.addPersonInWagonModele(p1,w3);
       // m.addPersonInWagonModele(p5,w2);

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
        Plateau plateau=new Plateau(m);
        Wagon w=new Wagon();
        Wagon w1=new Wagon();
        Personne v= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.VOYAGEUR,w,2);
        Personne b= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.VOYAGEUR,w,1);
       Personne p= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.BANDIT,w,5);
       Personne marchall= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.MARSHAL,w,3);
    }

    @Test
    void addBanditWithPosInWagon() {
        Modele m=new Modele();
        Plateau plateau=new Plateau(m);
        Wagon w=new Wagon();
        Wagon w1=new Wagon();
        Personne v= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.VOYAGEUR,w,1);
        Personne b= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.BANDIT,w,2);
        Personne p= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.VOYAGEUR,w,3);
        Personne p2= m.createNewPersonneWithPosInWagon(TYPEPERSONNE.BANDIT,w,5);
    }

    @Test
    void addMarshaltWithPosInWagon() {
    }
}