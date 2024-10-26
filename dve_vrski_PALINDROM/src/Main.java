// dali e palindrom
import java.util.Scanner;
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    public DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DLL{
    DLLNode head;
    public DLL() {
        this.head = null;
    }
    public void addElement(int data){
        DLLNode newNode = new DLLNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        DLLNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }
    public DLLNode getLast() {
        if (head == null) {
            return null;
        }
        DLLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public void printList(){
        DLLNode current = head;
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean dalie_e_palindrom(int n){
        if(head == null || head.next == null){
            return true;
        }
        DLLNode current = head;
        DLLNode last = getLast();
        for (int i = 0; i < n/2; i++){
            if(current.data != last.data){
                return false;
            }
            current = current.next;
            last = last.prev;
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL lista = new DLL();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            lista.addElement(sc.nextInt());
        }
        lista.printList();
        if(lista.dalie_e_palindrom(n)){
            System.out.println("Palindrom");
        }
        else{
            System.out.println("Not Palindrom");
        }
    }
}