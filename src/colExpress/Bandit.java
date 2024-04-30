package colExpress;

import modele.Modele;
import plateau.Plateau;
import plateau.Cellule;

import java.util.*;

public class Bandit extends Personne {

private Direction directionBandandi= Direction.IMMOBILE;
private ENVIRONNEMENT evironnementBandit=ENVIRONNEMENT.INTERIEUR;
Map<Butin,Integer> butins=new HashMap<>();
int dureeVie= (int)(Math.random()*10);
boolean estVivant=true;
private String name;
    private int idPerson;

    private static Modele modele;
    public Bandit(String name) {
        super(name);
        this.name=name;
        this.setIdWagonOfPerson(this.getIdPerson());
        this.idPerson=super.getIdPerson();
        this.numPlaceInWagon=0;
        this.numPlaceInTrain=0;
        this.modele= this.placeOfPersonneInWagon.getModele();




    }






    public Bandit( Wagon wagon) {
        super( wagon);
    }

    public Bandit( ) {
        super( );
    }

    public void evolutionBandit(){

    }

   public void avancer(Wagon w) {
        /** Tout ce bla bla de if else est un test. A ce stade on a pas fait le modele
         * Une fois le modele mis en place c'est a lui de gerer les deplacement et changement de wagon.
         * Donc on le met en commentaire et faire   this.placeOfPersonneInWagon.setPosX(ligne + 1);
         * Et le reste est gérer par le modele.
         * **/

        /***
         *  avancer dans le wagon veut dire occuper toute les places du wagon
         *  suivant l'order du liste de places. Si on termine on se place aux wagon suivant ou précedent
         */

       int idPrecent=0;
       int taillePrecedent=0;
       int ligne=0;

       int pos = this.placeOfPersonneInWagon.getPosX();
       int posy=this.placeOfPersonneInWagon.getPostY();


       //this.numPlaceInWagon=this.wagon.getNumplaceInWagon();

       //int taille=this.wagon.getLongueurWagon();
      // int distance=this.wagon.getIdWagon()*this.wagon.getLongueurWagon();

       int distanceCourant= w.getDistanceTotalWagonCourant(); //this.wagon.getNbreInstanceCourantWagon()*this.wagon.getLongueurWagon();
       int longueurTotal= Wagon.getLongueurTotalWagon();
       int compteur=Wagon.getNbrInstanceWagon()-w.getCompteurCourant();
               //Wagon.getLongueurTotalWagon();
  int dif=-distanceCourant+longueurTotal;


       //System.out.println(" avancer dans bandit");
       System.out.println(" \nwagon id = "+this.wagon.getIdWagon()+ " on est dans Bandit.avancer()"+" distance = "+distanceCourant);
       System.out.println("pos = " +pos+ " ligne = "+ligne+" longuertotal = "+longueurTotal);
       ///System.out.print("\n on est dans addBandittWithPosIn size=  "+places.size());
       System.out.print(" nbre instance ds Wagon Bandit.avancer()=  "+Wagon.getNbrInstanceWagon()+"\n");
       System.out.print(" longueurTotal ds Bandit.avancer()=  "+Wagon.getLongueurTotalWagon()+" dif = "+ dif+"\n");




       int pas=pos+1;
       int numpas=numPlaceInWagon+1;

       if((pas<longueurTotal )){
           System.out.println(" On est dans Bandit.avancer() dans le if distance :  pos courant+1 ="+pas+" <= distance ="+longueurTotal);
           System.out.println(" \n");
           this.placeOfPersonneInWagon.setPosX(pas);
           this.placeOfPersonneInWagon.setOccupedByPersonInWagon(true);
           this.setPlaceOfPersonneInWagon(this.placeOfPersonneInWagon);
           this.setIdWagonOfPerson(w.getIdWagon());
           this.setNumPlaceInTrain(numPlaceInWagon);
           this.setNumPlaceInTrain(pas);
           this.personInSameWagon.add(this);
           this.setWagon(w);
           Wagon.setNbrInstanceWagon(wagon.getDistanceTotalWagonCourant());
           //this.wagon.setWagon(this.);
           //this.wagon.addPersonneInWagon(this);

       }
       else {
           System.out.print("\n ligne ou pos > LongueurTotalWagon ! Dans Bandit.avancer(). \n");
           throw new IllegalArgumentException(" \n on depasse le nbere ligne max du trains.s \n");
       }



    }

