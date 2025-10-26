package com.pcbuilder.models;

/**
 * Class Case (Vỏ máy tính)
 */
public class Case extends Component {
    private String formFactor;
    private String color;
    private boolean hasRGB;

    public Case(int id, String name, String manufacturer, double price, 
                String specifications, String formFactor, String color, boolean hasRGB) {
        super(id, name, manufacturer, price, specifications);
        this.formFactor = formFactor;
        this.color = color;
        this.hasRGB = hasRGB;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
    }

    @Override
    public String getDetails() {
        return String.format("Vỏ case: %s\nHãng: %s\nForm Factor: %s\nMàu sắc: %s\nRGB: %s\nThông số: %s\nGiá: %,.0f VNĐ",
                name, manufacturer, formFactor, color, hasRGB ? "Có" : "Không", specifications, price);
    }
}
