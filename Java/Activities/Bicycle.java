package activities;

public class Bicycle implements BicycleParts, BicycleOperations {
    public int gears;
    public int currentSpeed;

    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    @Override
    public void applyBrake(int decrement) {
        currentSpeed = currentSpeed - decrement;
    }

    @Override
    public void speedUp(int increment) {
        currentSpeed = currentSpeed + increment;
    }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}
