package com.pcbuilder.patterns;

/**
 * Warranty Decorator - Thêm bảo hành vào cấu hình
 * Áp dụng Decorator Pattern để mở rộng chức năng
 */
public class WarrantyDecorator extends ConfigurationDecorator {
    private int warrantyYears;
    private double warrantyCost;

    public WarrantyDecorator(PCConfiguration config, int years) {
        super(config);
        this.warrantyYears = years;
        // Tính phí bảo hành: 5% giá trị cấu hình mỗi năm
        this.warrantyCost = config.getPrice() * 0.05 * years;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + warrantyCost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + 
               String.format("\n[+] Bảo hành mở rộng: %d năm (+%,.0f VNĐ)", 
                           warrantyYears, warrantyCost);
    }

    public int getWarrantyYears() {
        return warrantyYears;
    }

    public double getWarrantyCost() {
        return warrantyCost;
    }
}
