package Tutorial.objects;

public interface Vehicle {
    final int gears = 5;

    void speedUp(int increment);
    void changeGear(int newGear);
    void slowDown(int decrement);

    default void out(){
        System.out.println("This is a default method in Vehicle interface.");
    }

    static int plusTwo(int x){
        return x + 2;
    }
}
