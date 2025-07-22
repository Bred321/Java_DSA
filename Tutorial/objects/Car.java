package Tutorial.objects;

public class Car implements Vehicle {
    private int gear;
    private int speed = 0;

    public Car() {}
    public void changeGear(int newGear){
        this.gear = newGear;
        System.out.println("The gear has been changed to: " + newGear);
    }

    public void speedUp(int increment){
        this.speed += increment;
        System.out.println("The speed has been increased by: " + increment + " km/h");
    }

    public void slowDown(int decrement){
        this.speed -= decrement;
        System.out.println("The speed has been decreased by: " + decrement + " km/h");
    }

    public void display(){
        System.out.println("Current speed: " + speed + " km/h");
        System.out.println("Current gear: " + gear);
        out(); // Call the default method from Vehicle interface
    }

    public static void main(String[] args){
        Car bwd = new Car();
        bwd.speedUp(20);
        bwd.changeGear(2);
        bwd.display();

        int static_int = Vehicle.plusTwo(5); // Call the static method from Vehicle interface
        System.out.println("Static method result: " + static_int);
    }
}
