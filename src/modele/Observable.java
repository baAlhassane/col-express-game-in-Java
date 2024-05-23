package modele;


import java.util.ArrayList;

/**
 * Classe des objets pouvant être observés.
 */
abstract class Observable {
    /**
     * On a une liste [observers] d'observateurs, initialement vide, à laquelle
     * viennent s'inscrire les observateurs via la méthode [addObserver].
     */
    private ArrayList<Observer> observers;
    public Observable() {
        this.observers = new ArrayList<Observer>();
    }
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Obsevable c'est juste la classe des objeys pouvant etre observé.
     * C'est en faite les données du modele. C'est pour cela le modele l'etant pour etre observé.
     *
     * Pour notifier le modele on fait la mise a jour de ses composants ou objet observer.
     * Et contient une liste d'observer. qui sont des composant Jpannel et objet Observer .
     * Lorsque l'état de l'objet observé change, il est convenu d'appeler la
     * méthode [notifyObservers] pour prévenir l'ensemble des observateurs
     * enregistrés.
     * On le fait ici concrètement en appelant la méthode [update] de chaque
     * observateur.
     *
     *
     */
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }
}
/** Fin du schéma observateur/observé. */