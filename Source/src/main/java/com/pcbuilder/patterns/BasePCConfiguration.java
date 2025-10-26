package com.pcbuilder.patterns;

import com.pcbuilder.models.*;

/**
 * Base PC Configuration - Component cơ bản trong Decorator Pattern
 * Đây là object gốc mà các decorator sẽ wrap around
 */
public class BasePCConfiguration implements PCConfiguration {
    private CPU cpu;
    private Mainboard mainboard;
    private RAM ram;
    private VGA vga;
    private Storage storage;
    private PSU psu;
    private Case pcCase;
    private Cooler cooler;

    public BasePCConfiguration() {
        // Constructor mặc định
    }

    // Getters and Setters
    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Mainboard getMainboard() {
        return mainboard;
    }

    public void setMainboard(Mainboard mainboard) {
        this.mainboard = mainboard;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public VGA getVga() {
        return vga;
    }

    public void setVga(VGA vga) {
        this.vga = vga;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public PSU getPsu() {
        return psu;
    }

    public void setPsu(PSU psu) {
        this.psu = psu;
    }

    public Case getPcCase() {
        return pcCase;
    }

    public void setPcCase(Case pcCase) {
        this.pcCase = pcCase;
    }

    public Cooler getCooler() {
        return cooler;
    }

    public void setCooler(Cooler cooler) {
        this.cooler = cooler;
    }

    @Override
    public double getPrice() {
        double total = 0;
        if (cpu != null) total += cpu.getPrice();
        if (mainboard != null) total += mainboard.getPrice();
        if (ram != null) total += ram.getPrice();
        if (vga != null) total += vga.getPrice();
        if (storage != null) total += storage.getPrice();
        if (psu != null) total += psu.getPrice();
        if (pcCase != null) total += pcCase.getPrice();
        if (cooler != null) total += cooler.getPrice();
        return total;
    }

    @Override
    public String getDescription() {
        StringBuilder desc = new StringBuilder("=== CẤU HÌNH MÁY TÍNH ===\n\n");
        
        if (cpu != null) desc.append("CPU: ").append(cpu.getName()).append("\n");
        if (mainboard != null) desc.append("Mainboard: ").append(mainboard.getName()).append("\n");
        if (ram != null) desc.append("RAM: ").append(ram.getName()).append("\n");
        if (vga != null) desc.append("VGA: ").append(vga.getName()).append("\n");
        if (storage != null) desc.append("Ổ cứng: ").append(storage.getName()).append("\n");
        if (psu != null) desc.append("Nguồn: ").append(psu.getName()).append("\n");
        if (pcCase != null) desc.append("Case: ").append(pcCase.getName()).append("\n");
        if (cooler != null) desc.append("Tản nhiệt: ").append(cooler.getName()).append("\n");
        
        return desc.toString();
    }

    public String getDetailedDescription() {
        StringBuilder desc = new StringBuilder("=== CHI TIẾT CẤU HÌNH MÁY TÍNH ===\n\n");
        
        if (cpu != null) desc.append(cpu.getDetails()).append("\n\n");
        if (mainboard != null) desc.append(mainboard.getDetails()).append("\n\n");
        if (ram != null) desc.append(ram.getDetails()).append("\n\n");
        if (vga != null) desc.append(vga.getDetails()).append("\n\n");
        if (storage != null) desc.append(storage.getDetails()).append("\n\n");
        if (psu != null) desc.append(psu.getDetails()).append("\n\n");
        if (pcCase != null) desc.append(pcCase.getDetails()).append("\n\n");
        if (cooler != null) desc.append(cooler.getDetails()).append("\n\n");
        
        return desc.toString();
    }
}
