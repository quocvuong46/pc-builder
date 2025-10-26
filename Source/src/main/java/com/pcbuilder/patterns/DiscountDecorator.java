package com.pcbuilder.patterns;

/**
 * Discount Decorator - Áp dụng giảm giá
 * Decorator Pattern: Thêm tính năng giảm giá vào cấu hình
 */
public class DiscountDecorator extends ConfigurationDecorator {
    private double discountPercent;
    private String discountReason;

    public DiscountDecorator(PCConfiguration config, double discountPercent, String reason) {
        super(config);
        this.discountPercent = discountPercent;
        this.discountReason = reason;
    }

    @Override
    public double getPrice() {
        double originalPrice = super.getPrice();
        return originalPrice * (1 - discountPercent / 100);
    }

    @Override
    public String getDescription() {
        double originalPrice = super.getPrice();
        double discountAmount = originalPrice * (discountPercent / 100);
        return super.getDescription() + 
               String.format("\n[+] Giảm giá %.1f%% (%s): -%,.0f VNĐ", 
                           discountPercent, discountReason, discountAmount);
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public double getDiscountAmount() {
        return super.getPrice() * (discountPercent / 100);
    }
}
