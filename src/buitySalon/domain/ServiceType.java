package buitySalon.domain;

import java.util.List;

/**
 * Created by vykhor on 20.04.17.
 */
public class ServiceType {
    private int id;
    private String name;
    private double cost;
    private double duration;

    public ServiceType(int id, String name, double cost, double duration) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getDuration() {
        return duration;
    }

    public static void update(ServiceType serviceType) {

    }

    public static ServiceType findById(int id) {

    }

    public static List<ServiceType> findAll() {

    }

    public static void addServiceType(ServiceType serviceType) {

    }

    public static void removeServiceType(int id) {

    }

}
