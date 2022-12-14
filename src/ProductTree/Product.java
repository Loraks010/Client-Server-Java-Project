package ProductTree;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private double price;
    private String name;
    private String maker;

    public Product() {
        this.id = 0;
        this.price = 0;
        this.name = "0";
        this.maker = "0";
    }

    public Product(int id, double price, String name, String maker) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.maker = maker;
    }



    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
