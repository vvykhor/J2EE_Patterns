package retryer;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Retryable retryable = new Retryer();
        retryable.connect();
    }
}