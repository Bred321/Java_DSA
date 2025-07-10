package objects;

public class Cat extends Dog{
    private int food;

    public Cat(String name, int age, int food){
        super(name, age);
        this.food = food;
    }

    public Cat(String name, int age){
        super(name, age);
    }

    public void speak(){
        System.out.println("My cat's name is" + this.name + "and it speaks meow");
    }

    public void eat(int x){
        this.food -= x;
        System.out.println(this.name + "still has food: " + this.food);
    }
}
