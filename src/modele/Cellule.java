package modele;

import Plateau.Plateau;

public class Cellule  {


    private int posX=0;
    private int postY=0;
    private boolean ocupedCelluleInPlateay=false;

    public boolean isOcupedCelluleInPlateay() {
        return ocupedCelluleInPlateay;
    }

    public void setOcupedCelluleInPlateay(boolean ocupedCelluleInPlateay) {
        this.ocupedCelluleInPlateay = ocupedCelluleInPlateay;
    }

    public Cellule(int x, int y){
        this.posX=x;
        this.postY=y;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPostY() {
        return postY;
    }

    public void setPostY(int postY) {
        this.postY = postY;
    }

}
