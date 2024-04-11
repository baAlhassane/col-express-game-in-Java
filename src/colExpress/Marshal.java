package colExpress;

public class Marshal extends Personne {
    /**
     * Le marshal est une personne. qu
     * */
    private Direction direction=Direction.IMMOBILE;
    private Butin arme=Butin.ARME;
    private Wagon locomotive=new Locomotive();
    public Marshal( Wagon wagon) {
        super(wagon);
        this.setName("Marshal");

    }



    public void avancer(){

    }
    public void reculer(){

    }

    public void tirer(Bandit bandit){
       bandit.decrementerDureeDeVie();
    }
}
