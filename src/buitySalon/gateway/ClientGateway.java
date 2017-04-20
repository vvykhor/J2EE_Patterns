package buitySalon.gateway;

import buitySalon.domain.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vykhor on 20.04.17.
 */
public class ClientGateway {

    static {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            System.out.println("Error register driver: " + e);
        }
    }

    public static Client findById(int id) {
        Client client = null;
        try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/buity_salon?user=root&password=root");
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM Clients WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                client = new Client(resultSet.getInt("id"), resultSet.getString("name"));
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Error in find Clint with id = " + id);
            e.printStackTrace();
        }
        return client;
    }

    public static List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/buity_salon?user=root&password=root");
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM Clients");
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()) {
               Client client = new Client(resultSet.getInt("id"), resultSet.getString("name"));
               clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Error in find all Clints");
            e.printStackTrace();
        }
        return clients;
    }


    public static void insert(Client client) {
        try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/buity_salon?user=root&password=root");
            PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO Clients (id, name) VALUES (?, ?)")) {
            preparedStatement.setInt(1, client.getId());
            preparedStatement.setString(2, client.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error in insert Clint");
            e.printStackTrace();
        }
    }

    public static void delete(Client client) {
        try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/buity_salon?user=root&password=root");
            PreparedStatement preparedStatement = c.prepareStatement("DELETE FROM Clients WHERE id=?")) {
            preparedStatement.setInt(1, client.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error in insert Clint");
            e.printStackTrace();
        }
    }
}
