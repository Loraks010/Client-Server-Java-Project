package ProductTree;

public class Mouse extends Product {
    private int rgb;
    private int DPI;
    private int wireless;

    public Mouse(int rgb, int DPI, int wireless) {
        this.rgb = rgb;
        this.DPI = DPI;
        this.wireless = wireless;
    }

    public Mouse(int id, double price, String name, String maker, int rgb, int DPI, int wireless) {
        super(id, price, name, maker);
        this.rgb = rgb;
        this.DPI = DPI;
        this.wireless = wireless;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public int isWireless() {
        return wireless;
    }

    public void setWireless(int wireless) {
        this.wireless = wireless;
    }

    public int isRgb() {
        return rgb;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
}
