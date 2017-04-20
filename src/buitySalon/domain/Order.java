package buitySalon.domain;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * Created by vykhor on 20.04.17.
 */
public class Order {
    private int id;
    private Client client;
    private Employee employee;
    private ServiceType serviceType;

    public Order(int id, Client client, Employee employee, ServiceType serviceType) {
        this.id = id;
        this.client = client;
        this.employee = employee;
        this.serviceType = serviceType;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public static void update(Order order) {

    }

    public static List<Order> findAll() {

    }

    public  static Order findById(int id) {

    }

}
