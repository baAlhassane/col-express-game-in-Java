package colExpress;

import Plateau.Plateau;
import modele.Cellule;

import java.util.*;


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
* Elle contien une variab
 */
    private static int nbrInstanceWagon=0;
    private  int nbrePersoneInWagon ;
    private final int nbrePersonInitialInWagon ;
    private int idWagon;
    private Set<Personne> personInWagon=new HashSet<>();
    /**
     * Un wagon est une matrice de 3 ligne et de 2 colonnes.
     * C'est pour servir de vue et de déplacement et de position du wagon du wagon.
     * */
private Cellule[][] placeOcuppedByWagonInPlateau=new Cellule[3][2];//
    List<Cellule> listPlaceOccuppedByWagon=new ArrayList<>();

    public Cellule[][] getPlaceOcuppedByWagonInPlateau() {
        return placeOcuppedByWagonInPlateau;
    }

    public void setPlaceOcuppedByWagonInPlateau(Cellule[][] placeOcuppedByWagonInPlateau) {
        this.placeOcuppedByWagonInPlateau = placeOcuppedByWagonInPlateau;
    }

    public List<Cellule> getListPlaceOccuppedByWagon() {
        return listPlaceOccuppedByWagon;
    }

    public void setListPlaceOccuppedByWagon(List<Cellule> listPlaceOccuppedByWagon) {
        this.listPlaceOccuppedByWagon = listPlaceOccuppedByWagon;
    }

    public Wagon(Personne p){

        this.idWagon=++ nbrInstanceWagon;
        nbrePersonInitialInWagon = 1;
        //this.personInWagon.add(new Personne(this));
        //this.personInWagon.add(p);
        Set<Personne> ps= new HashSet<>();
        ps=this.getPersonInWagon();
        Iterator<Personne> itp =ps.iterator();
        while (itp.hasNext()) {
            System.out.println(" une instance de p avec wagon ");
            //this.personInSameWagon.add(itp.next());
            this.personInWagon.add(itp.next());;
        }

    }

    public Wagon( int nbrePersonInitialInWagon){
        this.nbrePersonInitialInWagon = nbrePersonInitialInWagon;
        this.idWagon=++ nbrInstanceWagon;
     for(int i=0;i<this.nbrePersonInitialInWagon;i++){
         ++nbrePersoneInWagon;
         //int j=Personne.getNbInstancePersonne()+1;//On recupère le nbre de personnes
         //en ensuite on l'ajoute à 1 pour créer une nouvelle personne .
         // Car chaque personne a un idetifiant unique qui est la ieme instance de personne

         this.personInWagon.add(new Personne(this));
         //Personne.setNbInstancePersonne(j);// Ensuite on met à jour le nbre de personne instancier

     }


    }

    public Wagon(){
        this.idWagon=++ nbrInstanceWagon;
        nbrePersonInitialInWagon = 0;
        //this.placeOcuppedByWagonInPlateau

        //int init=this.idWagon;
        int ligne=this.idWagon;
        int colonne= Plateau.getLARGEUR()/2;


        for (int i=0;i<3;i++){
            for (int j=0;j<2;j++){
                this.placeOcuppedByWagonInPlateau[i][j]=Plateau.getPlateau()[ligne+i][colonne+j];
                this.placeOcuppedByWagonInPlateau[i][j].setOcupedCelluleInPlateay(false);
                this.listPlaceOccuppedByWagon.add(this.placeOcuppedByWagonInPlateau[i][j]);

            }



        }
    }

    public void addPersonneInWagon(Personne p){
        p.setWagon(this);
        p.setPersonInSameWagon(this.getPersonInWagon());
        this.personInWagon.add(p);
        ++this.nbrePersoneInWagon;
        p.setIdWagonOfPerson(this.getIdWagon());

        Random r = new Random();
        int n = r.nextInt(6);
        //la place attribue d'une personne dans le wagon est donnée alléatoitement.
        // et des qu'on attribut la classe on lui assigne sont etat a true;
        this.listPlaceOccuppedByWagon.get(6).setOcupedCelluleInPlateay(true);
       p.setPlaceofPersonneInWagon(this.listPlaceOccuppedByWagon.get(6));



    }

    public static int getNbrInstanceWagon() {
        return nbrInstanceWagon;
    }

    public static void setNbrInstanceWagon(int nbrInstanceWagon) {
        Wagon.nbrInstanceWagon = nbrInstanceWagon;
    }

    public int getNbrePersoneInWagon() {
        return this.nbrePersoneInWagon;
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

    public void setNbrePersoneInWagon(int nbrePersoneInWagon) {
        this.nbrePersoneInWagon = nbrePersoneInWagon;
    }

    public int getNbrePersonInitialInWagon() {
        return nbrePersonInitialInWagon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wagon wagon = (Wagon) o;
        return nbrePersoneInWagon == wagon.nbrePersoneInWagon && nbrePersonInitialInWagon == wagon.nbrePersonInitialInWagon && idWagon == wagon.idWagon && Objects.equals(personInWagon, wagon.personInWagon);
    }



    @Override
    public int hashCode() {
        return Objects.hash(nbrePersoneInWagon, nbrePersonInitialInWagon, idWagon, personInWagon);
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "nbrePersoneInWagon=" + nbrePersoneInWagon +
                ", nbrePersonInitialInWagon=" + nbrePersonInitialInWagon +
                ", idWagon=" + idWagon +
               //", p=" + p +
                ", personInWagon=" + personInWagon +
                '}';
    }
}
