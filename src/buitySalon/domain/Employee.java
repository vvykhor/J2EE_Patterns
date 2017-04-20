package buitySalon.domain;

import java.util.List;

/**
 * Created by vykhor on 20.04.17.
 */
public class Employee {
    private int id;
    private String name;
    private List<ServiceType> avaliableServiceTypes;

    public Employee(int id, String name, List<ServiceType> avaliableServiceTypes) {
        this.id = id;
        this.name = name;
        this.avaliableServiceTypes = avaliableServiceTypes;
    }

    public String getName() {
        return name;
    }

    public List<ServiceType> getAvaliableServiceTypes() {
        return avaliableServiceTypes;
    }

    public static void update(Employee employee) {

    }

    public void addAvaliableServiceTepe(ServiceType serviceType) {
        avaliableServiceTypes.add(serviceType);
    }

    public static List<Employee> findAll() {

    }

    public  static Employee findById(int id) {

    }
}
