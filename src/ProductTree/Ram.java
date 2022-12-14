package ProductTree;

public class Ram extends Product {

    private int volume;
    private int quantity_in_the_set;
    private double frequency;
    private String timings;

    public Ram(int volume, int quantity_in_the_set, double frequency, String timings) {
        this.volume = volume;
        this.quantity_in_the_set = quantity_in_the_set;
        this.frequency = frequency;
        this.timings = timings;
    }

    public Ram(int id, double price, String name, String maker, int volume, int quantity_in_the_set, double frequency, String timings) {
        super(id, price, name, maker);
        this.volume = volume;
        this.quantity_in_the_set = quantity_in_the_set;
        this.frequency = frequency;
        this.timings = timings;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getQuantity_in_the_set() {
        return quantity_in_the_set;
    }

    public void setQuantity_in_the_set(int quantity_in_the_set) {
        this.quantity_in_the_set = quantity_in_the_set;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }
}
