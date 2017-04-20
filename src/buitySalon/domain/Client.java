package buitySalon.domain;

import buitySalon.gateway.ClientGateway;

import java.util.List;

/**
 * Created by vykhor on 20.04.17.
 */
public class Client {
    private int id;
    private String name;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void update(Client client) {

    }

    public static Client findById(int id) {
        return ClientGateway.findById(id);
    }

    public static List<Client> findAll() {
        return ClientGateway.findAll();
    }

    public static void addClient(Client client) {
        ClientGateway.insert(client);
    }

    public static void removeClient(Client client) {
        ClientGateway.delete(client);
    }
}
