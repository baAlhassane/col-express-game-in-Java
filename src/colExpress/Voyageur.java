package colExpress;

import java.util.ArrayList;
import java.util.List;

public class Voyageur extends Personne {
    List<Butin> butins=new ArrayList<>();
    public Voyageur(String name,List<Butin> butins) {
        super(name);
        this.butins=butins;
    }

    public Voyageur( ) {
        super();
    }
}
