package com.pcbuilder.models;

/**
 * Class CPU kế thừa từ Component
 * Thể hiện nguyên tắc Inheritance trong OOP
 */
public class CPU extends Component {
    private String socket;
    private int cores;
    private String baseClock;

    public CPU(int id, String name, String manufacturer, double price, 
               String specifications, String socket, int cores, String baseClock) {
        super(id, name, manufacturer, price, specifications);
        this.socket = socket;
        this.cores = cores;
        this.baseClock = baseClock;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(String baseClock) {
        this.baseClock = baseClock;
    }

    @Override
    public String getDetails() {
        return String.format("CPU: %s\nHãng: %s\nSocket: %s\nSố nhân: %d\nXung nhịp: %s\nThông số: %s\nGiá: %,.0f VNĐ",
                name, manufacturer, socket, cores, baseClock, specifications, price);
    }
}
