package com.pcbuilder.models;

/**
 * Class PSU (Nguồn máy tính)
 */
public class PSU extends Component {
    private int wattage;
    private String efficiency;
    private boolean modular;

    public PSU(int id, String name, String manufacturer, double price, 
               String specifications, int wattage, String efficiency, boolean modular) {
        super(id, name, manufacturer, price, specifications);
        this.wattage = wattage;
        this.efficiency = efficiency;
        this.modular = modular;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public boolean isModular() {
        return modular;
    }

    public void setModular(boolean modular) {
        this.modular = modular;
    }

    @Override
    public String getDetails() {
        return String.format("Nguồn: %s\nHãng: %s\nCông suất: %d W\nHiệu suất: %s\nModular: %s\nThông số: %s\nGiá: %,.0f VNĐ",
                name, manufacturer, wattage, efficiency, modular ? "Có" : "Không", specifications, price);
    }
}
