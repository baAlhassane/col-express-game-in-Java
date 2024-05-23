package Vue;

import modele.Modele;

import javax.swing.*;
import modele.Observer;

public class VueGrille extends JPanel implements Observer {

    /**
     * VuGrille etend Jpannel et implement  Observer pour les update. Mais ps les vu component
     *
     * */
    private Modele modele;
    public VueGrille(Modele modele) {
        this.modele=modele;
    }



    @Override
    public void update() {

    }
}