    /** On met cette methode dans le modele **/
    /** Mes cette methode est utiliser pour faire des tests avant que me modele ne soit données.**/
    private void allerWagonSuivant() {
        //ici l'enlever dans la liste des banddit présents dans son wagon courant  et
        // et le l'aajouter la liste des bandit du wagon suivant.

        int pos = this.placeOfPersonneInWagon.getPosX();
        if (pos < Wagon.getLongueurTotalWagon()) {

            this.wagon.setIdWagon(this.wagon.getIdWagon() + 1);
            this.wagon.addPersonneInWagon(this);
            this.placeOfPersonneInWagon.setOcupedCelluleInPlateau(true);
        } else {
            System.out.println(" On est au dernier wagon. on peut plus avancer  ");


/**
 this.wagon.retirerPersonneInWagon(this);
 this.wagon.setIdWagon(this.wagon.getIdWagon()+1);
 int ligne=this.placeofPersonneInWagon.getPosX();
 this.placeofPersonneInWagon.setPostY(ligne+1);
 this.wagon.addPersonneInWagon(this);
 this.placeofPersonneInWagon.setOcupedCelluleInPlateay(true);
 */


        }
    }


    public void reculer() {

        if(this.wagon.getIdWagon()== Wagon.getNbrInstanceWagon()){
            System.out.println(this.name+ " can't move back ! ");
        }
        else {
            allerWagonPrecedant();
        }


    }

    public boolean isEstVivant() {
        return estVivant;
    }

    public void setEstVivant(boolean estVivant) {
        this.estVivant = estVivant;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void monter(){
        int colonne=this.placeOfPersonneInWagon.getPostY();
        System.out.println("colonne "+colonne);
        if(colonne == Plateau.getLARGEUR()/2){
            this.placeOfPersonneInWagon.setPostY(colonne+1);
            this.placeOfPersonneInWagon.setOcupedCelluleInPlateau(true);
        }

        else {
            System.out.println("on peut pas monter car onest deja en haut");
        }

    }
    public void descendre(){
        int colonne=this.placeOfPersonneInWagon.getPostY();
        if(colonne== (1+Plateau.getLARGEUR()/2)) {
            this.placeOfPersonneInWagon.setPostY(colonne-1);
            this.placeOfPersonneInWagon.setOcupedCelluleInPlateau(true);
        }
        else {
            System.out.println("on peut pas descendre car on est déja en bas");

        }
    }

    private void allerWagonPrecedant() {
    }

void decrementerDureeDeVie(){
        if (this.dureeVie>0){
            --this.dureeVie;
        }
        else{
          this.estVivant=false;
        }


}

public void voler(Voyageur v){
    Cellule cv=v.getPlaceOfPersonneInWagon();//cellule voyageur
    Cellule cb=this.placeOfPersonneInWagon; //cellule bandit
    if(cv.equals(cb)){
        Set<Butin> butinSet=v.getButins().keySet();
        Map<Butin, Integer> bv=v.getButins();
        Random rd=new Random();
        int i=0;
        int n= rd.nextInt(butinSet.size());//choisir un butin au hasar
        if(!butinSet.isEmpty()) {
            for(Butin kb:butinSet){
                int vb=v.getButins().get(kb);
                if(i==n){ // choisir un butin au hasard.
                    //v.butins.remove(kb);
                    bv.remove(kb);
                    v.setButins(bv);
                    this.addButinVoler(kb,vb);

                    this.butins.put(kb,vb);
                    //v.butins.remove(kb);
                    bv.remove(kb);
                    v.setButins(bv);
                    v.setRobbded(true);
                    v.crieVoyageur();

                    break;
                }
                i++;
            }

        }




    }
}

    private void addButinVoler(Butin kb, int vb) {
        this.butins.put(kb,vb);
    }

    void incrementerDureeDeVie(){
        ++this.dureeVie;

    }

    @Override
    public String toString() {
        return "Bandit{" +
               // "directionBandandi=" + directionBandandi +
               // ", evironnementBandit=" + evironnementBandit +
                //", butins=" + butins +
               // ", dureeVie=" + dureeVie +
               // ", estVivant=" + estVivant +
                " name='" + name + '\'' +
                ", idPerson=" + this.getIdPerson()+
                 ", idWagon="+this.getIdWagonOfPerson()+
                ", placeOfPersonneInWagon=" + placeOfPersonneInWagon +
                '}';
    }
}
