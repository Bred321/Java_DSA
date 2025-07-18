package Tutorial.objects;

public class Student {
    private String name;

    public Student(String name){
        this.name = name;
    }

    public static void main(String[] args){
        Student joe = new Student("Joe");
        Student bill = new Student("Bill");
        Student tim = new Student("Tim");

        System.out.println(joe == bill);
    }
}
