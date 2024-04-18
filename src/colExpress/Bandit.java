package colExpress;

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

    public Bandit(String name) {
        super(name);
        this.name=name;



    }



    public Bandit( Wagon wagon) {
        super( wagon);
    }

    public void evolutionBandit(){

    }

   public void avancer() {
        /** Tout ce bla bla de if else est un test. A ce stade on a pas fait le modele
         * Une fois le modele mis en place c'est a lui de gerer les deplacement et changement de wagon.
         * Donc on le met en commentaire et faire   this.placeOfPersonneInWagon.setPosX(ligne + 1);
         * Et le reste est gérer par le modele.
         * **/

        /***
         *  avancer dans le wagon veut dire occuper toute les places du wagon
         *  suivant l'order du liste de places. Si on termine on se place aux wagon suivant ou précedent
         */


       int ligne = this.placeOfPersonneInWagon.getPosX();
       //int taille=this.wagon.getLongueurWagon();
       int distance=this.wagon.getDistanceTotalWagonCourant();

       System.out.println(" avancer dans bandit");
       System.out.println(" wagon id "+this.wagon);
       int longueurTotal=Wagon.getLongueurTotalWagon();
       int idWagon=this.wagon.getIdWagon();
       if(ligne<distance){
           System.out.println(" avancer dans bandit");
           this.placeOfPersonneInWagon.setPosX(ligne+1);
       }



/*
      // tout ca est pris en compte par lemodele. C'est pour cela on la mis en commentaire

       int ligne = this.placeOfPersonneInWagon.getPosX();
       //int taille=this.wagon.getLongueurWagon();
       int distance=this.wagon.getDistanceTotalWagonCourant();
       int longueurTotal=Wagon.getLongueurTotalWagon();
       int idWagon=this.wagon.getIdWagon();

       //this.placeOfPersonneInWagon.setPosX(ligne + 1);
       if ((idWagon >= 1) && (ligne<distance) ) {
           System.out.println(" avancer badit  XXXXX");
           //this.placeOfPersonneInWagon.setPosX(ligne + 1);

           this.placeOfPersonneInWagon.setPosX(ligne + 1);

       }
       else {
           System.out.println(" un pas de plus on sort du wagon. ");
          // this.allerWagonSuivant();
       }

 */





    }

    /** On met cette methode dans le modele **/
    /** Mes cette methode est utiliser pour faire des tests avant que me modele ne soit données.**/
    private void allerWagonSuivant() {
        //ici l'enlever dans la liste des banddit présents dans son wagon courant  et
        // et le l'aajouter la liste des bandit du wagon suivant.

        int ligne = this.placeOfPersonneInWagon.getPosX();
        if (ligne < Wagon.getLongueurTotalWagon()) {
            this.wagon.setIdWagon(this.wagon.getIdWagon() + 1);
            this.placeOfPersonneInWagon.setPosX(ligne + 1); //.setPostY(ligne+1);
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




}
