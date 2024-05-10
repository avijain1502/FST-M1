package activities;

public class Activity1 {

    public static void main(String[] args){
        Car kia = new Car();
        kia.make=2024;
        kia.color="Black";
        kia.transmission="Manual";

        kia.displayCharacteristics();
        kia.accelarate();
        kia.brake();

    }
}


