package dataMapper;

/**
 * Created by VVykhor on 16.04.2017.
 */
public class Product {

    private int id;
    private String name;
    private String type;

    public Product(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "[id=" + id + ", name=" + name + ", type=" + type + "]";
    }

}
