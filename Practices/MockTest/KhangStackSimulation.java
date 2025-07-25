package Practices.MockTest;

public class KhangStackSimulation {
    private int size;
    private static int MAX_SIZE = 100;
    private String[] items;

    public KhangStackSimulation(){
        size = 0;
        items = new String[MAX_SIZE];
    }

    private int size(){
        return size;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    // Time complexity: O(n)
    public String[] popAll(String[] stack){
        int size = stack.length;
        String[] outStr = new String[size];
        int idx = 0;
        if(size == 0){
            return new String[0];
        } else {
            for(int i = size; i > 0; i--){
                System .out.println("Popping: " + stack[i - 1]);
                if(stack[i - 1] != null){
                    outStr[idx++] = stack[i - 1];
                }
            }
        }

        return outStr;
    }

    // Time complexity: O(n)
    int minOperations(String[] targetStack, String[] currentStack){
        int targetSize = targetStack.length;
        int currentSize = currentStack.length;
        int sizeDiff = Math.abs(targetSize - currentSize);
        int sizeLoop = targetSize <= currentSize ? targetSize : currentSize;
        int operations = 0;

        for(int i = 0; i < sizeLoop; i++){
            if(!targetStack[i].equals(currentStack[i])){
                return (targetSize - i) + (currentSize - i);
            }
        }

        if(targetSize != currentSize){
            operations = sizeDiff;
        }

        return operations;
    }

    public static void main(String[] args){
        KhangStackSimulation stack = new KhangStackSimulation();
        String[] stackItems = {"A", "B", "C", "D", "E"};
        String[] poppedItems = stack.popAll(stackItems);

        for(String item: poppedItems){
            System.out.println(item);
        }

        String[] targetStack = {"A", "B", "C"};
        String[] currentStack = {"C", "B"};

        System.out.println("Minimum operations needed: " + stack.minOperations(targetStack, currentStack));
    }
}
