package simpleFactory;

/**
 * Created by VVykhor on 15.04.2017.
 */
public class NameFactory {
    public Namer getName(String name) {
        if(name == null) {
            return null;
        } else {
            if(name.equals("FirstFirst")) {
                return new FirstFirst();
            } else if(name.equals("LastFirst")) {
                return new LastFirst();
            } else {
                return null;
            }
        }
    }
}
