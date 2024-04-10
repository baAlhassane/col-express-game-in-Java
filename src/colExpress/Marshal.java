package colExpress;

public class Marshal extends Personne {
    public Marshal(String name, Wagon wagon) {
        super(name, wagon);
        this.setName("Marshal");

    }


    public Marshal( Wagon wagon) {
        super( wagon);
    }

    public void avancer(){

    }
}
