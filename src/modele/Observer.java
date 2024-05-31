package modele;

public interface Observer {
    /**
     * Un observateur doit posséder une méthode [update] déclenchant la mise à
     * jour.
     *
     * L'objectif du pattern Observer est de définir une dépendance du type 1-n
     * entre des objects lorsque un objet change tous les objets dépendants en soient notifiés.
     * pour réagir conformément.
     *
     *
     * Cette classe n'a pas besoin d'enregistrer un ref surl'Observable et ses classes dérivé.
     *
     * Le modele MVC sépare le Modele les élements GUI(qui le manipule et le représentene :La vue et le Controlleur ).
     * Java gère cette séparation au moyen des Listener.
     *
     */
    public void update();
    /**
     * La version officielle de Java possède des paramètres précisant le
     * changement qui a eu lieu.
     */
}
