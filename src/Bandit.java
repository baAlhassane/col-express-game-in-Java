public class Bandit extends Personne {

private Direction directionBandandi=Direction.IMMOBILE;

    public Bandit(String name, Wagon wagon) {
        super(name, wagon);


    }

    public Bandit(int idPerson, Wagon wagon) {
        super(idPerson, wagon);
    }

    public void evolutionBandit(){

    }

    void avancer(){
        if(this.wagon.getIdWagon()==1){
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

        if(this.wagon.getIdWagon()==Wagon.getNbrInstanceWagon()){
            System.out.println(this.name+ " can't move back ! ");
        }
        else {
            allerWagonPrecedant();
        }

    }

    private void allerWagonPrecedant() {
    }


}
