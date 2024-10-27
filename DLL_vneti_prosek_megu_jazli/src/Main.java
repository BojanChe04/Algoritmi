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

    public void funkcija(){
        DLLNode current = head;
        DLLNode prev = getLast();
        DLL newList = new DLL();
        while(current!=null && current.next != null){
            newList.addElement(current.data);
            int sum = current.data + current.next.data;
            int average;
            if(sum%2 ==0){
                average = sum/2;
            }
            else{
                average = sum/2 + 1;
            }
            newList.addElement(average);
            current = current.next;
        }
        if(current!=null){
            newList.addElement(current.data);
        }
        newList.printList();
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
        lista.funkcija();
    }
}