package colExpress;

import Plateau.Plateau;
import modele.Cellule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BanditTest {

    @Test
    void avancer() {
        Plateau plateau=new Plateau();
        Wagon w1=new Wagon();
        Wagon w2=new Wagon();
        Wagon w3=new Wagon();

        Personne p1=new Personne("alhas");
        Personne p2=new Personne("alhous");
        Personne p3=new Personne("dios");
        Bandit bandit=new Bandit("bandi1");
        Bandit bandit2=new Bandit("bandit2");

        w1.addPersonneInWagon(p1);
        w1.addPersonneInWagon(p3);


        System.out.println(p1.getPlaceofPersonneInWagon());
        System.out.println(p3.getPlaceofPersonneInWagon());


        w3.addPersonneInWagon(bandit);
        w1.addPersonneInWagon(bandit2);

        System.out.println("Deplacement bandit "+bandit.name);
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit ");
        System.out.println(bandit.getPlaceofPersonneInWagon());
        bandit.avancer();
        System.out.println("position bandit apres avancer ");
        System.out.println(bandit.getPlaceofPersonneInWagon());

        System.out.println("Deplacement bandit "+bandit2.name);
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit ");
        System.out.println(bandit2.getPlaceofPersonneInWagon());
        bandit2.avancer();
        System.out.println("position bandit apres avancer ");
        System.out.println(bandit2.getPlaceofPersonneInWagon());






    }

    @Test
    void monter() {
    }

    @Test
    void descendre() {
    }

    @Test
    void decrementerDureeDeVie() {
    }

    @Test
    void addButinVoler() {
    }
}