package cache;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Demo {
    public static void main(String[] args) {
        DataAccessor accessor = new CacheAccessor();
        accessor.findProduct("SELECT product FROM product WHERE id=1");
        accessor.findProduct("SELECT product FROM product WHERE id=2");
        accessor.findProduct("SELECT product FROM product WHERE id=1");
        accessor.findProduct("SELECT product FROM product WHERE id=3");
        accessor.findProduct("SELECT product FROM product WHERE id=6");
        accessor.findProduct("SELECT product FROM product WHERE id=7");
    }
}
