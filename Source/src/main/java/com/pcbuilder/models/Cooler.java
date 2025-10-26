package com.pcbuilder.models;

/**
 * Class Cooler (Tản nhiệt)
 */
public class Cooler extends Component {
    private String type; // Air, AIO
    private String socket;
    private int fanSize;

    public Cooler(int id, String name, String manufacturer, double price, 
                  String specifications, String type, String socket, int fanSize) {
        super(id, name, manufacturer, price, specifications);
        this.type = type;
        this.socket = socket;
        this.fanSize = fanSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getFanSize() {
        return fanSize;
    }

    public void setFanSize(int fanSize) {
        this.fanSize = fanSize;
    }

    @Override
    public String getDetails() {
        return String.format("Tản nhiệt: %s\nHãng: %s\nLoại: %s\nSocket: %s\nKích thước quạt: %d mm\nThông số: %s\nGiá: %,.0f VNĐ",
                name, manufacturer, type, socket, fanSize, specifications, price);
    }
}
