package Vue;

import modele.Modele;
import plateau.Plateau;

import javax.swing.*;
import java.awt.*;

public class VueGlobale {
/**
 * Ici la vue globale est un JFrame. Qui va conteneir d'autre vue de type de sous composant ie JPnnel ou JButton
 * JPanel peut conteneir aussi des composant de type Jbuuton
 *Il va referencier le modele. Et va etre construit à partir d'un modèle.
 *Et toutes les autres vues aussi vont le referencier.
 * Ceci veut dire que le modèle va les contenir.
 *
 *
 *
 * Cette frame est attaché à un modele. Frame peut ajjouter des composant de type Jpannel
 *
 *La méthde vue est associé aux modéle pour que la methode update puisse y accèder.
 * Parfois on le met en argument de update(Observable obs).
 *
 * La vue est aussi assicié à la classe du controlleur(Les Jbutton ou Jpannel par exemple).
 * Et c'est la vue qui crée son propre controlleur. Controleur ctrl = new Controleur(modele);
 * Le controlleur est aussi comme observateur de modele.
 *
 *
 *
 * La
 * */


private  JFrame frame;



    private VueGrille grille; //
    private VueCommandes commandes;



    public  VueGlobale(Modele modele){

        frame=new JFrame();
        frame.setTitle(" Vue Globale");
        grille=new VueGrille(modele);
        frame.add(grille);// grille est un comopsant car etand e Jpannel
        //grille est aussi un observer. pouvant etre observé et mettre à jour
        commandes=new VueCommandes(modele);

        frame.setLayout(new FlowLayout());


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }



}
