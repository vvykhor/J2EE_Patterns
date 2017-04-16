package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class CacheAccessor implements DataAccessor {

    private Database database = new Database();
    private Cache cache = new Cache();

    public Product findProduct(String request) {
        int hashCode = request.hashCode();
        Product product = cache.get(hashCode);
        if(product != null) {
            System.out.println("get from cache");
            return product;
        } else {
            System.out.println("get from database");
            product = database.findProduct(request);
            cache.put(hashCode, product);
            return product;
        }
    }
}
