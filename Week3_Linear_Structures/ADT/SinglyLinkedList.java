package Week_3_Linear_Structures.ADT;

public class SinglyLinkedList<T> {
    Node<T> head, tail;
    int length;

    public SinglyLinkedList(T data){
        head = new Node<T>(data, head);
        tail = head;
        length = 1;
    }

    public void appendNode(Node<T> node){
        if (head == null){
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
    }
}


class Node<T> {
    T data = null;
    Node<T> next = null;

    public Node(){}
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
}
