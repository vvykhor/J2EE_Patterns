package dataMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class ProductMapper {

    public static void insert(Product product) {
        ProductGateway.insert(product.getId(), product.getName(), product.getType());
    }

    public static List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try(ResultSet resultSet = ProductGateway.findAll()) {
            if(resultSet != null) {
                while (resultSet.next()) {
                    products.add(new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("type")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }

}
