package Practices.MockTest;

public class KhangBankQueue {
    private int size;
    private int front, rear;
    private int position = 0; // to track the position of the customer in the queue
    private static int MAX_SIZE = 100;
    private Customer[] customers;
    private int arrivalOrder = 0; // to track the order of arrival of customers

    public KhangBankQueue(){
        size = 0;
        front = rear = 0;
        customers = new Customer[MAX_SIZE];
    }

    // enQueue complexity: O(n)
    public int enQueue(Customer customer){
        boolean isInserted = false;
        if (size == 0){
            customers[0] = customer;
        } else {
            for(int i = 0; i < size; i++){
                if (customers[i].priorityValue < customer.priorityValue){
                    // Shift elements to the right 
                    for(int j = size - 1; j >= i; j--){
                        customers[j + 1] = customers[j];
                    }

                    customers[i] = customer;
                    position = i;
                    isInserted = true;
                    break;
                }
            }
            if(!isInserted){
                customers[size] = customer;
                position = size;
            }
        }
        size++;
        customer.arrivalOrder = arrivalOrder++;
        return position;

        
    }

    public int countUnhappy(){
        int unhappyCounts = 0;
        for(int i = 0; i < size; i++){
            Customer current = customers[i];

            for(int j = 0; j < i; j++){
                Customer ahead = customers[j];
                
                if(ahead.arrivalOrder > current.arrivalOrder){
                    unhappyCounts++;
                    break;
                }
            }
        }
        return unhappyCounts;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private Customer peekFront(){
        if(isEmpty()){
            return null;
        }
        return customers[front];
    }

    // public int countUnhappy(){}

    public static void main(String[] args){
        KhangBankQueue queue = new KhangBankQueue();
        // enqueue customers
        System.out.println("Waiting position: " + queue.enQueue(new Customer(1, "Bob2", "Silver")));
        System.out.println("Unhappy clients: " + queue.countUnhappy());

        System.out.println("Waiting position: " + queue.enQueue(new Customer(2, "Alice", "Gold")));
        System.out.println("Unhappy clients: " + queue.countUnhappy());

        System.out.println("Waiting position: " + queue.enQueue(new Customer(3, "Bob", "Silver")));
        System.out.println("Unhappy clients: " + queue.countUnhappy());

        System.out.println("Waiting position: " + queue.enQueue(new Customer(4, "Carol", "Diamond")));
        System.out.println("Unhappy clients: " + queue.countUnhappy());

        System.out.println("Waiting position: " + queue.enQueue(new Customer(5, "Bob3", "Silver")));
        System.out.println("Unhappy clients: " + queue.countUnhappy());
    }
    
}

class Customer{
    int id;
    int priorityValue;
    int arrivalOrder;
    String name;
    String type;

    public Customer(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
        setPriorityValue(type);
    }

    private void setPriorityValue(String type){
        switch(type){
            case "Diamond":
                this.priorityValue = 3;
                break;
            case "Gold":
                this.priorityValue = 2;
                break;
            case "Silver":
                this.priorityValue = 1;
                break;
            default:
                this.priorityValue = 0;
                break;
        }
    }

    
}
