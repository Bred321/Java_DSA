package Tutorial.objects;

public class OuterClass {
    private class InnerClass{
        public void display(){
            System.out.println("Hello from InnerClass!");
        }
    }

    public void inner(){
        InnerClass in = new InnerClass();
        in.display();
    }

    public void inner2(){
        class InnerClass2 {
            public void display(){
                System.out.println("Hello from InnerClass2!");
            }
        }
    }

    public static void main(String[] args){
        OuterClass outer = new OuterClass();
        outer.inner();
    }
}
