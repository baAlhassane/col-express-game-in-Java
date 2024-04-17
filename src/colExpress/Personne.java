package colExpress;

import modele.Modele;
import plateau.Cellule;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Personne {
    /*
    *Cette calsse est la classe mère pour toutes les personnage du jeu.
    * Elle a les propriétées communes des personnes.
    * Elle a deux construteur :
    * Un avec parametre  un wagon et un nom et ele deuxieme avec un seul parametre wagon.
    * Elle contient un attribut identifiant unique données par le nbre d'instance.
    * Une personne est associée aussi par un ensemble de personne de même wagon.
    * Une personne est toujour assicé à un wagon.
     */

    protected String name;
    protected Wagon wagon;//this
    private static int nbInstancePersonne=0;
    private int idPerson;
    private int idWagonOfPerson;
    private Set<Personne> personInSameWagon=new HashSet<>();// personne dans le meme wagon qui s'entretire
    protected Cellule placeOfPersonneInWagon=new Cellule(new Modele() ,-1,-1);


    public Cellule getPlaceOfPersonneInWagon() {
        return placeOfPersonneInWagon;
    }

    public void setPlaceOfPersonneInWagon(Cellule placeofPersonneInWagon) {
        this.placeOfPersonneInWagon = placeofPersonneInWagon;
    }

    /**
 * Ce constructeur n'est pas utilisable. car on ne peut pas construcuire une personne
 * avec un wagon. Vu notre spécification. Pareil pour le contructeur public Personne( Wagon wg).
 * Ces des constructeur utilisées pour créer une instance de wagon avec des personnes. Elles
 * ont les propriétes de classe internes.
 * C'est comme si on créer la classe Personne dans dans la classe Wagon.
 * Ca n'a pas de sens de construire des personnes avec des wagons si elles ne sont pas liées
 * intrinsequement aux wagon.
 * Par contre on peut le faire avec la classe Marshal. Qui est liée à la locomotive.
 * */
    public Personne(String name, Wagon wg){
        this.name=name;
       // this.wagon=wg;
        this.idWagonOfPerson=wg.getIdWagon();
        this.idPerson=++nbInstancePersonne;
        this.personInSameWagon.add(this);
      //  this.personInSameWagon.add(wagon.getNumWaon())
        // lier à toutes les personnes d'un meme wagon à la personne instancier dans le wagon
        Set<Personne> ps= new HashSet<>();
        ps=wg.getPersonInWagon();
        Iterator<Personne> itp=ps.iterator();
        while (itp.hasNext()) {
            Personne p=itp.next();
            System.out.println(itp.next());
            this.personInSameWagon.add(p);
        }


           // wagon1.setPersonInWagon();
        }


    public Personne(String name){
        this.idPerson=++nbInstancePersonne;
        //this.personInSameWagon.add(this);
        this.name=name;
    }




    public Personne( Wagon wg) {
        this.idPerson = ++nbInstancePersonne;
        this.wagon = wg;
        this.idWagonOfPerson = wg.getIdWagon();
        this.personInSameWagon.add(this);
         this.personInSameWagon.add(this);
        Set<Personne> ps= new HashSet<>();
        ps=wg.getPersonInWagon();
        Iterator<Personne> itp =ps.iterator();
        while (itp.hasNext()) {
            System.out.println(" une instance de p avec wagon ");
            this.personInSameWagon.add(itp.next());
        }




    }
        /*
        if(wagon1.getPersonInWagon()!=null){
            for (Personne p:wagon1.getPersonInWagon()){
                this.personInSameWagon.add(p);
            }
           Set<Personne> ps= wagon1.getPersonInWagon();
            ps.add(this);
            wagon1.setPersonInWagon(ps);
           */





    public Personne(){ }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon=wagon;

    }

    public static int getNbInstancePersonne() {
        return nbInstancePersonne;
    }

    public static void setNbInstancePersonne(int nbInstancePersonne) {
        Personne.nbInstancePersonne = nbInstancePersonne;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public Set<Personne> getPersonInSameWagon() {
        return this.personInSameWagon;
    }

    public void setPersonInSameWagon(Set<Personne> personInSameWagon) {
        this.personInSameWagon = personInSameWagon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return idPerson == personne.idPerson;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson);
    }

    public int getIdWagonOfPerson() {
        return idWagonOfPerson;
    }

    public void setIdWagonOfPerson(int idWagonOfPerson) {
        this.idWagonOfPerson = idWagonOfPerson;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "name='" + name + '\'' +
                //", wagon=" + wagon+
                ", idPerson=" + idPerson +
                ", idWagonOfPerson=" + idWagonOfPerson +
                //", personInSameWagon=" + personInSameWagon +
                '}';
    }

    public void monter(){
        System.out.println(" Les voyageurs ne move pas .Seuls les bandits bougent");

    }
    public void descendre(){
        System.out.println(" Les voyageurs ne move pas. Seuls les bandits bougent ");

    }
    public void avancer(){
        System.out.println(" Les voyageurs ne move pas. Seuls les bandits bougent");
    }
    public void reculer(){
        System.out.println(" Les voyageurs ne move pas. Seuls les bandits bougent ");

    }
}

