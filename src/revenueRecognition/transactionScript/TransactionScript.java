package revenueRecognition.transactionScript;

import java.sql.*;
import java.util.Calendar;

/**
 * Created by VVykhor on 15.04.2017.
 */
public class TransactionScript {

    public void calculateRevenueRecognition(int contractId) throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            System.out.println("Error register driver: " + e);
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/revenue_recognition?user=root&password=root")) {
            PreparedStatement findProductStatement = c.prepareStatement("SELECT product_id, revenue FROM contracts where id = ?");
            findProductStatement.setInt(1, contractId);
            ResultSet contract = findProductStatement.executeQuery();
            contract.next();
            int productId = contract.getInt("product_id");
            double revenue = contract.getDouble("revenue");

            PreparedStatement findProductTypeStatement = c.prepareStatement("SELECT type FROM products where id = ?");
            findProductTypeStatement.setInt(1, productId);
            ResultSet product = findProductTypeStatement.executeQuery();
            product.next();
            String productType = product.getString("type");

            if (productType == null) {
                System.out.println("Empty product type");
            } else {
                Calendar calendar = Calendar.getInstance();
                if (productType.equals("word processor")) {
                    insertRevenue(c, contractId, revenue/3, new Date(calendar.getTimeInMillis()));
                } else if (productType.equals("spreadsheet")) {
                    insertRevenue(c, contractId, revenue/3, new Date(calendar.getTimeInMillis()));
                    calendar.add(Calendar.DATE, 60);
                    insertRevenue(c, contractId, revenue/3, new Date(calendar.getTimeInMillis()));
                    calendar.add(Calendar.DATE, 30);
                    insertRevenue(c, contractId, revenue/3, new Date(calendar.getTimeInMillis()));
                } else if (productType.equals("database")) {
                    insertRevenue(c, contractId, revenue/3, new Date(calendar.getTimeInMillis()));
                    calendar.add(Calendar.DATE, 30);
                    insertRevenue(c, contractId, revenue/3, new Date(calendar.getTimeInMillis()));
                    calendar.add(Calendar.DATE, 30);
                    insertRevenue(c, contractId, revenue/3, new Date(calendar.getTimeInMillis()));
                } else {
                    System.out.println("Unknown product type");
                }
            }
        }
    }

    private void insertRevenue(Connection c, int contractId, double amount, Date recognizedOn) throws SQLException {
        try(PreparedStatement insertRevenue = c.prepareStatement("insert into revenue_recognitions (contract, amount, recognized_on) values (?, ?, ?)")) {
            insertRevenue.setInt(1, contractId);
            insertRevenue.setDouble(2, amount);
            insertRevenue.setDate(3, recognizedOn);
            insertRevenue.execute();
        } catch (SQLException e) {
            System.out.println("Error in inserting revenue " +e );
        }
    }
}
