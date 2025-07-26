package Week_3_Linear_Structures.ADT;

public class DoublyLinkedList<T> {
    static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList(){
        head = tail = null;
        size = 0;
    }

    private int size(){
        return size;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private void addFirst(T item){
        Node<T> node = new Node<>(item);
        if(isEmpty()){
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    private T removeFirst(){
        if (isEmpty()) return null;
        T data = head.data;
        head = head.next;
        if(head != null) head.prev = null;
        else tail = null;
        size--;
        return data;
    }

    private void addLast(T item){
        Node<T> node = new Node<>(item);
        if(isEmpty()){
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    private T removeLast(){
        if(isEmpty()) return null;
        T data = tail.data;
        tail = tail.prev;
        if(tail != null) tail.next = null;
        else head = null;
        size--;
        return data;
    }

    private void printList(){
        Node<T> current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    private Node<T> addBefore(Node<T> w, T data){
        Node<T> newNode = new Node<>(data);
        if (w == null) return null;
        newNode.data = data;

        newNode.prev = w.prev;
        newNode.next = w;

        newNode.next.prev = newNode;
        newNode.prev.next = newNode;

        size++;
        return newNode;
    }

    private Node<T> getNode(int i){
        Node p = null;
        if(i < size / 2){
            p = head;
            for(int j = 0; j < i && p != null; j++){
                p = p.next;
            }
        } else {
            p = tail;
            for(int j = size - 1; j > i && p != null; j--){
                p = p.prev;
            }
        }
        return p;
    }

}

