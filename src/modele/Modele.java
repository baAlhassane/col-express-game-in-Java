package modele;

import colExpress.Bandit;
import colExpress.Direction;
import plateau.Plateau;
import colExpress.Personne;
import colExpress.Wagon;

import java.util.*;


public class Modele extends  Observable{
 /**
  *Permet de stocker les instances des données métiers.
  * et de les afficher.
  * Il a des attributs qui permetron d'instancier un type métier. Et de faire des opération avec.
  * Généralement les objets de la couches métier son instanciés une seule fois.
  * Le controlleur va le contenir en stockant les données calcées des données metiers.
  *
  * Le modele etend Observable. Qui est donc un observateur.(JFRame est un observateur, ses sous composent
  * sont des observé.)
  * Pour ce la chaque sous composante de de JFrame doit implementer observer.
  * Donc le modèle est lié aussi à plusiuers vues.
  * */
    private LinkedList<Wagon> trains= new LinkedList<>();

    private Plateau plateau;

    Set<Personne> personnes=new HashSet<>();

    public Modele(){

    }


    public void addPersonInWagonModele(Personne p, Wagon w){
        /**
         * cette methode ajoute une personne à l'indice au wagon indice i
         * */

  if(this.trains.isEmpty()){
      //p.setIdWagonOfPerson(w.getIdWagon());
      p.setWagon(w);
      this.personnes.add(p);
      w.addPersonneInWagon(p);
      w.setNbrePersoneInWagon(0);
      //p.setPersonInSameWagon();
      this.trains.add(w);

  }
  else{

  if(trains.contains(w)){
      p.setIdWagonOfPerson(w.getIdWagon());
      w.addPersonneInWagon(p);
      p.setWagon(w);
    int x=  w.getNbrePersoneInWagon();
    w.setNbrePersonInitialInWagon(x);
    w.setNbrePersoneInWagon(x+1);
    w.retirerPersonneInWagon(p);
    personnes.add(p);


  }
  else {
      w.addPersonneInWagon(p);
      p.setIdWagonOfPerson(w.getIdWagon());
      trains.add(w);
      personnes.add(p);
  }

      /**
  System.out.println("else : ");
     int i=0;
     int j=0;
     Set<Personne> ps=new HashSet<>();
     LinkedList<Wagon>ls=new LinkedList<>();
     ls=this.trains;
      Iterator<Wagon> it=this.trains.iterator();
     while(it.hasNext()){
         System.out.println("else : apres it "+  ++j );
         Wagon ww=it.next();

        int id1= ww.getIdWagon();
         int id2=w.getIdWagon();
         System.out.println("else : apres id1 = "+id1 +" , id2 "+ id2 );

         if(id1==id2){
             System.out.println(" ww iterateur  if ww==ww");
             ps=ww.getPersonInWagon();
             ps.add(p);
             w.setPersonInWagon(ps);

             //this.trains.remove(ww);
             p.setIdWagonOfPerson(w.getIdWagon());
             this.personnes.add(p);
             w.addPersonneInWagon(p);
             //p.setPersonInSameWagon();
             //this.trains.add(w);

             i++;
         }

         else {
             ps=ww.getPersonInWagon();
             ps.add(p);
             w.setPersonInWagon(ps);
             this.trains.add(w);
             p.setIdWagonOfPerson(w.getIdWagon());
             this.personnes.add(p);
             w.addPersonneInWagon(p);
             i++;
         }




     }



        }//else

  **/




    }
    }




public void evoluer(){
        Iterator<Personne> it=personnes.iterator();
        while(it.hasNext()){
            Personne p=it.next();
                Random rd=new Random();
                int n= ( (int)(Math.random()*100) )%4;
                switch (n){
                    case 0: this.move(p,Direction.HAUT);
                    case 1: this.move(p,Direction.BAS);
                    case 2: this.move(p,Direction.AVANT);
                    case 3: this.move(p,Direction.ARRIERE);

                }


        }
}


public void move(Personne b, Direction d){
        /**
         * Faite avancer la personne p */
    Direction direction;
    switch( d )
    {
        case HAUT:
            System.out.println(" le movement est vers le  "+d);
            this.monter(b);
            break;
        case BAS :
            System.out.println(" le movement est vers le  "+d);
            this.descendre(b);
            break;
        case AVANT :
            System.out.println(" le movement est vers l' "+d);
            System.out.println("AVANT "+b.getPlaceOfPersonneInWagon());
            this.avancer(b);
            System.out.println(" APRES "+b.getPlaceOfPersonneInWagon());
            break;
        case ARRIERE:
            System.out.println(" le movement est vers l'  "+d );
            this.reculer(b);
        case IMMOBILE:
            System.out.println(d);
    }


}

public void avancer(Personne b){
        /**
         * Chercher la personne dans chaque wagon. Ensuite de le faire avancer
         * */
    Iterator<Wagon> itW=this.trains.iterator();
    Set<Personne>  listPersonInWagon=new HashSet<>();

    while(itW.hasNext()){
        Wagon w= itW.next();
        System.out.println(" dans le modele avant "+ w.getLongueurWagon());
        int i=0;
        listPersonInWagon=w.getPersonInWagon();
        for(Personne p: listPersonInWagon){
            System.out.println(" dans le modele avant "+ p.getName());
            if(p.equals(b)){
                p.avancer();
                System.out.println(" dans le modele if");
                System.out.println(p.getPlaceOfPersonneInWagon());
                w.getPersonInWagon().add(p);
                this.personnes.add(p);
                //int ligne = this.placeOfPersonneInWagon.getPosX();
                //int ligne=p.getPlaceOfPersonneInWagon().getPosX();

                int ligne = p.getPlaceOfPersonneInWagon().getPosX();
                //int taille=this.wagon.getLongueurWagon();
                int taille=p.getWagon().getDistanceTotalWagonCourant();
                int longueurTotal=Wagon.getLongueurTotalWagon();
                int idWagon=w.getIdWagon();

                if(( ligne<longueurTotal) && (ligne>taille)){
                    this.allerWagonSuivant();
                }


            }

        }

    }
}

