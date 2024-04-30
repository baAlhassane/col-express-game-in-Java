package modele;

import colExpress.*;
import plateau.Cellule;
import plateau.Plateau;

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

    public void addTrain(Wagon w){

    }

/**
 * Cette methode add des personne mais donnes des places alléatoirement.
 * **/
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



    }
    }


public void addWagon( Wagon w){
        if(this.trains.isEmpty()){
            w.setIdWagon(1);
            w.setNbreInstanceCourantWagon(1);
            w.setLongueurWagon(3);
            w.setDistanceTotalWagonCourant(3);
            Wagon.setNbrInstanceWagon(1);
            Wagon.setLongueurTotalWagon(1);
            this.trains.add(w);
        }
        else {
            int n=this.trains.size()+1;
            w.setIdWagon(n);
            w.setNbreInstanceCourantWagon(n);
            w.setLongueurWagon(w.getLongueurWagon());
            w.setDistanceTotalWagonCourant(trains.get(n-1).getDistanceTotalWagonCourant()+w.getLongueurWagon());
            Wagon.setNbrInstanceWagon(n);
            Wagon.setLongueurTotalWagon(n*w.getLongueurWagon());
            this.trains.add(w);
           // longueurTotalWagon+=this.nbreInstanceCourantWagon*longueurWagon;
        }

    //Wagon.setNbrInstanceWagon(w.getNbreInstanceCourantWagon());
}

public void evoluer(){
        Iterator<Personne> it=personnes.iterator();
        while(it.hasNext()){
            Personne p=it.next();
                Random rd=new Random();
                int n= ( (int)(Math.random()*100) )%4;
                switch (n){
                    //case 0: this.move(p,Direction.HAUT);
                    //case 1: this.move(p,Direction.BAS);
                   // case 2: this.move(p,Direction.AVANT);
                    //case 3: this.move(p,Direction.ARRIERE);

                }


        }
}


public void move(Personne b, Direction d, Wagon w){
        /**
         * Faite avancer la personne p */
    Direction direction;
    System.out.print("\n ######################### debut de chaque mouvement de "+ b.getName() +"   ############################ \n");
    System.out.print(" \n position  avant move \n = : (posX = "+b.getPlaceOfPersonneInWagon().getPosX()+" posY = "+b.getPlaceOfPersonneInWagon().getPostY() + " : \n");
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
            this.avancer(b, w);
            break;
        case ARRIERE:
            System.out.println(" le movement est vers l'  "+d );
            this.reculer(b);
        case IMMOBILE:
            System.out.println(d);
    }

    System.out.print(" \n pos apres move \n = : (posX = "+b.getPlaceOfPersonneInWagon().getPosX()+" posY = "+b.getPlaceOfPersonneInWagon().getPostY() +" \n");
    System.out.print(" \n ######################### Fin de chaque mouvement de "+ b.getName() + " ############################ \n ");


}

