package Tutorial.objects;

public class Dog {
    public String name;
    public int age;
    protected static int count = 0;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        add2();
        speak();
        Dog.count++;
        Dog.display();
    }

    public static void display(){
        System.out.println("A new dog has been created.");
    }
    public void speak() {
        System.out.println(name + " says Woof!");
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }
    
    private int add2(){
        return this.age + 2;
    }
}
