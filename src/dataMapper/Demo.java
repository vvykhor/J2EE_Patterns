package dataMapper;

/**
 * Created by VVykhor on 16.04.2017.
 */

public class Demo {
    public static void main(String[] args) {
        for(Product product : ProductMapper.findAll()) {
            System.out.println(product);
        }
        ProductMapper.insert( new Product(7, "test_name", "test_type"));
        for(Product product : ProductMapper.findAll()) {
            System.out.println(product);
        }
    }
}
