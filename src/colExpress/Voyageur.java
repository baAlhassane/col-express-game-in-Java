package colExpress;

import java.util.HashMap;
import java.util.Map;

public class Voyageur extends Personne {
   private Map<Butin,Integer> butins=new HashMap<>();
   private boolean isRobbded;

    public boolean isRobbded() {
        return isRobbded;
    }

    public void setRobbded(boolean robbded) {
        isRobbded = robbded;
    }

    public Voyageur(String name , Map<Butin,Integer> butins) {
        super(name);
        this.name=name;
        this.butins=butins;
    }
    public Voyageur(String name) {
        super(name);
        this.name=name;
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


    public void crieVoyageur(){
        System.out.println(" oh my goo. Je suis volée");
    }

    @Override
    public void avancer(Wagon removeWagon){
        super.avancer(removeWagon);
    }




}
