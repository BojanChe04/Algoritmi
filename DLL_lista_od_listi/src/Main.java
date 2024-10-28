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
    int data;
    DLL next;
    DLL prev;

    DLL(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
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

    public int suma(){
        int sum = 0;
        DLLNode current = head;
        while(current!=null){
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
}
class ListOfLists{
    DLL head;
    void add_list(DLL list){
        if(head == null){
            head = list;
        }
        else{
            DLL curent = head;
            while(curent != null){
                curent = curent.next;
            }
            curent.next = list;
            list.prev = curent;
        }
    }
    int proizvod_od_sumite(){
        int proivod = 1;
        DLL current = head;
        while(current!=null){
            proivod *= current.suma();
            current = current.next;
        }
        return proivod;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ListOfLists list = new ListOfLists();
        for(int i = 0; i < n; i++){
            DLL sublist = new DLL();
            for(int j = 0; j < m; j++){
                int data = sc.nextInt();
                sublist.addElement(data);
            }
            list.add_list(sublist);
        }
        System.out.println(list.proizvod_od_sumite());
    }
}