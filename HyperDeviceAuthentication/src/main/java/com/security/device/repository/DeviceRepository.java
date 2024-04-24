package com.security.device.repository;

public class DeviceRepository {

    // Initialize device repository
    private final Map<String, Device> devices = new HashMap<>();

    public void save(Device device) {
        // Save device to repository
        devices.put(device.getDeviceId(), device);
    }

    public Device findByDeviceId(String deviceId) {
        // Retrieve device from repository
        return devices.get(deviceId);
    }
}