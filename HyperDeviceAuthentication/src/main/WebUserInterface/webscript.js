// Add event listeners to buttons
document.getElementById('register-device-button').addEventListener('click', registerDevice);
document.getElementById('authenticate-device-button').addEventListener('click', authenticateDevice);
document.getElementById('view-security-events-button').addEventListener('click', viewSecurityEvents);
document.getElementById('exit-button').addEventListener('click', exit);
document.getElementById('help-button').addEventListener('click', help);

// Function to register device
function registerDevice() {
    // Get device information from form
    var deviceId = document.getElementById('device-id').value;
    var deviceType = document.getElementById('device-type').value;
    var ownerInformation = document.getElementById('owner-information').value;

    // Validate input data
    if (!deviceId || !deviceType || !ownerInformation) {
        alert("Please enter all required fields");
        return;
    }

    // Call registerDevice function from DeviceRepository
    DeviceRepository.registerDevice(deviceId, deviceType, ownerInformation);
}

// Function to authenticate device
function authenticateDevice() {
    // Get device information from form
    var deviceId = document.getElementById('select-device').value;
    var authenticationCredentials = document.getElementById('authentication-credentials').value;

    // Validate input data
    if (!deviceId || !authenticationCredentials) {
        alert("Please enter all required fields");
        return;
    }

    // Call authenticateDevice function from DeviceRepository
    DeviceRepository.authenticateDevice(deviceId, authenticationCredentials);
}

// Function to view security events
function viewSecurityEvents() {
    // Call getSecurityEvents function from SecurityEventsAuditing
    SecurityEventsAuditing.getSecurityEvents();
}

// Function to exit
function exit() {
    // Close the parent window
    window.parent.close();
}

// Function to show help
function help() {
    // Show help message in a modal dialog
    var helpDialog = document.getElementById('help-message');
    helpDialog.style.display = 'block';
}

// Connect to security mechanisms
DeviceRepository.init();
SecurityEventsAuditing.init();

// Add event listeners to exit confirmation buttons
document.getElementById('exit-yes').addEventListener('click', function() {
    window.parent.close();
});

document.getElementById('exit-no').addEventListener('click', function() {
    document.getElementById('exit-confirmation').style.display = 'none';
});