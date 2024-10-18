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
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    public void delete_the_same_elements(Linkedlist list1){
        Node curr = this.head;
        Node curr1 = list1.head;
        while (curr != null && curr1 != null && curr.data == curr1.data) {
            this.head = curr.next;
            list1.head = curr1.next;
            curr = this.head;
            curr1 = list1.head;
        }
        Node prevNode = null;
        Node prevNode1 = null;

        while(curr != null && curr1!= null){
            if(curr.data == curr1.data){
                if(prevNode != null){
                    prevNode.next = curr.next;
                }
                else{
                    this.head = curr.next;
                }
                if(prevNode1 != null){
                    prevNode1.next = curr1.next;
                }
                else{
                    list1.head = curr.next;
                }
                curr = curr.next;
                curr1 = curr1.next;
            }
            else{
                prevNode = curr;
                prevNode1 = curr1;
                curr = curr.next;
                curr1 = curr1.next;
            }
        }

    }
    public void display(){
        Node curr = head;
        while(curr!= null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Linkedlist list = new Linkedlist();
        Linkedlist list1 = new Linkedlist();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int data = sc.nextInt();
            list.add(data);
        }

        int n1 = sc.nextInt();
        for(int i = 0; i < n1; i++){
            int data = sc.nextInt();
            list1.add(data);
        }
        list.display();
        System.out.println();
        list1.display();
        System.out.println();
        list.delete_the_same_elements(list1);
        list.display();
        System.out.println();
        list1.display();
    }
}