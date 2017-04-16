package cache;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Database {
    public Product findProduct(String request) {
        int id = Integer.parseInt(request.substring(request.indexOf("=") + 1));
        return new Product(id);
    }
}
