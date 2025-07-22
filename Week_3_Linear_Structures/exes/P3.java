package Week_3_Linear_Structures.exes;

public class P3 {
    public static void main(String[] args){
        QueueSimuation.processEvents();
    }
}

class QueueSimuation{
    static class Event {
        int arrival;
        int duration;

        public Event(int arrival, int duration){
            this.arrival = arrival;
            this.duration = duration;
        }
    }

    static void processEvents(){
        ArrayQueue<Event> queue = new ArrayQueue<Event>();
        queue.enQueue(new Event(0, 5));
        queue.enQueue(new Event(3, 3));
        queue.enQueue(new Event(4, 4));
        queue.enQueue(new Event(100, 4));

        int n = queue.size();
        int nextAvailableTime = 0;
        int totalWaitingTime = 0;
        int maxWaitingTime = 0;

        while(!queue.isEmpty()){
            Event event = queue.peekFront();
            queue.deQueue();
            nextAvailableTime = nextAvailableTime > event.arrival ? nextAvailableTime : event.arrival;
            int newWaitingTime = nextAvailableTime - event.arrival;
            totalWaitingTime += newWaitingTime;
            maxWaitingTime = maxWaitingTime > newWaitingTime ? maxWaitingTime : newWaitingTime;
            nextAvailableTime += event.duration;
        }

        System.out.printf("Average waiting time: %.2f\n", (double)totalWaitingTime / n);
        System.out.printf("Maximum waiting time: %d\n", maxWaitingTime);

    }
}

class ArrayQueue<T> {
  private int size;
  private int front, rear;

  // I set a small value to test
  // you should replace 10 with a larger value when you use this ADT
  private static int MAX_SIZE = 10;
  private T[] items;

  public ArrayQueue() {
    size = 0;
    front = rear = 0;
    items = (T[])new Object[MAX_SIZE];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean enQueue(T item) {
    // make sure the queue still have empty slot
    if (size < MAX_SIZE) {
      items[rear] = item;
      rear = (rear + 1) % MAX_SIZE;
      size++;
      return true;
    }
    return false;
  }

  public boolean deQueue() {
    // make sure the queue is not empty
    if (isEmpty()) {
      return false;
    }
    front = (front + 1) % MAX_SIZE;
    size--;
    return true;
  }

  public T peekFront() {
    // make sure the queue is not empty
    if (isEmpty()) {
      return null;
    }
    return items[front];
  }
}