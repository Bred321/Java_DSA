package Week_3_Linear_Structures.ADT;

public class ArrayPriorityQueue<T> {
    private static final int MAX_SIZE = 100;
    private class Node {
        T data;
        int priority;

        Node(T data, int priority){
            this.data = data;
            this.priority = priority;
        }
    }
    private Node[] items;
    private int size;

    public ArrayPriorityQueue(){
        this.items = (Node[])new Node[MAX_SIZE];
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public boolean enqueue(T data, int priority){
        if(size >= MAX_SIZE || priority < 0 || priority > 2){
            return false;
        }

        items[size++] = new Node(data, priority);
        return true;
    }
    public boolean dequeue(){
        if(isEmpty()){
            return false;
        }

        int highestPriorityIndex = findHighestPriorityIndex();
        if(highestPriorityIndex == -1){
            return false;
        }

        // Shift elements to remove the node at highestPriorityIndex
        for(int i = highestPriorityIndex; i < size - 1; i++){
            items[i] = items[i + 1];
        }
        items[size - 1] = null; // Clear the last item
        size--;
        return true;
    }
    public T peekFront(){
        if(isEmpty()){
            return null;
        }
        int highestPriorityIndex = findHighestPriorityIndex();
        return highestPriorityIndex != -1 ? items[highestPriorityIndex].data : null;
    }

    private int findHighestPriorityIndex(){
        int highestPriority = -1;
        int index = -1;
        for(int i = 0; i < size; i++){
            if(items[i].priority > highestPriority){
                highestPriority = items[i].priority;
                index = i;
            }
        } 
        return index;
    }

}



