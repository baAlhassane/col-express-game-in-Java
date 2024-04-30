package plateau;

import modele.Modele;

import java.util.Objects;

public class Cellule  {


    private int posX=0;
    private int postY=0;
    private boolean ocupedCelluleInPlateau=false;
    private boolean isOccupedByWagon=false;
    private boolean isOccupedByPersonInWagon=false;
    private Modele modele;

    public boolean isOccupedByPersonInWagon() {
        return isOccupedByPersonInWagon;
    }

    public void setOccupedByPersonInWagon(boolean occupedByPersonInWagon) {
        isOccupedByPersonInWagon = occupedByPersonInWagon;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }




    public boolean isOcupedCelluleInPlateau() {
        return ocupedCelluleInPlateau;
    }

    public boolean isOccupedByWagon() {
        return isOccupedByWagon;
    }

    public void setOccupedByWagon(boolean occupedByWagon) {
        isOccupedByWagon = occupedByWagon;
    }



    //private Plateau plateau;



    public boolean isOcupedCelluleInPlateay() {
        return ocupedCelluleInPlateau;
    }

    public void setOcupedCelluleInPlateau(boolean ocupedCelluleInPlateau) {
        this.ocupedCelluleInPlateau = ocupedCelluleInPlateau;
    }

    public Cellule(Modele m, int x, int y){
        this.posX=x;
        this.postY=y;
        //this.plateau=new Plateau();
        this.modele=m;
    }
    public Cellule(Cellule c){
        this.postY=c.postY;
        this.posX=c.posX;
        this.isOccupedByPersonInWagon=c.isOccupedByPersonInWagon;
        this.modele=c.modele;
        this.ocupedCelluleInPlateau=c.ocupedCelluleInPlateau;
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
                ", ocupedCelluleInPlateau=" + ocupedCelluleInPlateau +
                ", isOccupedByWagon=" + isOccupedByWagon +
                ", isOccupedByPersonInWagon=" + isOccupedByPersonInWagon +
                '}';
    }
}
