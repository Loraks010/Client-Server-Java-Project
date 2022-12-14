package ProductTree;

public class CPU extends Product {
    private double frequency;
    private int technical_process;
    private double turbo_boost_frequency;

    private int tdp;
    private int number_of_cores;



    public CPU(double frequency, int technical_process, double turbo_boost_frequency, int tdp, int number_of_cores) {
        this.frequency = frequency;
        this.technical_process = technical_process;
        this.turbo_boost_frequency = turbo_boost_frequency;
        this.tdp = tdp;
        this.number_of_cores = number_of_cores;
    }

    public CPU(int id, String name, double price, String maker, double frequency,  double turbo_boost_frequency , int number_of_cores,int technical_process, int tdp) {
        super(id, price, name, maker);
        this.frequency = frequency;
        this.technical_process = technical_process;
        this.turbo_boost_frequency = turbo_boost_frequency;
        this.tdp = tdp;
        this.number_of_cores = number_of_cores;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getTechnical_process() {
        return technical_process;
    }

    public void setTechnical_process(int technical_process) {
        this.technical_process = technical_process;
    }

    public double getTurbo_boost_frequency() {
        return turbo_boost_frequency;
    }

    public void setTurbo_boost_frequency(double turbo_boost_frequency) {
        this.turbo_boost_frequency = turbo_boost_frequency;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    public int getNumber_of_cores() {
        return number_of_cores;
    }

    public void setNumber_of_cores(int number_of_cores) {
        this.number_of_cores = number_of_cores;
    }
}