public void avancer(Personne b,Wagon w){
        /**
         * Chercher la personne dans chaque wagon. Ensuite de le faire avancer
         * */
    Iterator<Wagon> itW=this.trains.iterator();
    Set<Personne>  listPersonInWagon=new HashSet<>();
    int i=0;
    int j=0;
    int nbreInstance=0;
    //Wagon updateWagon=new Wagon();
    //Wagon.setNbrInstanceWagon(Wagon.getNbrInstanceWagon()-1);
   // Wagon removeWagon=new Wagon();
    //Wagon.setNbrInstanceWagon(Wagon.getNbrInstanceWagon()-1);
    //Wagon.setNbrInstanceWagon(Wagon.getNbrInstanceWagon()-1);

    //Wagon.setLongueurTotalWagon(Wagon.getNbrInstanceWagon()*3);
    System.out.println("\n nbre instance ds Wagon Modele.avancer(Personne b) =  "+Wagon.getNbrInstanceWagon());
    System.out.println(" longueurTotal ds modele.avancer(Personne b)=  "+Wagon.getLongueurTotalWagon()+"\n");

/**
    while(itW.hasNext()){
        Wagon w= itW.next();

        Wagon.setNbrInstanceWagon(Wagon.getNbrInstanceWagon()-1);
        removeWagon= new  Wagon(w);
        updateWagon=new  Wagon(w);

       // System.out.println(" Avancercer dans le modele avant le if w = "+w);
        listPersonInWagon=removeWagon.getPersonInWagon();
        if(listPersonInWagon.contains(b)){
            System.out.println("\n wagon "+ w.getIdWagon()+"  contains "+  b.getName()+ "  in Model.avancer   :   \n"+b+ "\n");
            b.avancer(removeWagon);
            System.out.print( "\n%%%%%%%%%%%%%%%% b apres if(listPersonInWagon.contains(b)) avancer dans Model.avancer(b) posX = "+ b.getPlaceOfPersonneInWagon().getPosX()+" %%%%%%%%%%%\n");
            this.personnes.add(b);
            //w.addPersonneInWagon(b);


            listPersonInWagon.add(b);
            removeWagon.setPersonInWagon(listPersonInWagon);
            updateWagon=removeWagon;
            updateWagon.setPersonInWagon(removeWagon.getPersonInWagon());
             j=i;
             w.setPersonInWagon(updateWagon.getPersonInWagon());
             //this.trains.addLast(w);
        }
        //System.out.println( "  listPersonInWagon "+ listPersonInWagon);


        i++;

    }
 **/
    b.avancer(w);

    int pos=b.getPlaceOfPersonneInWagon().getPosX();

    int longueurTotal=Wagon.getLongueurTotalWagon();
   // int idWagon=removeWagon.getIdWagon();
    //int sizeWagon=removeWagon.getLongueurWagon();
   // int distance=removeWagon.getDistanceTotalWagonCourant();

    //this.personnes.add(b);
    //this.trains.remove(removeWagon);
   // this.trains.add(j,updateWagon);
    int distance=w.getDistanceTotalWagonCourant();

    System.out.print(" \n pos dans Modele.avancer(b) avant if pos >  distance= "+distance);
    if(pos>distance){
        System.out.print(" \n  pos dans Modele.avancer(b) apres if ( pos > distance=   "+distance+ " ) pour aller au wagonSuivant\n  ");
  this.allerWagonSuivant(b);

    }


    this.personnes.add(b);

    //this.trains.remove(removeWagon);
    //updateWagon.setNbrePersoneInWagon();
    //this.trains.add(j,updateWagon);



    System.out.print(" \nbbbbbbbbbb b at the end of Modele.avancer(b) bbbbbbb ");
 System.out.print(b);
    System.out.print(" \nbbbbbbbbbbb b at the end of Modele.avancer(b)bbbbb ");
}

    private void allerWagonSuivant(Personne p) {
        //ici l'enlever dans la liste des banddit présents dans son wagon courant  et
        // et le l'aajouter la liste des bandit du wagon suivant.

        Iterator<Wagon> itW=this.trains.iterator();
        Set<Personne>  listPersonInWagon=new HashSet<>();

        //p.placeOfPersonneInWagon.getPosX();
        int lastIndex=trains.size()-1;
        int i=0;
        int j=0;

        int numPlacePerson=p.getIdWagonOfPerson();
        int pos=p.getPlaceOfPersonneInWagon().getPosX();
        Wagon suivant=new Wagon();
       // Wagon.setNbrInstanceWagon(Wagon.getNbrInstanceWagon()-1);
        Wagon remove=new Wagon();


       // int ligne=p.getNumPlaceInTrain();
        while(itW.hasNext()){
            Wagon w=new Wagon(itW.next());
            listPersonInWagon=w.getPersonInWagon();
            //System.out.println(" allerWagonSuivant(Personne p) dans le while iwt ="+w);
            System.out.println("\n  %%%%%%%%%%%%%%%%%%%% litespersonne  = \n"+listPersonInWagon+" ");


            //

           // Wagon.setNbrInstanceWagon(Wagon.getNbrInstanceWagon()-1);
            int distanceTotalWagonCourant=w.getDistanceTotalWagonCourant();// la plus grand numero de ligne du wagon courant
            listPersonInWagon=w.getPersonInWagon();
            //listPersonInWagon=p.getPersonInSameWagon();

            if(listPersonInWagon.contains(p) && (i<lastIndex) ){
                System.out.print("\n ##################### aller au wagonsuivant ! after if ########## \n");

                j=i;

                suivant= new Wagon(trains.get(j+1));
                //Wagon.setNbrInstanceWagon(Wagon.getNbrInstanceWagon()-1);
                //remove=new Wagon(trains.get(j+1));
                //Wagon.setLongueurTotalWagon(Wagon.getLongueurTotalWagon()-1);
                int ligne=p.getPlaceOfPersonneInWagon().getPosX();
                p.setWagon(suivant);

                p.setIdWagonOfPerson(suivant.getIdWagon());
                p.setPersonInSameWagon(suivant.getPersonInWagon());
                //this.removeExistingPersonInWagon(p,w);

                this.addBanditWithPosInWagon(p,suivant,1);
               //this.trains.remove(j);
               // this.trains.add(j,suivant);


            }

            i++;
        }
          this.trains.remove(j);
          this.trains.add(j,suivant);
        // this.trains.add(p.getWagon());
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


    /**
     * Jussqu'à l'a nous avons on a jouter une personne et on l'a ttribué une place alléatoite
     * Mainenant on va lui données une place dans le wagon.
     *
     */


    public void addWagonInTrain(Wagon w){
   if(!(this.trains.contains(w) )|| this.trains.isEmpty()){
       this.trains.add(w);
   }
   else {
       System.out.println(" \n trains contient deja ce wagon ! \n");
       return;
   }

    }
    public Personne createNewPersonneWithPosInWagon(TYPEPERSONNE typepersonne, Wagon w, int numPlace){
        List<Cellule> places=new ArrayList<>();
        places=w.getListPlaceOccuppedByWagon();
        int nbreplaceMax =w.getLongueurWagon();
        System.out.println("o on est dans Createde personne type "+ typepersonne);
        switch (typepersonne){
            case BANDIT -> {Bandit b= new Bandit("bandit"+w.getNbrePersoneInWagon()+1);
                              this.addBanditWithPosInWagon(b,w,numPlace);
                              System.out.println(" personne type "+ typepersonne+ " is created Successfullly" );
                              return  b;

                            }
            case MARSHAL ->{Marshal m= new Marshal(w);
                               this.addMarshaltWithPosInWagon(m,w,numPlace);
                               return m;
                           }
            case VOYAGEUR -> { Voyageur v= new Voyageur("bandit"+w.getNbrePersoneInWagon()+1);
                              System.out.println(" personne type "+ typepersonne+ " is created Successfullly" );
                             this.addVoyageurWithPosInWagon(v,w,numPlace);
                             return v;
                             }

        }
        return null;


    }
    public void addVoyageurWithPosInWagon(Personne p, Wagon w,int numPlace){
        List<Cellule> places=new ArrayList<>();
        List<Cellule> places1=new ArrayList<>();

        //this.addWagon(w);

        places=w.getListPlaceOccuppedByWagon();
        int nbreLigneMax =w.getLongueurWagon();

        places=w.getListPlaceOccuppedByWagon();

        for(Cellule c:places){
           if(c.getPostY()==45){
               places1.add(c);
           }
        }
       for(int i=0; i<places.size();i++){
           if(i>=3){
               places.add(i,places.remove(i));;
           }
       }

        System.out.print("places1 = \n" +places1+"  \n");
        System.out.print("places = \n" +places+"  \n");
       Cellule c=places.get(numPlace-1);


        System.out.print("\n places voyageur possible  \n ");
        for (Cellule cp:places1){
            System.out.println(" (" +cp.getPosX()+","+cp.getPostY()+ " )");

        }
        System.out.print("  \n ");
        if(c.isOccupedByPersonInWagon()){
            System.out.print("\n on est dans addVoyageurtWithPosInWagon .  place p est deja occupee  = \n "+c+ "\n ");
            throw new IllegalArgumentException(" Place deja ocuppe.  !! \n");
        }

        int longueurTotal=Wagon.getLongueurTotalWagon();
        int idWagon= p.getIdWagonOfPerson();//p.getWagon().getIdWagon();
        int sizeWagon=p.getWagon().getLongueurWagon();
        //int distance=this.wagon.getDistanceTotalWagonCourant();
        int idWagonPrecedent=p.getWagon().getIdWagon()-1;

        int numPlaceInWagon=numPlace;
        int tailleWagonPrecedent=trains.get(idWagonPrecedent-1).getLongueurWagon();
        int numPlaceInTraine=idWagonPrecedent*tailleWagonPrecedent+numPlaceInWagon;


        if(  (numPlace<= nbreLigneMax) && (numPlace>0)){

                // this.addPersonInWagonModele(p,w);// appelle donne la pace alléatoire.
            p.setNumPlaceInWagon(numPlaceInWagon);
            p.setNumPlaceInTrain(numPlaceInTraine);
                p.setWagon(w);
                p.setPersonInSameWagon(w.getPersonInWagon());
                w.setNbrePersoneInWagon(w.getNbrePersoneInWagon()+1);
                p.setIdWagonOfPerson(w.getIdWagon());

                c.setOccupedByWagon(true);
                c.setOccupedByPersonInWagon(true);
                c.setOcupedCelluleInPlateau(true);
                c.setOccupedByPersonInWagon(true);
                p.setPlaceOfPersonneInWagon(c);//affecte à la bonne place.

                p.setPersonInSameWagon(w.getPersonInWagon());
                w.addPersonneInWagon(p);
                //places1.add(numPlace-1,places1.remove(numPlace-1));
                this.personnes.add(p);
                //this.addWagonInTrain(w);
                // this.addTrain(w);
                //places1.add(numPlace-1,places1.remove(n);)
            places.remove(numPlace-1);
            places.add(numPlace-1,c);

            w.setListPlaceOccuppedByWagon(places);
            this.addWagonInTrain(w);

                System.out.println("on est dans addvoyageur  wagon n° "+w.getIdWagon()+"\n numero  place  = "+numPlace+" , "+ "\nplace = "+p.getPlaceOfPersonneInWagon());


        }
        else {
            throw new IllegalArgumentException(" le numéro de place pour les voyageur sont entre "+1 +" et "+ nbreLigneMax);
        }



    }



    public void addBanditWithPosInWagon(Personne p, Wagon w,int numPlace){
        List<Cellule> places=new ArrayList<>();
        List<Cellule> places1=new ArrayList<>();
        List<Cellule> places2=new ArrayList<>();
        places=w.getListPlaceOccuppedByWagon();
        System.out.print("\n on est dans addBandittWithPosIn nbre de place =  "+places.size());
        System.out.print("\n longuerTotalWagon ds addBanditWithPosInWagon=  "+Wagon.getLongueurTotalWagon());
        System.out.print("\n nbre instance ds addBanditWithPosInWagon=  "+Wagon.getNbrInstanceWagon());

        int nbreplaceMax =w.getLongueurWagon();
        places=w.getListPlaceOccuppedByWagon();

        for(Cellule c:places){
            if(c.getPostY()==45){
                places1.add(c);
            }
            else{
                  places2.add(c);
            }
        }

        for(int i=0; i<places.size();i++){
            if(i>=3){
               // places1.add(places.get(i));
            }
        }

        for(Cellule c:places2) {
            places1.add(c);
        }



       // for(Cellule i : places){ places1.add(i);}
        System.out.print("\n on est dans addBandittWithPosIn size apres =  "+places1.size());

        Cellule c=places1.get(numPlace-1);
        if(c.isOccupedByPersonInWagon()){
            System.out.print("\n on est dans addBandittWithPosInWagon .  place p est deja occupee  = \n "+c+ "\n ");
            throw new IllegalArgumentException("\nPlace deja ocuppe . \n !! ");
        }
        System.out.print("\n XXXXXXXXXXXXXXXXXXXXX places1 Bandit possible XXXXXXXXXXXXXXXXXXXXXX : \n ");
        for (Cellule cp:places1){

            System.out.println(" ( " +cp.getPosX()+","+cp.getPostY()+ " )");

        }

        int numPlaceInWagon=numPlace;
        int longueurTotal=Wagon.getLongueurTotalWagon();
       int idWagon=w.getIdWagon();
        int sizeWagon=w.getLongueurWagon();
        //int distance=this.wagon.getDistanceTotalWagonCourant();
        int idWagonPrecedent=w.getIdWagon()-1;

        int tailleWagonPrecedent=-1; //this.trains.get(idWagonPrecedent-1).getLongueurWagon();
        int numPlaceInTrain=-1;//idWagonPrecedent*tailleWagonPrecedent+numPlaceInWagon;
        int distance=w.getDistanceTotalWagonCourant();

     this.addWagonInTrain(w);
     if(this.trains.size()<=1){
         tailleWagonPrecedent=0;
         numPlaceInTrain=numPlace;
     }else {
          tailleWagonPrecedent=this.trains.get(idWagonPrecedent-1).getLongueurWagon();
          numPlaceInTrain=idWagonPrecedent*tailleWagonPrecedent+numPlaceInWagon;
          distance=w.getDistanceTotalWagonCourant();
     }

        if(  (numPlace<=places.size()) && (numPlace>0)){
            // this.addPersonInWagonModele(p,w);// appelle donne la pace alléatoire.
                    //new Cellule(this,places.get(numPlace-1).getPosX(),places.get(numPlace-1).getPostY());

                p.setNumPlaceInWagon(numPlaceInWagon);
                p.setNumPlaceInTrain(numPlaceInTrain);
                p.setPlaceOfPersonneInWagon(c);
                p.setWagon(w);
                p.setIdWagonOfPerson(w.getIdWagon());
                Set<Personne>personnesInWagon=w.getPersonInWagon();
                personnesInWagon.add(p);
                p.setPersonInSameWagon(personnesInWagon);
                w.setPersonInWagon(personnesInWagon);
                w.setNbrePersoneInWagon(w.getNbrePersoneInWagon()+1);
                p.setIdWagonOfPerson(w.getIdWagon());
                p.setPlaceOfPersonneInWagon(c);//affecte à la bonne place.
                p.setPersonInSameWagon(w.getPersonInWagon());
                c.setOccupedByPersonInWagon(true);
                c.setOccupedByWagon(true);

            places1.remove(numPlace-1);
            places1.add(numPlace-1,c);
            w.setListPlaceOccuppedByWagon(places1);
                this.personnes.add(p);
                w.addPersonneInWagon(p);

               // this.addWagonInTrain(w);
                 this.addTrain(w);
                System.out.println("\non est dans add Bandit wagon n° "+w.getIdWagon()+" num  place  = "+numPlace+" , "+ " place = "+p+"\n");
            //System.out.println("\n" +personnesInWagon+"\n");


        }
        else {
            System.out.println("\n Les places du bandit doivent etre continue entre  "+1 +" et "+ places.size()/2+"\n") ;
            throw new IllegalArgumentException("  \nLes places du bandit doivent etre continue entre  \"+1 " +" et "+ places.size()/2);

        }


    }

    public void addMarshaltWithPosInWagon(Personne p, Wagon w,int numPlace){
        List<Cellule> places=new ArrayList<>();
        List<Cellule> places1= new ArrayList<>();//w.getListPlaceOccuppedByWagon();
        places=w.getListPlaceOccuppedByWagon();
        int nbreplaceMax =w.getLongueurWagon();
        System.out.print("\n on est dans addMarshaltWithPosInWagon size = "+places.size());

        for(Cellule c:places){
            if(c.getPostY()==45){
                places1.add(c);
            }
        }

        for(int i=0; i<places.size();i++){
            if(i>=3){
                places.add(i,places.remove(i));;
            }
        }
        System.out.print(" \nplace marshal possible \n");
        for (Cellule cp:places1){
            System.out.println(" ( " +cp.getPosX()+","+cp.getPostY()+ " )");

        }
        System.out.print("  \n ");
        Cellule c= new Cellule( places.get(numPlace-1));

        if(c.isOccupedByPersonInWagon()){
            System.out.print("\n on est dans addMarshaltWithPosInWagon .  place p est deja occupee  = \n "+c+ "\n ");
            throw new IllegalArgumentException("\nPlace deja ocuppe. \n !! ");

        }

        int longueurTotal=Wagon.getLongueurTotalWagon();
        int idWagon=w.getIdWagon();
        int sizeWagon=w.getLongueurWagon();
        //int distance=this.wagon.getDistanceTotalWagonCourant();
        int idWagonPrecedent=idWagon-1;
        int tailleWagonPrecedent=-1;
        int numPlaceInTraine=-1;
        int numPlaceInWagon=numPlace;

        tailleWagonPrecedent=-1;//;this.trains.get(idWagonPrecedent-1).getLongueurWagon();
       int numPlaceInTrain= -1; //idWagonPrecedent*tailleWagonPrecedent+numPlaceInWagon;
        int distance=w.getDistanceTotalWagonCourant();

         numPlaceInWagon=numPlace;
        numPlaceInTraine= p.getNumPlaceInTrain();

       this.addWagonInTrain(w);
       if(this.trains.size()<=1){
           tailleWagonPrecedent=0;
           numPlaceInTraine =numPlaceInWagon;
       }
       else{
           tailleWagonPrecedent=this.trains.get(idWagonPrecedent-1).getLongueurWagon();
           numPlaceInTrain=idWagonPrecedent*tailleWagonPrecedent+numPlaceInWagon;
           distance=w.getDistanceTotalWagonCourant();
       }


        //c.setOccupedByPersonInWagon(true);

        if((w.getIdWagon()==1) && (numPlace<= places1.size())){
            if(!c.isOccupedByPersonInWagon()){
                p.setNumPlaceInWagon(numPlaceInWagon);
                p.setNumPlaceInTrain(numPlaceInTraine);
                p.setWagon(w);
                p.setPersonInSameWagon(w.getPersonInWagon());
                w.setNbrePersoneInWagon(w.getNbrePersoneInWagon()+1);
                p.setIdWagonOfPerson(w.getIdWagon());
                p.setPlaceOfPersonneInWagon(c);//affecte à la bonne place.
                c.setOccupedByPersonInWagon(true);
                c.setOccupedByWagon(true);
                places.remove(numPlace-1);
                places.add(numPlace-1,c);
                w.setListPlaceOccuppedByWagon(places);

                this.personnes.add(p);
                this.personnes.add(p);
                w.addPersonneInWagon(p);
                this.addWagonInTrain(w);
                this.addTrain(w);

                System.out.println("\n on est dans add Marshal  wagon n° "+w.getIdWagon()+" num  place  = "+numPlace+" , "+ " place = "+p+"\n");

            }



        }
        else {
            System.out.println(" Le numero wago doit etre = 1.  cette placce n'exise pas pour le marcshal. ");
            throw new IllegalArgumentException("  le marshal doit etre dans le wagon num 1 et ");
        }




    }


    public void removeExistingPersonInWagon(Personne p, Wagon w){
        w.retirerPersonneInWagon(p);

    }

}
