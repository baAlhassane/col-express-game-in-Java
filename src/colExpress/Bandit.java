package colExpress;

import java.util.ArrayList;
import java.util.List;

public class Bandit extends Personne {

private Direction directionBandandi= Direction.IMMOBILE;
private ENVIRONNEMENT evironnementBandit=ENVIRONNEMENT.INTERIEUR;
List<Butin> butins=new ArrayList<>();
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

        if(wagon.getIdWagon()==1){
            System.out.println(this.name+ " can't move forward ! ");
        }
        else{
            allerWagonSuivant();
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


    }



    private void reculer() {

        if(this.wagon.getIdWagon()== Wagon.getNbrInstanceWagon()){
            System.out.println(this.name+ " can't move back ! ");
        }
        else {
            allerWagonPrecedant();
        }


    }


    public void monter(){

    }
    public void descendre(){

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



}
