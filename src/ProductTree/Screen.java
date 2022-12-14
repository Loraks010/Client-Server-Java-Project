package ProductTree;

public class Screen extends Product {
    private double frequency_of_update;
    private String diameter;
    private String screen_resolution;

    public Screen(double frequency_of_update, String diameter, String screen_resolution) {
        this.frequency_of_update = frequency_of_update;
        this.diameter = diameter;
        this.screen_resolution = screen_resolution;
    }

    public Screen(int id, double price, String name, String maker, double frequency_of_update, String diameter, String screen_resolution) {
        super(id, price, name, maker);
        this.frequency_of_update = frequency_of_update;
        this.diameter = diameter;
        this.screen_resolution = screen_resolution;
    }

    public double getFrequency_of_update() {
        return frequency_of_update;
    }

    public void setFrequency_of_update(double frequency_of_update) {
        this.frequency_of_update = frequency_of_update;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getScreen_resolution() {
        return screen_resolution;
    }

    public void setScreen_resolution(String screen_resolution) {
        this.screen_resolution = screen_resolution;
    }
}
