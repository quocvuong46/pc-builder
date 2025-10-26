package com.pcbuilder.patterns;

/**
 * Installation Service Decorator - Thêm dịch vụ cài đặt phần mềm
 * Decorator Pattern: Cài Windows, drivers, phần mềm cơ bản
 */
public class InstallationServiceDecorator extends ConfigurationDecorator {
    private static final double INSTALLATION_COST = 300000; // 300k VNĐ

    public InstallationServiceDecorator(PCConfiguration config) {
        super(config);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + INSTALLATION_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + 
               String.format("\n[+] Dịch vụ cài đặt Windows & phần mềm (+%,.0f VNĐ)", 
                           INSTALLATION_COST);
    }

    public double getInstallationCost() {
        return INSTALLATION_COST;
    }
}
