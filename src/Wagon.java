import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wagon {
/*
* Cette classe a deux construteurs.
* 1- Avec le nombre de personne à bord.
* 2- Sans personne à bord ie wagon vide
* Les atributs sont :
* - La liste des persones à bords dans un  conteneur Set
* -ididentifiant de chaque wagon donnée par une incrémentation du nbre d'intance
* - Le déplacement  d'une personne dans un wagon est données par
*  la mis à jours des personnes dans ce wagon en l'ajout à la liste de personne.
*  Et en le supprimant dans le wagon ou elle étatit. 
 */
    private static int nbrInstanceWagon=0;
    private  int nbrePersoneInWagon ;
    private int idWagon;
    private Set<Personne> personInWagon=new HashSet<>();

    public Wagon(int nbrePersonPresent){
        this.nbrePersoneInWagon=nbrePersonPresent;
     this.idWagon=++ nbrInstanceWagon;
     for(int i=0;i<this.nbrePersoneInWagon;i++){
         int j=Personne.getNbInstancePersonne()+1;//On recupère le nbre de personnes
         //en ensuite on l'ajoute à 1 pour créer une nouvelle personne .
         // Car chaque personne a un idetifiant unique qui est la ieme instance de personne
         this.personInWagon.add(new Personne(j,this));
         Personne.setNbInstancePersonne(j);// Ensuite on met à jour le nbre de personne instancier

     }


    }

    public Wagon(){

    }

    public static int getNbrInstanceWagon() {
        return nbrInstanceWagon;
    }

    public static void setNbrInstanceWagon(int nbrInstanceWagon) {
        Wagon.nbrInstanceWagon = nbrInstanceWagon;
    }

    public int getNbrePersoneInWagon() {
        return nbrePersoneInWagon;
    }

    public int getIdWagon() {
        return idWagon;
    }

    public void setIdWagon(int idWagon) {
        this.idWagon = idWagon;
    }

    public Set<Personne> getPersonInWagon() {
        return personInWagon;
    }

    public void setPersonInWagon(Set<Personne> personInWagon) {
        this.personInWagon = personInWagon;
    }
}
