package retryer;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Retryer implements Retryable {

    private Connector c;

    public Retryer() {
        c = new Connector();
    }

    public void connect() {
        for(int i=0; i<5; ++i) {
            try {
                c.connect();
                return;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Try again");
            }
        }
    }

}
