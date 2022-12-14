package ProductTree;

public class Keyboard extends Product {

    private String type;
    private String switches;
    private int rgb;

    public Keyboard(String type, String switches, int rgb) {
        this.type = type;
        this.switches = switches;
        this.rgb = rgb;
    }

    public Keyboard(int id, double price, String name, String maker, String type, String switches, int rgb) {
        super(id, price, name, maker);
        this.type = type;
        this.switches = switches;
        this.rgb = rgb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSwitches() {
        return switches;
    }

    public void setSwitches(String switches) {
        this.switches = switches;
    }

    public int isRgb() {
        return rgb;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
}
