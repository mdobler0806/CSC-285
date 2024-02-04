public class SmartBulb {
    private final String location;
    boolean active;
    int dimIntensity;

    public SmartBulb(String location) {
        this.location = location;
        this.active = false;
        this.dimIntensity = 0;
    }

    public void turnOn() {
        active = true;
        dimIntensity = 50;
    }

    public void turnOff() {
        active = false;
    }

    public void setDimIntensity(int dimIntensity) {
        if (active && (dimIntensity <= 100 && dimIntensity >= 0)) {
            this.dimIntensity = dimIntensity;
        } else {
            System.exit(1);
        }
    }

    public String getLightSummary() {
        if (active) {
            return "Light @ " + location + " is on @ intensity of " + dimIntensity;
        } else {
            return "Light @ " + location + " is off";
        }
    }
}
