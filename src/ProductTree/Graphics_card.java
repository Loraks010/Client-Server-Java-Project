package ProductTree;

public class Graphics_card extends Product {
    private double frequency;
    private int number_of_cores;
    private int tdp;

    public Graphics_card(double frequency, int number_of_cores, int tdp) {
        this.frequency = frequency;
        this.number_of_cores = number_of_cores;
        this.tdp = tdp;
    }

    public Graphics_card(int id, double price, String name, String maker, double frequency, int number_of_cores, int tdp) {
        super(id, price, name, maker);
        this.frequency = frequency;
        this.number_of_cores = number_of_cores;
        this.tdp = tdp;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getNumber_of_cores() {
        return number_of_cores;
    }

    public void setNumber_of_cores(int number_of_cores) {
        this.number_of_cores = number_of_cores;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }


}
