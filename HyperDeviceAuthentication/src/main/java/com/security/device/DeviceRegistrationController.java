package com.security.device;

@RestController
@RequestMapping("/devices")
public class DeviceRegistrationController {

    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping
    public Device registerDevice(@RequestBody Device device) {
        // Validate device information
        if (!validateDeviceInformation(device)) {
            return null; // or throw an exception
        }

        // Generate a unique device ID
        device.setDeviceId(UUID.randomUUID().toString());

        // Hash and store device password
        device.setPassword(hashPassword(device.getPassword()));

        // Save device to database
        deviceRepository.save(device);

        return device;
    }

    private boolean validateDeviceInformation(Device device) {
        // Validate device name
        if (device.getDeviceName() == null || device.getDeviceName().trim().isEmpty()) {
            return false;
        }

        // Validate device description
        if (device.getDeviceDescription() == null || device.getDeviceDescription().trim().isEmpty()) {
            return false;
        }

        // Validate device type
        if (device.getDeviceType() == null || !DeviceType.isValid(device.getDeviceType())) {
            return false;
        }

        return true;
    }

    private String hashPassword(String password) {
        // Use a secure password hashing algorithm like bcrypt or PBKDF2
        // ...
    }
}
