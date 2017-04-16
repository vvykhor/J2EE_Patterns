package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Cache {

    private Database database = new Database();
    private Map<Integer, Product> cacheData = new HashMap<>();
    private final String REQUEST = "SELECT product FROM product WHERE id=";

    public Cache() {
        for(int i = 0; i < 5; ++i) {
            cacheData.put((REQUEST + i).hashCode(), new Product(i));
        }
    }

    public Product findProduct(String request) {
        int hashCode = request.hashCode();
        if(cacheData.containsKey(hashCode)) {
            System.out.println("get from cache");
            return cacheData.get(hashCode);
        } else {
            System.out.println("get from database");
            Product product = database.findProduct(request);
            cacheData.put(hashCode, product);
            return product;
        }
    }
}
