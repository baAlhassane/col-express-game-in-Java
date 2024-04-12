package colExpress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Voyageur extends Personne {
   private Map<Butin,Integer> butins=new HashMap<>();
    public Voyageur(String name , Map<Butin,Integer> butins) {
        super(name);
        this.butins=butins;
    }

    public Voyageur( ) {
        super();
    }

    public Map<Butin, Integer> getButins() {
        return butins;
    }

    public void setButins(Map<Butin,Integer> butins) {
        this.butins = butins;
    }
}
