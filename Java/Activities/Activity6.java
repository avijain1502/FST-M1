package activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {

        Plane plane = new Plane(10);
        plane.onboard("Avi");
        plane.onboard("Rohan");
        plane.onboard("Arika");
        System.out.println("Plane take off time " + plane.takeOff());
        System.out.println("Passengers onboarded " + plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Plane landed time " + plane.getLastTimeLanded());
        System.out.println("People landed " + plane.getPassengers());
    }
    }
