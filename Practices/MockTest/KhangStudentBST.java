package Practices.MockTest;

public class KhangStudentBST {
    BTNode root = null;

    public KhangStudentBST(){
        root = null;
    }

    public static void main(String[] args){
        KhangStudentBST bst = new KhangStudentBST();
        System.out.println(bst.addStudent(new Student(1, "Alice", 3.3)));
    }

    public int addStudent(Student student){
        return 0;
    }

    private int addStudentNode(BTNode node, Student student){
        return 0;
    }
}


class BTNode {
    Student student;
    BTNode left = null, right = null;

    public BTNode(Student student, BTNode left, BTNode right){
        this.student = student;
        this.left = left;
        this.right = right;
    }
}

class Student {
    int id;
    String name;
    double gpa;

    public Student(int id, String name, double gpa){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
}