package cache;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.findProduct("SELECT product FROM product WHERE id=1");
        cache.findProduct("SELECT product FROM product WHERE id=2");
        cache.findProduct("SELECT product FROM product WHERE id=1");
        cache.findProduct("SELECT product FROM product WHERE id=3");
    }
}
