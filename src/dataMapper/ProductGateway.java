package dataMapper;

import java.sql.*;

/**
 * Created by VVykhor on 16.04.2017.
 */

public class ProductGateway {

    private static Connection c;

    static {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            System.out.println("Error register driver: " + e);
        }
    }

    public static void insert(int id, String name, String type) {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/revenue_recognition?user=root&password=root");
            PreparedStatement insertProductStatement = c.prepareStatement("insert into products (id, name, type) values (?, ?, ?)");
            insertProductStatement.setInt(1, id);
            insertProductStatement.setString(2, name);
            insertProductStatement.setString(3, type);
            insertProductStatement.execute();
            c.close();
        } catch (SQLException e) {
            System.out.println("Error in inserting: " + e);
        }
    }

    public static ResultSet findAll() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/revenue_recognition?user=root&password=root");
            PreparedStatement selectProductStatement = c.prepareStatement("select id, name, type from products");
            ResultSet resultSet = selectProductStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error in select: " + e);
            return null;
        }
    }

    public static void close() {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println("Error in closing connection");
        }
    }

}
