import java.util.Scanner;

class DLLNode{
    int data;
    DLLNode next;
    DLLNode prev;
    public DLLNode(int data) {
        this.data = data;
        this.next =null;
        this.prev = null;
    }
}

class DLL{
    DLLNode head;
    public DLL() {
        this.head = null;
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

    public void addElement(int data){
        DLLNode newNode = new DLLNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        DLLNode current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next =newNode;
        newNode.prev =current;
    }
    public void funkcija(int n){
        DLL parni = new DLL();
        DLL neparni = new DLL();
        DLLNode current = head;
        DLLNode last = getLast();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if(flag){
                if(current.data % 2 == 0){
                    parni.addElement(current.data);
                }
                else{
                    neparni.addElement(current.data);
                }
                current=current.next;
            }
            else{
                if(last.data % 2 == 0){
                    parni.addElement(last.data);
                }
                else{
                    neparni.addElement(last.data);
                }
                last = last.prev;
            }
            flag = !flag;
        }
        parni.printList();
        neparni.printList();
    }
    public void printList(){
        DLLNode current = head;
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
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
        lista.funkcija(n);
    }
}