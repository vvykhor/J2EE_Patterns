package revenueRecognition.transactionScript;

import java.sql.SQLException;

/**
 * Created by VVykhor on 15.04.2017.
 */
public class Demo {
    public static void main(String[] args) throws SQLException {
        TransactionScript transactionScript = new TransactionScript();
        transactionScript.calculateRevenueRecognition(1);
        transactionScript.calculateRevenueRecognition(2);
        transactionScript.calculateRevenueRecognition(3);
    }
}
