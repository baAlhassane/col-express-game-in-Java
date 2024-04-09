import java.util.Set;

public class Personne {

    protected String name;
    protected Wagon wagon;//this
    private static int nbInstancePersonne=0;
    private int idPerson;
    private Set<Personne> personInSameWagon;// personne dans le meme wagon qui s'entretire

    public Personne(String name, Wagon wagon){
        this.name=name;
        this.wagon=wagon;
        this.idPerson=++nbInstancePersonne;
      //  this.personInSameWagon.add(wagon.getNumWaon())
        // lier à toutes les personnes d'un meme wagon à la personne instancier dans le wagon
        for( Personne p : wagon.getPersonInWagon()){
            this.personInSameWagon.add(p);

        }


    }
    public Personne( int idPerson, Wagon wagon){

    }
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
        this.wagon = wagon;
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
        return personInSameWagon;
    }

    public void setPersonInSameWagon(Set<Personne> personInSameWagon) {
        this.personInSameWagon = personInSameWagon;
    }
}
