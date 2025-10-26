package com.pcbuilder.models;

/**
 * Class VGA (Card màn hình)
 */
public class VGA extends Component {
    private String chipset;
    private int vram;
    private String memoryType;

    public VGA(int id, String name, String manufacturer, double price, 
               String specifications, String chipset, int vram, String memoryType) {
        super(id, name, manufacturer, price, specifications);
        this.chipset = chipset;
        this.vram = vram;
        this.memoryType = memoryType;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public int getVram() {
        return vram;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    @Override
    public String getDetails() {
        return String.format("VGA: %s\nHãng: %s\nChipset: %s\nVRAM: %d GB\nLoại bộ nhớ: %s\nThông số: %s\nGiá: %,.0f VNĐ",
                name, manufacturer, chipset, vram, memoryType, specifications, price);
    }
}
