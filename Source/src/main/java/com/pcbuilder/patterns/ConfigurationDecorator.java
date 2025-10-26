package com.pcbuilder.patterns;

/**
 * Abstract Decorator class cho PC Configuration
 * Đây là base class cho tất cả các decorator
 * Decorator Pattern cho phép thêm chức năng mới vào object mà không thay đổi structure
 */
public abstract class ConfigurationDecorator implements PCConfiguration {
    protected PCConfiguration wrappedConfig;

    public ConfigurationDecorator(PCConfiguration config) {
        this.wrappedConfig = config;
    }

    @Override
    public double getPrice() {
        return wrappedConfig.getPrice();
    }

    @Override
    public String getDescription() {
        return wrappedConfig.getDescription();
    }
}
