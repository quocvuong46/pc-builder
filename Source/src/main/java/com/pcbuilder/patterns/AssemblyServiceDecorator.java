package com.pcbuilder.patterns;

/**
 * Assembly Service Decorator - Thêm dịch vụ lắp ráp
 * Decorator Pattern: Thêm chức năng lắp ráp và kiểm tra vào cấu hình
 */
public class AssemblyServiceDecorator extends ConfigurationDecorator {
    private static final double ASSEMBLY_COST = 500000; // 500k VNĐ

    public AssemblyServiceDecorator(PCConfiguration config) {
        super(config);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + ASSEMBLY_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + 
               String.format("\n[+] Dịch vụ lắp ráp và test (+%,.0f VNĐ)", ASSEMBLY_COST);
    }

    public double getAssemblyCost() {
        return ASSEMBLY_COST;
    }
}
