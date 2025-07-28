package Practices.Queues;

public class atmApplication {
    static class Customer{
        int arrivalTime;
        int useTime;

        public Customer(int arrivalTime, int useTime){
            this.arrivalTime = arrivalTime;
            this.useTime = useTime;
        }
    }

    private int size;
    private int front, rear;
    private int MAX_SIZE = 100;
    private Customer[] items;

    public boolean isEmpty(){
        return size == 0;
    }

    public atmApplication(){
        size = 0;
        front = rear = 0;
        items = new Customer[MAX_SIZE];
    }

    public boolean enQueue(Customer customer){
        if (size < MAX_SIZE){
            items[rear] = customer;
            rear = (rear + 1) % MAX_SIZE;
            size++;
            return true;
        }
        return false;
    }

    public boolean deQueue(){
        if(isEmpty()) return false;
        front = (front + 1) % MAX_SIZE;
        size--;
        return true;
    }

    public Customer peekFront(){
        if(isEmpty()) return null;
        return items[front];
    }

    public void processEvents(int k){
        int[] atmAvailableTimes = new int[k]; // All initialized to 0
        int totalWaitTime = 0;
        int maxWaitTime = 0;
        int count = size;

        while(!isEmpty()){
            Customer newCustomer = peekFront();
            deQueue();

            // Find the earliest available ATM
            int minIndex = 0;
            for (int i = 1; i < k; i++) {
                if (atmAvailableTimes[i] < atmAvailableTimes[minIndex]) {
                    minIndex = i;
                }
            }

            // ATM becomes available no earlier than the customer's arrival
            int startTime = Math.max(atmAvailableTimes[minIndex], newCustomer.arrivalTime);
            int waitTime = startTime - newCustomer.arrivalTime;

            totalWaitTime += waitTime;
            maxWaitTime = Math.max(maxWaitTime, waitTime);

            // Update that ATM's availability time
            atmAvailableTimes[minIndex] = startTime + newCustomer.useTime;
        }

        System.out.println("Total waiting time: " + totalWaitTime);
        System.out.println("Max waiting time: " + maxWaitTime);
        System.out.println("Average waiting time: " + (double)totalWaitTime / count);
    }


    public static void main(String[] args){
        atmApplication app = new atmApplication();
        app.enQueue(new Customer(0, 5));
        app.enQueue(new Customer(3, 3));
        app.enQueue(new Customer(4, 4));
        app.enQueue(new Customer(100, 4));
        int numberOfATMs = 2; // Example: 2 ATMs
        app.processEvents(numberOfATMs);
    }


}

        // queue.enQueue(new Event(0, 5));
        // queue.enQueue(new Event(3, 3));
        // queue.enQueue(new Event(4, 4));
        // queue.enQueue(new Event(100, 4));