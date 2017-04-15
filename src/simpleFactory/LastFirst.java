package simpleFactory;

/**
 * Created by VVykhor on 15.04.2017.
 */
public class LastFirst implements Namer {

    @Override
    public String getFrname() {
        return "First";
    }

    @Override
    public String getLname() {
        return "Last";
    }
}
