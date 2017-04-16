package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Cache {

    public Cache() {
        for(int i = 0; i < 5; ++i) {
            cacheData.put((REQUEST + i).hashCode(), new Product(i));
        }
    }

    private Map<Integer, Product> cacheData = new HashMap<>();
    private final String REQUEST = "SELECT product FROM product WHERE id=";

    public Product get(int key) {
        return cacheData.get(key);
    }

    public void put(int key, Product product) {
        cacheData.put(key, product);
    }

}
