package simpleFactory;
/**
 * Created by VVykhor on 15.04.2017.
 */
public class Demo {
    public static void main(String[] args) {
        NameFactory nameFactory = new NameFactory();
        Namer firstNamer = nameFactory.getName("FirstFirst");
        System.out.println(firstNamer.getFrname() + " " + firstNamer.getLname());
        Namer lastNamer = nameFactory.getName("LastFirst");
        System.out.println(lastNamer.getFrname() + " " + lastNamer.getLname());
    }
}
