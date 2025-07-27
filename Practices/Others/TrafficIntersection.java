package Practices.Others;

public class TrafficIntersection {
    static class Car {
        String licensePlate;

        public Car(String licensePlate){
            this.licensePlate = licensePlate;
        }
    }

    private int northSize, eastSize, southSize, westSize;
    private int northFront, northRear, eastFront, eastRear, southFront, southRear, westFront, westRear;
    private int MAX_SIZE = 100;
    private int index = 0;
    private Car[] northCars, eastCars, southCars, westCars;
    private String[] rotatedDirections = {"North", "East", "South", "West"};
    private String currentDirection = null;

    public TrafficIntersection(){
        northSize = eastSize = southSize = westSize = 0;
        northCars = eastCars = southCars = westCars = new Car[MAX_SIZE];
    } 

    public void arrive(String direction, Car car){
        switch (direction){
            case "North":
                if(northSize < MAX_SIZE){
                    northCars[northRear] = car;
                    northRear = (northRear + 1) % MAX_SIZE;
                    northSize++;
                }
                break;
            case "East":
                if(eastSize < MAX_SIZE){
                    eastCars[eastRear] = car;
                    eastRear = (eastRear + 1) % MAX_SIZE;
                    eastSize++;
                }
                break;
            case "South":
                if(southSize < MAX_SIZE){
                    southCars[southRear] = car;
                    southRear = (southRear + 1) % MAX_SIZE;
                    southSize++;
                }
                break;
            case "West":
                if(westSize < MAX_SIZE){
                    westCars[westRear] = car;
                    westRear = (westRear + 1) % MAX_SIZE;
                    westSize++;
                }
                break;
            default:
                break;
        }
        return;
    }

    public void greenLight(int limit){
        int count = 0;
        switch (currentDirection){
            case "North":
                while (count <= limit){
                    if(northSize == 0) return;
                    Car car = northCars[northFront];
                    System.out.println("Car with" + car.licensePlate + "passes");
                    northFront = (northFront + 1) % MAX_SIZE;
                    northSize--;
                    count++;

                }
                break;
            case "East":
                while (count <= limit){
                    if(eastSize == 0) return;
                    Car car = eastCars[eastFront];
                    System.out.println("Car with" + car.licensePlate + "passes");                   
                    eastFront = (eastFront + 1) % MAX_SIZE;
                    eastSize--;
                    count++;
                }
                break;
            case "South":
                while (count <= limit){
                    if(southSize == 0) return;
                    Car car = southCars[southFront];
                    System.out.println("Car with" + car.licensePlate + "passes");     
                    southFront = (southFront + 1) % MAX_SIZE;
                    southSize--;
                    count++;
                }
                break;
            case "West":
                while (count <= limit){
                    if(westSize == 0) return;
                    Car car = westCars[westFront];
                    System.out.println("Car with" + car.licensePlate + "passes");     
                    westFront = (westFront + 1) % MAX_SIZE;
                    westSize--;
                    count++;
                }
                break;
            default:
                break;
        }
        count = 0;
        return;
    }

    public void changeLight(){
        index = (index + 1) % rotatedDirections.length; // Circular Rotation
        currentDirection = rotatedDirections[index];
    }

    public String getCurrentDirection(){
        return currentDirection;
    }

    
    public boolean isEmpty(){
        return northSize == 0 && eastSize == 0 && southSize == 0 && westSize == 0;
    }

    public Car peekNextCar() {
        switch (currentDirection) {
            case "North":
                return northSize > 0 ? northCars[northFront] : null;
            case "East":
                return eastSize > 0 ? eastCars[eastFront] : null;
            case "South":
                return southSize > 0 ? southCars[southFront] : null;
            case "West":
                return westSize > 0 ? westCars[westFront] : null;
            default:
                return null;
        }
    }

    public static void main(String[] args){
        TrafficIntersection ti = new TrafficIntersection();

        ti.arrive("North", new Car("N123"));
        ti.arrive("North", new Car("N456"));
        ti.arrive("East", new Car("E789"));

        ti.greenLight(1); // North: car N123 passes
        ti.changeLight();

        ti.greenLight(2); // East: car E789 passes
        ti.changeLight();

        ti.greenLight(1); // South: no cars

    }
}
