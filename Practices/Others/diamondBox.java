package Practices.Others;

public class diamondBox {
    public static void main(String[] args){
        diamondBox box1 = new diamondBox("[**[**]*]");
        diamondBox box2 = new diamondBox("[**][*]");
        diamondBox box3 = new diamondBox("[[[*]**]*]");

        System.out.println("Check for valid string");
        System.out.println(box1.isValid());
        System.out.println(box2.isValid());
        System.out.println(box3.isValid());

        System.out.println("Check for the deepest level");
        System.out.println(box1.deepestLevel());
        System.out.println(box2.deepestLevel());
        System.out.println(box3.deepestLevel());

        System.out.println("Check for the most diamonds");
        System.out.println(box1.maxDiamonds());
        System.out.println(box2.maxDiamonds());
        System.out.println(box3.maxDiamonds());
    }

    private String configuration;

    public diamondBox(String configuration){
        this.configuration = configuration;
    }


    public boolean isValid(){
        ArrayStack<Character> stack = new ArrayStack<Character>();
        for(int i = 0; i < configuration.length(); i++){
            char letter = configuration.charAt(i);
            if(letter == '['){
                stack.push(letter);
                continue;
            }
            if(letter == ']'){
                if(stack.isEmpty()) return false;
                stack.pop();
                if(stack.isEmpty() & i < configuration.length() - 1){
                    return false;
                }
            }

        }
        return true;
    }

    public int deepestLevel(){
        ArrayStack<Character> stack = new ArrayStack<Character>();
        int maxLevel = 0;
        for(int i = 0; i < configuration.length(); i++){
            char letter = configuration.charAt(i);
            if (letter == '[' ){
                stack.push(letter);
                maxLevel = Math.max(maxLevel, stack.size());
                continue;
            }
            if (letter == ']'){
                stack.pop();
            }
        }
        return maxLevel;
    }

    static class ArrayStack<T> {
        private int size;
        private static int MAX_SIZE = 100;
        private T[] items;

        public ArrayStack() {
            size = 0;
            items = (T[])new Object[MAX_SIZE];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean push(T item) {
            // make sure the stack still have empty slot
            if (size < MAX_SIZE) {
            items[size] = item;
            size++;
            return true;
            }
            return false;
        }

        public boolean pop() {
            // make sure the stack is not empty
            if (isEmpty()) {
            return false;
            }
            size--;
            return true;
        }

        public T peek() {
            // make sure the stack is not empty
            if (isEmpty()) {
            return null;
            }
            return items[size - 1];
        }
    }


}
