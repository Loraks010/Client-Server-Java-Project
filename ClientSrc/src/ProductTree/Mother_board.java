package ProductTree;

public class Mother_board extends Product {

    private String socket_type;
    private int rgb;

    public Mother_board(String socket_type, int rgb) {
        this.socket_type = socket_type;
        this.rgb = rgb;
    }

    public Mother_board(int id, double price, String name, String maker, String socket_type, int rgb) {
        super(id, price, name, maker);
        this.socket_type = socket_type;
        this.rgb = rgb;
    }

    public String getSocket_type() {
        return socket_type;
    }

    public void setSocket_type(String socket_type) {
        this.socket_type = socket_type;
    }

    public int isRgb() {
        return rgb;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
}
