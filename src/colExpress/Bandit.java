package colExpress;

import Plateau.Plateau;
import modele.Cellule;

import java.util.*;

public class Bandit extends Personne {

private Direction directionBandandi= Direction.IMMOBILE;
private ENVIRONNEMENT evironnementBandit=ENVIRONNEMENT.INTERIEUR;
Map<Butin,Integer> butins=new HashMap<>();
int dureeVie= (int)(Math.random()*10);
boolean estVivant=true;

    public Bandit(String name) {
        super(name);


    }



    public Bandit( Wagon wagon) {
        super( wagon);
    }

    public void evolutionBandit(){

    }

    void avancer(){
        /***
         *  avancer dans le wagon veut dire occuper toute les places du wagon
         *  suivant l'order du liste de places. Si on termine on se place aux wagon suivant ou précedent
         */
        int ligne=this.placeofPersonneInWagon.getPosX();

        if(this.wagon.getIdWagon()==1){
              // for (int i=0;i<this.wagon.getListPlaceOccuppedByWagon().size();i++)

            if(ligne<3){
                this.placeofPersonneInWagon.setPosX(ligne+1);
            }
            else{
                System.out.println(this.name+ " can't move forward  ! ");
                System.out.println(this.name+ " sort du    "+this.wagon.getIdWagon());
                System.out.println("pour aller au wagon suivant ");
                this.allerWagonSuivant();
            }
        }

        else{
            if(ligne%3==0){
                if(ligne<Wagon.getNbrInstanceWagon()){
                    //this.placeofPersonneInWagon.setPosX(ligne+1);
                    this.allerWagonSuivant();
                }
                /*
                else{
                    System.out.println(this.name+ " can't move forward  ! ");
                    System.out.println(this.name+ " sort du    "+this.wagon.getIdWagon());
                    System.out.println("On ne peut que reculer ");
                    this.reculer();
                }
                */

            }

        }



        /**
        int wagonId=this.wagon.getIdWagon();
          int nbreWagon= Wagon.getNbrInstanceWagon();
        switch (wagonId) {
            case 1:  System.out.println(this.name+ " can't move forward ! ");
                      break;
            case nbreWagon :  System.out.println(this.name+ " can't move forward ! ");
                break;
        }
         **/
    }

    private void allerWagonSuivant() {
        //ici l'enlever dans la liste des banddit présents dans son wagon courant  et
        // et le l'aajouter la liste des bandit du wagon suivant.
        this.wagon.retirerPersonneInWagon(this);
        this.wagon.setIdWagon(this.wagon.getIdWagon()+1);
        int ligne=this.placeofPersonneInWagon.getPosX();
        this.placeofPersonneInWagon.setPostY(ligne+1);
        this.wagon.addPersonneInWagon(this);
        this.placeofPersonneInWagon.setOcupedCelluleInPlateay(true);

    }



    private void reculer() {
        int ligne=this.placeofPersonneInWagon.getPosX();
        if(this.wagon.getIdWagon()== Wagon.getNbrInstanceWagon()){
            if(ligne==Wagon.getNbrInstanceWagon()){
                System.out.println(this.name+ "  move backward  ! ");
                Cellule suivante=this.placeofPersonneInWagon;
                if(!suivante.isOcupedCelluleInPlateay()){
                    this.placeofPersonneInWagon.setPosX(ligne-1);
                    this.placeofPersonneInWagon.setOcupedCelluleInPlateay(true);
                    //this.avancer();
                }
                else {
                    this.voler();
                }

            }

            if(ligne%3==0){
                System.out.println(this.name+ "  On est bordure de wagon du wagon "+this.wagon.getIdWagon());
                System.out.println(this.name+ "  on va au wagon précedent ");
                this.allerWagonPrecedant();
            }

        }



    }


    public void monter(){
        int colonne=this.placeofPersonneInWagon.getPostY();
        if(colonne== Plateau.getLONGUEUR()/2){
            this.placeofPersonneInWagon.setPostY(colonne+1);
            this.placeofPersonneInWagon.setOcupedCelluleInPlateay(true);
        }

        else {
            System.out.println("on peut pas monter car onest deja en haut");
        }

    }
    public void descendre(){
        int colonne=this.placeofPersonneInWagon.getPostY();
        if(colonne== (1+Plateau.getLONGUEUR()/2)) {
            this.placeofPersonneInWagon.setPostY(colonne-1);
            this.placeofPersonneInWagon.setOcupedCelluleInPlateay(true);
        }
        else {
            System.out.println("on peut pas descendre car on est déja en bas");

        }

    }

    private void allerWagonPrecedant() {
        this.wagon.retirerPersonneInWagon(this);
        this.wagon.setIdWagon(this.wagon.getIdWagon()-1);
        this.wagon.addPersonneInWagon(this);
        int ligne=this.placeofPersonneInWagon.getPosX();
        this.placeofPersonneInWagon.setPostY(ligne-1);
        this.placeofPersonneInWagon.setOcupedCelluleInPlateay(true);

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
Cellule cv=v.getPlaceofPersonneInWagon();
Cellule cb=this.placeofPersonneInWagon;
if(cv.equals(cb)){
    Set<Butin> butinSet=v.getButins().keySet();
    Map<Butin, Integer> bv=v.getButins();
    Random rd=new Random();
    int i=0;
    int n= rd.nextInt(butinSet.size());//choisir un butin au hasar
    if(!butinSet.isEmpty()) {
    for(Butin kb:butinSet){
        int vb=v.getButins().get(kb);
        if(i==n){
            this.butins.put(kb,vb);
            //v.butins.remove(kb);
            bv.remove(kb);
            v.setButins(bv);
            break;
        }
        i++;
    }

    }




}
}


public void addButinVoler(Butin b){
        this.butins.add(b);
        if(b.equals(Butin.MAGOT)){
            System.out.println("Jeux terminer le Margo est voléé");
            System.out.println("le gagant est le  Bandit "+this.name);

        }
}


}
