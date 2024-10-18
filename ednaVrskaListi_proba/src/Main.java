import java.util.Scanner;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Linkedlist{
    Node head;
    public Linkedlist(){
        this.head = null;
    }
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head =newNode;
        }
        else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void addToStart(int data){
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }
    public void addAfter(int insertAfter, int data){
        Node curr = head;
        while(curr != null){
            if(curr.data == insertAfter){
                Node n =  new Node(data);
                n.next = curr.next;
                curr.next = n;
                break;
            }
            curr = curr.next;
        }
    }
        Node deleteAtEnd(){
        Node curr = head;
        if(curr == null || curr.next == null){
            head = null;
            return curr;
        }
        Node nextNode =  curr.next;
        while(curr.next != null){
            if(nextNode.next == null){
                curr.next = null;
            }
            curr = nextNode;
            nextNode = nextNode.next;
        }
        return curr;
    }
    Node deleteAtStart(){
        Node curr = head;
        if(head != null){
            Node deleteNode = head;
            head = head.next;
            return deleteNode;
        }
        return null;
    }
    Node deleteAfter(int data){
        Node curr = head;
        Node todelete = null;
        while(curr != null){
            if(curr.data == data && curr.next != null){
                todelete = curr.next;
                curr.next = todelete.next;
                break;
            }
            curr = curr.next;
        }
        return todelete;
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Linkedlist linkedlist = new Linkedlist();
        linkedlist.add(1);
        linkedlist.add(2);
        linkedlist.add(3);
        linkedlist.addToEnd(4);
        linkedlist.addToStart(0);
        linkedlist.addAfter(3 , 3);
        linkedlist.printList();
        linkedlist.deleteAtEnd();
        linkedlist.printList();
        linkedlist.deleteAtStart();
        linkedlist.printList();
        linkedlist.deleteAfter(3);
        linkedlist.printList();
    }
}

