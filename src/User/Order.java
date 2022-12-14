package User;

import java.io.Serializable;

public class Order implements Serializable {
    public int order_id=0;
    public int user_id=0;
    public int product_id=0;
    public double price=0;
    public String name="0";
    public String maker="0";

    public Order(int order_id, int user_id, int product_id, double price, String name, String maker) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.price = price;
        this.name = name;
        this.maker = maker;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }


}
