package com.pcbuilder.models;

/**
 * Class RAM (Bộ nhớ)
 */
public class RAM extends Component {
    private String type;
    private int capacity;
    private String speed;

    public RAM(int id, String name, String manufacturer, double price, 
               String specifications, String type, int capacity, String speed) {
        super(id, name, manufacturer, price, specifications);
        this.type = type;
        this.capacity = capacity;
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String getDetails() {
        return String.format("RAM: %s\nHãng: %s\nLoại: %s\nDung lượng: %d GB\nBus: %s\nThông số: %s\nGiá: %,.0f VNĐ",
                name, manufacturer, type, capacity, speed, specifications, price);
    }
}
