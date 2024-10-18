import java.util.Scanner;

// dve listi da gi spojt vo edna i da gi sortirat
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head;
    public LinkedList(){
        this.head = null;
    }
    public void addElement(int data){
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
    public void sort(){
        if(head == null || head.next == null){
            return;
        }
        Node curr = head;
        while(curr != null){
            Node index = curr.next;
            Node min = curr;
            while(index != null){
                if(index.data < min.data){
                    min = index;
                }
                index = index.next;
            }
            int temp = curr.data;
            curr.data = min.data;
            min.data = temp;
            curr = curr.next;
        }

    }
    public void spojuvanje(LinkedList lista1){
        if(lista1.head == null || lista1.head.next == null){
            return;
        }
        if(head == null){
            head = lista1.head;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = lista1.head;
    }
    public void display(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}

public class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list1 = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int data = sc.nextInt();
            list.addElement(data);
        }
        int n1 = sc.nextInt();
        for(int i = 0; i < n1; i++){
            int data = sc.nextInt();
            list1.addElement(data);
        }
        System.out.println("lista : ");
        list.display();
        System.out.println();
        System.out.println("lista1 : ");
        list1.display();
        System.out.println();
        System.out.println("spoena : ");
        list.spojuvanje(list1);
        list.display();
        System.out.println();
        System.out.println("sortirana : ");
        list.sort();
        list.display();
    }
}