    public void reculer(Personne b){
        Iterator<Wagon> itW=this.trains.iterator();
        Set<Personne>  listPersonInWagon=new HashSet<>();
        while(itW.hasNext()){
            Wagon w= itW.next();
            listPersonInWagon=w.getPersonInWagon();
            for(Personne p: listPersonInWagon){
                if(p.equals(b)){
                    b.reculer();
                }

            }

        }
    }

    public void monter(Personne b){
        Iterator<Wagon> itW=this.trains.iterator();
        Set<Personne>  listPersonInWagon=new HashSet<>();
        while(itW.hasNext()){
            Wagon w= itW.next();
            listPersonInWagon=w.getPersonInWagon();
            for(Personne p: listPersonInWagon){
                if(p.equals(b)){
                    b.monter();
                }

            }

        }
    }


    public void descendre(Personne b){
        Iterator<Wagon> itW=this.trains.iterator();
        Set<Personne>  listPersonInWagon=new HashSet<>();
        while(itW.hasNext()){
            Wagon w= itW.next();
            listPersonInWagon=w.getPersonInWagon();
            for(Personne p: listPersonInWagon){
                if(p.equals(b)){
                    b.descendre();
                }

            }

        }
    }



    private void allerWagonSuivant() {
        //ici l'enlever dans la liste des banddit présents dans son wagon courant  et
        // et le l'aajouter la liste des bandit du wagon suivant.

        Iterator<Wagon> itW=this.trains.iterator();
        Set<Personne>  listPersonInWagon=new HashSet<>();


                //p.placeOfPersonneInWagon.getPosX();
        int lastIndex=trains.size()-1;
        int i=0;
        while(itW.hasNext()){
            i++;
        }
            Wagon w= itW.next();
            int distanceTotalWagonCourant=w.getDistanceTotalWagonCourant();// la plus grand numero de ligne du wagon courant
            listPersonInWagon=w.getPersonInWagon();
            for(Personne pp: listPersonInWagon){
               // this.wagon.setIdWagon(this.wagon.getIdWagon()+1);
               // this.placeOfPersonneInWagon.setPosX(ligne+1); //.setPostY(ligne+1);
                //this.wagon.addPersonneInWagon(this);
                //this.placeOfPersonneInWagon.setOcupedCelluleInPlateau(true);
                int ligne=pp.getPlaceOfPersonneInWagon().getPosX();
                if(ligne>distanceTotalWagonCourant){
                System.out.println("on change de wage. le chagement est effectué dans le modele");
  if(i<lastIndex){
      Wagon suivant=trains.get(i+1);// le wagon suivant.
      pp.setWagon(suivant);// i va de 0 à trains.size()-2;
      //suivant.addPersonneInWagon(p);
      trains.get(i+1).addPersonneInWagon(pp);
     // w.retirerPersonneInWagon(p);
      trains.get(i).retirerPersonneInWagon(pp);
  }
            }
            }
        }


    public LinkedList<Wagon> getTrains() {
        return trains;
    }

    public void setTrains(LinkedList<Wagon> trains) {
        this.trains = trains;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Set<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Personne> personnes) {
        this.personnes = personnes;
    }
}
