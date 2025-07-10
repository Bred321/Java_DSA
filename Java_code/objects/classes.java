package objects;

public class classes {
    public static void main(String[] args){
        Dog tim = new Dog("tim", 4);
        tim.speak();
        Dog bill = new Dog("bill", 7);
        bill.speak();
        Dog tom = new Dog("tom", 4);
        tom.speak();

        tim.setAge(7);
        System.out.println("Tim's age is now: " + tim.getAge());
    }
}
