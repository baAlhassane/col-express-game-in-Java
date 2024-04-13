package colExpress;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
class PersonneTest {

    @Test
    void getNbInstancePersonne() {
        Personne p1=new Personne("p1",new Wagon());
        int resultIdP1=p1.getIdPerson();
        int resultIdAttenduP1= 1;

        Personne p2=new Personne("p2",new Wagon());
        int resultIdP2=p2.getIdPerson();
        int resultIdAttenduP2= 2;

        int resultAttenduPourNbrePersonne =2;

        int nbrPeronnes=Personne.getNbInstancePersonne();

        assertEquals(resultIdP1,resultIdAttenduP1);
        assertEquals(resultIdP2,resultIdAttenduP2);
        assertEquals(nbrPeronnes,resultAttenduPourNbrePersonne);



    }

    @Test
    void getIdPerson() {
    }

    @Test
    void getPersonInSameWagon() {

        Wagon w1= new Wagon();
        Wagon w2=new Wagon();
        Wagon w3=new Wagon();


       Personne p1=new Personne("alhas");
        Personne p2=new Personne("alhous");
        Personne p3=new Personne("fily");

        //ajouter les personnes dans les wagons.
        w1.addPersonneInWagon(p1);
        w1.addPersonneInWagon(p3);
        w3.addPersonneInWagon(p2);


       // Personne p5=new Personne(w3);
       // w2.addPersonneInWagon(p5);
       // w2.addPersonneInWagon(p5);

        System.out.println(p1);
        System.out.println(p2);
       System.out.println(p3);

        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w3);


        Set<Personne> equipP1=new HashSet<>();
        equipP1=p1.getPersonInSameWagon();

        Set<Personne> equipP3=new HashSet<>();
        equipP3=p3.getPersonInSameWagon();

        Set<Personne> personInW1=new HashSet<>();
        personInW1=w1.getPersonInWagon();

        assertEquals(equipP1,equipP3);
        assertEquals(equipP1,personInW1);


        /*
        //Personne p6=new Personne(w3);
        Set<Personne> resultpersonInW1=new HashSet<>();
        resultpersonInW1=p3.getPersonInSameWagon();
        //System.out.print(resultpersonInW1);
       Set<Personne> personInW2=new HashSet<>();
        personInW2= p2.getPersonInSameWagon();

        Set<Personne> resultpersonInW3=new HashSet<>();
        resultpersonInW3=p5.getPersonInSameWagon();

        Set<Personne> resultpersonInW4=new HashSet<>();
        resultpersonInW1=p3.getPersonInSameWagon();

Set<Personne> resulPersonInW1Attendu=new HashSet<>();
        resulPersonInW1Attendu.add(p1);
       resulPersonInW1Attendu.add(p3);
        //System.out.println("----------------------");
     // System.out.println(resulPersonInW1Attendu);
       System.out.println(resultpersonInW1);
        System.out.println(personInW2);
        System.out.println( resultpersonInW3);

//assertEquals(resultpersonInW1,resulPersonInW1Attendu);

*/

    }

}