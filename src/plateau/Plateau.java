package plateau;

import modele.Modele;

public class Plateau {
    private  static final int LONGUEUR=90; ;
    private static final int LARGEUR=90;
    private static   Cellule [][]plateau=new Cellule[LONGUEUR][LARGEUR];
    private Modele modele;

/**
    private Plateau( int longueur, int largeur) {
        //this.plateau=new Cellule[LARGEUR][LARGEUR];
        for (int i=0;i<this.LONGUEUR;i++){
            for (int j=0;j<this.LARGEUR;j++){
            plateau[i][j]=new Cellule(i,j);
            plateau[i][j].setOcupedCelluleInPlateay(false);
            }


        }
    }
 **/
    public Plateau(Modele m) {
        for (int i = 0; i < this.LONGUEUR; i++) {
            for (int j = 0; j < this.LARGEUR; j++) {
              this.plateau[i][j] = new Cellule(m,i, j);
              this.plateau[i][j].setOcupedCelluleInPlateau(false);
            }
        }
        this.modele=m;
    }
/*
    public static Plateau make_plateau(){
        return new Plateau();
    }

 */

    public  static Cellule[][] getPlateau() {

        return plateau;
    }



    public static int getLONGUEUR() {
        return LONGUEUR;
    }

    public static int getLARGEUR() {
        return LARGEUR;
    }
}
