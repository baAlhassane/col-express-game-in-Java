package modele;

import Plateau.Plateau;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cellule cellule = (Cellule) o;
        return posX == cellule.posX && postY == cellule.postY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, postY);
    }

    @Override
    public String toString() {
        return "Cellule{" +
                "posX=" + posX +
                ", postY=" + postY +
                ", ocupedCelluleInPlateay=" + ocupedCelluleInPlateay +
                '}';
    }
}
