package colExpress;

public class Locomotive extends Wagon{
    private Butin magot=Butin.MAGOT;
    Personne marshal=new Marshal(this);
    public Locomotive(){
        super();
        marshal.setName("Marcshal");
    }


}
