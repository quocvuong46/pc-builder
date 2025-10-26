package com.pcbuilder.models;

/**
 * Class Mainboard (Bo mạch chủ)
 */
public class Mainboard extends Component {
    private String socket;
    private String chipset;
    private String formFactor;
    private int maxRAM;

    public Mainboard(int id, String name, String manufacturer, double price, 
                    String specifications, String socket, String chipset, 
                    String formFactor, int maxRAM) {
        super(id, name, manufacturer, price, specifications);
        this.socket = socket;
        this.chipset = chipset;
        this.formFactor = formFactor;
        this.maxRAM = maxRAM;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public int getMaxRAM() {
        return maxRAM;
    }

    public void setMaxRAM(int maxRAM) {
        this.maxRAM = maxRAM;
    }

    @Override
    public String getDetails() {
        return String.format("Mainboard: %s\nHãng: %s\nSocket: %s\nChipset: %s\nForm Factor: %s\nRAM tối đa: %d GB\nThông số: %s\nGiá: %,.0f VNĐ",
                name, manufacturer, socket, chipset, formFactor, maxRAM, specifications, price);
    }
}
