package retryer;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Connector implements Retryable {

    private int counter = 0;

    public void connect() {
        ++counter;
        if(counter < 3) {
            throw new RuntimeException("Error");
        } else {
            System.out.println("Success");
        }
    }

}
