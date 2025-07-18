package Tutorial.objects;

public class Student implements Comparable<Student>{
    private String name;

    public Student(String name){
        this.name = name;
    }

    public boolean equals(Student other){
        if (this.name.equals(other.name)) {
            return true;
        } 
        return false;
    }

    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    public String toString(){
        return "Student{name='" + name + "'}";
    }

    public static void main(String[] args) {
        Student joe = new Student("Joe");
        Student bill = new Student("Joe");
        Student tim = new Student("Tim");

        // Using the equals method to compare objects
        System.out.println(joe.equals(bill)); // true, because names are the same
        System.out.println(joe.equals(tim));  // false, because names are different

        // Using == operator to compare references
        System.out.println(joe == bill); // false, because they are different objects in memory
        System.out.println(joe.compareTo(tim)); // > 0: greater than, < 0: less than, 0: equal
        System.out.println(tim.toString()); // Student{name='Tim'}
    }
}
