
class DllNode{
    int data;
    DllNode next;
    DllNode prev;
    public DllNode(int data) {
        this.data = data;
        this.next =null;
        this.prev = null;
    }
}
class DoubluLinkedList{
    DllNode head;
    public DoubluLinkedList() {
        this.head = head;
    }
    public void addElement(int data){
        DllNode newNode = new DllNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        DllNode current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next =newNode;
        newNode.prev =current;
    }
    public void addToEnd(int data){
        DllNode newNode = new DllNode(data);
        if(head == null){
            head = newNode;
        }
        else{
            DllNode current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }
    public void addToStart(int data){
        DllNode newNode = new DllNode(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void addAfter(int addAfter, int data){
        DllNode current = head;
        if(head == null){
            return;
        }
        while(current.next!=null){
            if(current.data == addAfter){
                DllNode newNode = new DllNode(data);
                if(current.next == null){
                    current.next = newNode;
                    newNode.prev = current;
                }
                else{
                    newNode.next = current.next;
                    current.next.prev = newNode;
                    current.next = newNode;
                    newNode.prev = current;
                }
                return;
            }
            current = current.next;
        }
    }
    DllNode deleteAtEnd(){
        DllNode todelete = head;
        if(head == null || head.next == null){
            head = null;
            return todelete;
        }
        while (todelete.next != null){
            todelete = todelete.next;
        }
        todelete.prev.next = null;
        return todelete;
    }
    DllNode deleteAtStart(){
        DllNode todelete = head;
        if(head == null || head.next == null){
            head = null;
            return todelete;
        }
        head = head.next;
        head.prev = null;
        return todelete;
    }
    DllNode deleteAfter(int data){
        DllNode todelete = head;
        while(todelete != null){
            if(todelete.data == data){
                todelete = todelete.next;
                break;
            }
            todelete = todelete.next;
        }
        if(todelete!= null && todelete.next != null){
            todelete.next.prev = todelete.prev;
        }
        todelete.prev.next = todelete.next;
        return todelete;
    }
    public void printList(){
        DllNode current = head;
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        DoubluLinkedList list = new DoubluLinkedList();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.printList();
        list.addToEnd(4);
        list.printList();
        list.addToStart(0);
        list.printList();
        list.addAfter(3,3);
        list.printList();
        list.deleteAtEnd();
        list.printList();
        list.deleteAtStart();
        list.printList();
        list.deleteAfter(3);
        list.printList();
    }
}