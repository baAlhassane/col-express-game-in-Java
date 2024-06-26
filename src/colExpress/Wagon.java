package colExpress;

import modele.Modele;
import modele.Observer;
import plateau.Plateau;
import plateau.Cellule;

import javax.swing.*;

import java.util.*;


public class Wagon extends JPanel implements Observer {
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
    private  int nbrePersonInitialInWagon; ;
    private int idWagon;
    private int compteurCourant=0;

private Wagon wagon;
private int nbreInstanceCourantWagon; //-this.idWagon;

    private Set<Personne> personInWagon=new HashSet<>();
    private int longueurWagon;
    private static int  longueurTotalWagon=0;
    /**
     * Un wagon est une matrice de 3 ligne et de 2 colonnes.
     * C'est pour servir de vue et de déplacement et de position du wagon du wagon.
     * */

   //private  Plateau  plateau=new Plateau();

private Cellule[][] placeOcuppedByWagonInPlateau;//=new Cellule[3][2];//
    List<Cellule> listPlaceOccuppedByWagon=new ArrayList<>();
    private int distanceTotalWagonCourant=0;//la plus grand numero de ligne du wagon courant



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
        this.personInWagon.add(new Personne(this));
        this.personInWagon.add(p);
        Set<Personne> ps= new HashSet<>();
        ps=this.getPersonInWagon();
        Iterator<Personne> itp =ps.iterator();
        while (itp.hasNext()) {
            System.out.println(" une instance de p avec wagon ");
            //this.personInSameWagon.add(itp.next());
            this.personInWagon.add(itp.next());;
        }

    }

    public Wagon(int taille, int nbrePersonInitialInWagon){

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

    public int getNbreInstanceCourantWagon() {
        return nbreInstanceCourantWagon;
    }

    public void setNbreInstanceCourantWagon(int nbreInstanceCourantWagon) {
        //his.nbreInstanceCourantWagon = nbreInstanceCourantWagon;
    }

    public int getCompteurCourant() {
        return compteurCourant;
    }

    public void setCompteurCourant(int compteurCourant) {
        this.compteurCourant = compteurCourant;
    }

    public Wagon(){
        /**
         * Quand on instancie un wagon on donne les cellules qu'elle occupe.
         * On avait dit qu'elle occupe 3 ligne du plateau et 2 colonne du plateu.
         * Chaque colonne designe succesivement intereieur et l'exterieur du wagon.
         * donc une matrice 3*2 de type Cellule. Doc 6 cellules.
         * */
         this.placeOcuppedByWagonInPlateau=new Cellule[3][2];//
        this.idWagon=++ nbrInstanceWagon;
        nbrePersonInitialInWagon = 0;
        this.longueurWagon=3;
        this.compteurCourant++;
       longueurTotalWagon+=this.longueurWagon; //this.nbreInstanceCourantWagon*longueurWagon;
        //this.distanceTotalWagonCourant=idWagon*longueurWagon;// la plus grand numero de ligne du wagon courant

        //this.nbreInstanceCourantWagon=nbrInstanceWagon;//-this.idWagon;
        this.distanceTotalWagonCourant= this.idWagon*this.longueurWagon;//idWagon*longueurWagon;

        for (int i=0;i<3;i++){
            for (int j=0;j<2;j++){
               //this.placeOcuppedByWagonInPlateau[i][j]=new Cellule(i,j);

            }

        }

        //int init=this.idWagon;

        int ligne=this.idWagon;
        int colonne=Plateau.getLARGEUR()/2;

        //System.out.println("-------------------------------------------------------------");
       // System.out.println("Wagon contructeur vide  n° = "+this.idWagon+ ". Sa taille est   = "+this.longueurWagon+ " cellules ");
        for (int i=0;i<3;i++){
            for (int j=0;j<2;j++){
                //System.out.println(Plateau.getPlateau()[ligne*i][colonne+j]);

               // System.out.println(Plateau.getPlateau()[ligne*i][colonne+j]);

                Cellule c=Plateau.getPlateau()[ligne*3-2+i][colonne+j];
                c.setOcupedCelluleInPlateau(true);
                this.placeOcuppedByWagonInPlateau[i][j]=c;
                c.setOccupedByWagon(true);
                this.listPlaceOccuppedByWagon.add(c);
                System.out.print(" ("+c.getPosX()+(",")+c.getPostY()+")"+ " ");
               // this.placeOcuppedByWagonInPlateau[i][j]=Plateau.getPlateau()[ligne+i][colonne+j];//.[ligne+i][colonne+j];
               // this.placeOcuppedByWagonInPlateau[i][j].setOcupedCelluleInPlateay(false);
               //this.listPlaceOccuppedByWagon.add(this.placeOcuppedByWagonInPlateau[i][j]);

            }
            System.out.println(" ");



        }

    }

    public int getDistanceTotalWagonCourant() {
        return distanceTotalWagonCourant;
    }

    public void setDistanceTotalWagonCourant(int distanceTotalWagonCourant) {
        this.distanceTotalWagonCourant = distanceTotalWagonCourant;
    }

    public Wagon(int taille){
        /**
         * Quand on instancie un wagon on donne les cellules qu'elle occupe.
         * On avait dit qu'elle occupe 3 ligne du plateau et 2 colonne du plateu.
         * Chaque colonne designe succesivement intereieur et l'exterieur du wagon.
         * donc une matrice 3*2 de type Cellule. Doc 6 cellules.
         * */

        this.longueurWagon=taille;
        longueurTotalWagon+=this.longueurWagon;
        this.placeOcuppedByWagonInPlateau=new Cellule[this.longueurWagon][2];//
        this.idWagon=++ nbrInstanceWagon;
        nbrePersonInitialInWagon = 0;
        this.distanceTotalWagonCourant-=longueurWagon;// la plus grand numero de ligne du wagon courant
        for (int i=0;i<this.longueurWagon;i++){
            for (int j=0;j<2;j++){
                //this.placeOcuppedByWagonInPlateau[i][j]=new Cellule(i,j);
            }
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Wagon  n° = "+this.idWagon+ ". Sa taille est   = "+this.longueurWagon+ " cellules ");
        int ligne=this.idWagon;
        int colonne=Plateau.getLARGEUR()/2;

        for (int i=0;i<this.longueurWagon;i++){
            {
                for(int j=0;j<2;j++){
                   // Cellule c = Plateau.getPlateau()[ligne * taille - (taille - 1) + i][colonne + j];
                    int x=Wagon.longueurTotalWagon;
                    Cellule c = Plateau.getPlateau()[x + i-taille+1][colonne + j];

                    c.setOcupedCelluleInPlateau(false);
                    this.placeOcuppedByWagonInPlateau[i][j] = c;
                    c.setOccupedByWagon(true);
                   //System.out.println("cellle du wagon  N°  "+ligne+ " : ");
                    //System.out.print(c+ " - ");
                    System.out.print(" ("+c.getPosX()+(",")+c.getPostY()+")"+ " ");


                    this.listPlaceOccuppedByWagon.add(c);
                }

                System.out.println( "  ");
            }


        }

    }

    public static int getLongueurTotalWagon() {
        return longueurTotalWagon;
    }

    public static void setLongueurTotalWagon(int longueurTotalWagon) {
        Wagon.longueurTotalWagon = longueurTotalWagon;
    }

    public void addPersonneInWagon(Personne p){

        this.personInWagon.add(p);

        /**
        p.setWagon(this);
        Set<Personne> sp=new HashSet<>();
        sp= this.personInWagon;
        Cellule c= new Cellule(p.getPlaceOfPersonneInWagon());

        //sp.add(p);

            p.setPersonInSameWagon(sp);
            this.setPersonInWagon(sp);
            int x=p.getPlaceOfPersonneInWagon().getPosX();
            int y=p.getPlaceOfPersonneInWagon().getPostY();
            // Cellule c=new Cellule(,x,y);
        for(Personne pw :this.personInWagon){
                this.personInWagon.add(p);
                this.nbrePersoneInWagon=this.personInWagon.size();
                p.setIdWagonOfPerson(this.getIdWagon());
                this.personInWagon.add(p);
                this.nbrePersoneInWagon=this.personInWagon.size();
                p.setIdWagonOfPerson(this.getIdWagon());
        }
*/








            //donner une psotion au hasard

            Random r = new Random();
            int n = r.nextInt(6);
            //la place attribue d'une personne dans le wagon est donnée alléatoitement.
            // et des qu'on attribut la classe on lui assigne sont etat a true;

            /**
             * Cette partie est mis en commentaire après avir créé la methodes
             * createPersonneWithPosInWagon(TYPEPERSONNE typepersonne, Wagon w,int x, int y)
             * addPersonneWithPosInWagon(Personne p, Wagon w,int x, int y)
             * Car elle donne les position alléatoirement.
             * **/

            /**
            this.listPlaceOccuppedByWagon.get(n).setOcupedCelluleInPlateau(true);
            this.listPlaceOccuppedByWagon.get(n).setOccupedByWagon(true);
            this.listPlaceOccuppedByWagon.get(n).setOccupedByPersonInWagon(true);
            System.out.println("on est dans add wagon n° "+this.idWagon+" numPlace = "+n+" , "+this.listPlaceOccuppedByWagon.get(n));
            p.setPlaceOfPersonneInWagon(this.listPlaceOccuppedByWagon.get(n));
           **/





    }

    public void retirerPersonneInWagon(Personne p){
        if(this.personInWagon.contains(p)){
            this.personInWagon.remove(p);
            //p.placeOfPersonneInWagon.setOcupedCelluleInPlateau(false);
            p.placeOfPersonneInWagon.setOccupedByPersonInWagon(false);
            --this.nbrePersoneInWagon;

        }


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

    public int getLongueurWagon() {
        return longueurWagon;
    }

    public void setLongueurWagon(int longueurWagon) {
        this.longueurWagon = longueurWagon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wagon wagon = (Wagon) o;
        return idWagon == wagon.idWagon ;
    }




    @Override
    public int hashCode() {
        return Objects.hash( idWagon);
    }


    @Override
    public String toString() {
        return "Wagon{" +
                "nbrePersoneInWagon=" + nbrePersoneInWagon +
                ", nbrePersonInitialInWagon=" + nbrePersonInitialInWagon +
                ", idWagon=" + idWagon +
               //", p=" + p +
               // ", personInWagon=" + personInWagon +
                '}';
    }

    public void printPlacesOccopedByWagon(){
        int ligne=this.idWagon;
        int colonne=Plateau.getLARGEUR()/2;
        System.out.println(" Cellule du wagon num " +this.idWagon+ " :" );
        System.out.println(" ------------------------------------------ " );
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 2; j++) {
                //System.out.println(Plateau.getPlateau()[ligne+i][colonne+j]);
                System.out.println(Plateau.getPlateau()[ligne*3-2+i][colonne+j]) ;             //Cellule c = Plateau.getPlateau()[ligne + i][colonne + j];
            }
        }
        System.out.println(" ------------------------------------------ \n" );
    }

    public void setNbrePersonInitialInWagon(int nbrePersonInitialInWagon) {
        this.nbrePersonInitialInWagon = nbrePersonInitialInWagon;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }



    public Wagon(Wagon w){
       // this(w.getLongueurWagon());
        this.idWagon=w.getIdWagon();
        nbrInstanceWagon=nbrePersoneInWagon;
        this.personInWagon=w.getPersonInWagon();
        this.longueurWagon=w.longueurWagon;
        this.placeOcuppedByWagonInPlateau=w.placeOcuppedByWagonInPlateau;
        this.nbrePersoneInWagon=w.nbrePersoneInWagon;
        this.distanceTotalWagonCourant=w.distanceTotalWagonCourant;
        this.setPlaceOcuppedByWagonInPlateau(w.getPlaceOcuppedByWagonInPlateau());
        this.setListPlaceOccuppedByWagon(w.getListPlaceOccuppedByWagon());
        //nbrInstanceWagon=nbrePersoneInWagon;
/**
        this.longueurWagon=taille;
        longueurTotalWagon+=this.longueurWagon;
        this.placeOcuppedByWagonInPlateau=new Cellule[this.longueurWagon][2];//
        this.idWagon=++ nbrInstanceWagon;
        nbrePersonInitialInWagon = 0;
        this.distanceTotalWagonCourant=longueurTotalWagon;
 **/
    }



    public void update(){

    }






}
