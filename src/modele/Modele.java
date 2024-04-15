package modele;

import colExpress.Bandit;
import colExpress.Direction;
import plateau.Plateau;
import colExpress.Personne;
import colExpress.Wagon;

import java.util.*;


public class Modele extends  Observable{
 /**
  *Permet de stocker les instances des données métiers.
  * et de les afficher.
  * Il a des attributs qui permetron d'instancier un type métier. Et de faire des opération avec.
  * Généralement les objets de la couches métier son instanciés une seule fois.
  * Le controlleur va le contenir en stockant les données calcées des données metiers.
  *
  * Le modele etend Observable. Qui est donc un observateur.(JFRame est un observateur, ses sous composent
  * sont des observé.)
  * Pour ce la chaque sous composante de de JFrame doit implementer observer.
  * Donc le modèle est lié aussi à plusiuers vues.
  * */
    private LinkedList<Wagon> trains= new LinkedList<>();

    private Plateau plateau;

    List<Personne> personnes=new ArrayList<>();

    public Modele(){

    }


    public void addPersonInWagonModele(Personne p, int numWagon){
        /**
         * cette methode ajoute une personne à l'indice au wagon indice i
         * */
        trains.get(numWagon).addPersonneInWagon(p);
        int id=p.getIdPerson();

       for(Personne pp: personnes){
           if( !(p.equals(pp))){
               //si c'est une nouvelle personne l'ajouter à à la liste de  personne
               this.personnes.add(p);
           }
       }
    }




public void evoluer(){

}


public void move(Bandit b, Direction d){
        /**
         * Faite avancer la personne p */
    Direction direction;
    switch( d )
    {
        case HAUT:
            System.out.println(d);
            break;
        case BAS :
            System.out.println(d);
            break;
        case AVANT :
            System.out.println(d);
            break;
        case ARRIERE:
            System.out.println(d);
        case IMMOBILE:
            System.out.println(d);
    }
        Iterator<Wagon> itW=this.trains.iterator();
    Set<Personne>  listPersonInWagon=new HashSet<>();
        while(itW.hasNext()){
            Wagon w= itW.next();
            listPersonInWagon=w.getPersonInWagon();
            for(Personne p: listPersonInWagon){
                if(p.equals(b)){
                    b.avancer();
                }

            }

        }

}



}
