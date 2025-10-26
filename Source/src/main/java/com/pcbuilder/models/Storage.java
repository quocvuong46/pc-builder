package com.pcbuilder.models;

/**
 * Class Storage (Ổ cứng)
 */
public class Storage extends Component {
    private String type; // HDD, SSD, NVMe
    private int capacity;
    private String readSpeed;
    private String writeSpeed;

    public Storage(int id, String name, String manufacturer, double price, 
                   String specifications, String type, int capacity, 
                   String readSpeed, String writeSpeed) {
        super(id, name, manufacturer, price, specifications);
        this.type = type;
        this.capacity = capacity;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
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

    public String getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(String readSpeed) {
        this.readSpeed = readSpeed;
    }

    public String getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(String writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    @Override
    public String getDetails() {
        return String.format("Ổ cứng: %s\nHãng: %s\nLoại: %s\nDung lượng: %d GB\nTốc độ đọc: %s\nTốc độ ghi: %s\nThông số: %s\nGiá: %,.0f VNĐ",
                name, manufacturer, type, capacity, readSpeed, writeSpeed, specifications, price);
    }
}
