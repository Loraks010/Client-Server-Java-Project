package ProductTree;

public class Power_block extends Product {

    private int power;
    private String certificate;

    public Power_block(int power, String certificate) {
        this.power = power;
        this.certificate = certificate;
    }

    public Power_block(int id, double price, String name, String maker, int power, String certificate) {
        super(id, price, name, maker);
        this.power = power;
        this.certificate = certificate;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
