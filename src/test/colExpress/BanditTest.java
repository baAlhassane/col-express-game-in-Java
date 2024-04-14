package colExpress;

import modele.Modele;
import plateau.Plateau;
import org.junit.jupiter.api.Test;

class BanditTest {

    @Test
    void avancer() {
        Modele m=new Modele();
        Plateau plateau=new Plateau(m);
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


        System.out.println(p1.getPlaceOfPersonneInWagon());
        System.out.println(p3.getPlaceOfPersonneInWagon());


        w3.addPersonneInWagon(bandit);
        w1.addPersonneInWagon(bandit2);

        System.out.println("Deplacement bandit "+bandit.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit ");
        System.out.println(bandit.getPlaceOfPersonneInWagon());
        bandit.avancer();
        System.out.println("position bandit apres avancer ");
        System.out.println(bandit.getPlaceOfPersonneInWagon());

        System.out.println("Deplacement bandit "+bandit2.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit "+bandit2.getName());
        System.out.println(bandit2.getPlaceOfPersonneInWagon());
        bandit2.avancer();
        System.out.println("position bandit apres avancer "+bandit2.getName());
        System.out.println(bandit2.getPlaceOfPersonneInWagon());
        System.out.println(" ----------------------------------");
        System.out.println(" test des wagon de taille variable ");

        Bandit bandit5=new Bandit("bandit5");
        Bandit bandit6=new Bandit("bandit6");

        Wagon w4=new Wagon(5);
        Wagon w5=new Wagon(5);

        w4.addPersonneInWagon(bandit5);
        w5.addPersonneInWagon(bandit6);

        System.out.println("Deplacement bandit "+bandit5.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit "+bandit5.getName());
        System.out.println(bandit5.getPlaceOfPersonneInWagon());
        bandit5.avancer();
        System.out.println("position bandit apres avancer "+bandit5.getName());
        System.out.println(bandit5.getPlaceOfPersonneInWagon());

        System.out.println("Deplacement bandit "+bandit6.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit "+bandit6.getName());
        System.out.println(bandit6.getPlaceOfPersonneInWagon());
        bandit6.avancer();
        System.out.println("position bandit apres avancer "+bandit6.getName());
        System.out.println(bandit6.getPlaceOfPersonneInWagon());


    }

    @Test
    void monter() {
        System.out.println(" test des déplacement monter ");
        Modele m=new Modele();
        Plateau plateau=new Plateau(m);
        Wagon w1=new Wagon();
        Wagon w2=new Wagon(5);
        Wagon w3=new Wagon();

        Personne p1=new Personne("alhas");
        Personne p2=new Personne("alhous");
        Personne p3=new Personne("dios");
        Bandit bandit1=new Bandit("bandit1");
        Bandit bandit2=new Bandit("bandit2");

        w1.addPersonneInWagon(bandit1);
        w2.addPersonneInWagon(bandit2);

        System.out.println("Deplacement bandit monter "+bandit1.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit monter "+bandit1.getName());
        System.out.println(bandit1.getPlaceOfPersonneInWagon());
        bandit1.monter();
        System.out.println("position bandit apres monter"+bandit2.getName());
        System.out.println(bandit2.getPlaceOfPersonneInWagon());

        System.out.println("Deplacement bandit monter "+bandit2.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit "+bandit2.getName());
        System.out.println(bandit2.getPlaceOfPersonneInWagon());
        bandit2.monter();
        System.out.println("position bandit apres monter  "+bandit2.getName());
        System.out.println(bandit2.getPlaceOfPersonneInWagon());

    }

    @Test
    void descendre() {
        //Si on appelle des un type Personne sur les actions du bandit.
        // on observe pas de changement de position car. les position sont (-1,-1) par défaux et initoialisé
        // dans la classe Personne.
        System.out.println(" test des déplacement monter ");
        Modele m=new Modele();
        Plateau plateau=new Plateau(m);
        Wagon w1=new Wagon();
        Wagon w2=new Wagon(5);
        Wagon w3=new Wagon();

        Personne p1=new Personne("alhas");
        Personne p2=new Personne("alhous");
        Personne p3=new Personne("dios");
        Bandit bandit1=new Bandit("bandit1");
        Bandit bandit2=new Bandit("bandit2");

        w1.addPersonneInWagon(bandit1);
        w2.addPersonneInWagon(bandit2);

        System.out.println("Deplacement bandit monter "+bandit1.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit monter "+bandit1.getName());
        System.out.println(bandit1.getPlaceOfPersonneInWagon());
        bandit1.descendre();
        System.out.println("position bandit apres descendre"+bandit2.getName());
        System.out.println(bandit2.getPlaceOfPersonneInWagon());

        System.out.println("Deplacement bandit descendre "+bandit2.getName());
        System.out.println("---------------------------------------");
        System.out.println("position initiale bandit "+bandit2.getName());
        System.out.println(bandit2.getPlaceOfPersonneInWagon());
        bandit2.descendre();
        System.out.println("position bandit apres monter  "+bandit2.getName());
        System.out.println(bandit2.getPlaceOfPersonneInWagon());

    }

    @Test
    void decrementerDureeDeVie() {
    }

    @Test
    void addButinVoler() {
    }
}