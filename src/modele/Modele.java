package modele;

import plateau.Plateau;
import colExpress.Personne;
import colExpress.Wagon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class Modele extends  Observable{

    private LinkedList<Wagon> tarins= new LinkedList<>();

    private Plateau plateau;

    List<Personne> personnes=new ArrayList<>();

    public Modele(){

    }


    public void addPersonInWagonModele(Personne p, int numWagon){
        /**
         * cette methode ajoute une personne à l'indice au wagon indice i
         * */
        tarins.get(numWagon).addPersonneInWagon(p);
        int id=p.getIdPerson();

       for(Personne pp: personnes){
           if( !(p.equals(pp))){
               //si c'est une nouvelle personne l'ajouter à à la liste de  personne
               this.personnes.add(p);
           }
       }
    }


    public void evoluerLesVoyageurs(){

    }
    public void evoluerLesBandits(){

    }


   public void addPersonneAuWagonSuivant(){

   }
    public void addPersonneAuWagonPrecent(){

    }







}
