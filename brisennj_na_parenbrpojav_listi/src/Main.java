import java.util.Scanner;
import java.util.HashMap;
class SLLNode<E> {
    E data;
    SLLNode<E> next;

    public SLLNode(E data) {
        this.data = data;
        this.next = null;
    }
}
class SLL<E>{
    SLLNode<E> head;
    public SLL(){
        this.head = null;
    }
    public void addElement(E data){
        SLLNode<E> newnode = new SLLNode<>(data);
        if(this.head == null){
            this.head = newnode;
        }
        else{
            SLLNode<E> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newnode;
        }
    }
    public void print(){
        SLLNode<E> curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public void deleteElement() {
        if (head == null) return;
        HashMap<E, Integer> countMap = new HashMap<>();
        SLLNode<E> curr = head;

        while (curr != null) {
            countMap.put(curr.data, countMap.getOrDefault(curr.data, 0) + 1);
            curr = curr.next;
        }
        SLLNode<E> prev = null;
        curr = head;

        while (curr != null) {
            if (countMap.get(curr.data) % 2 == 0) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    head = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Integer> list = new SLL<>();
        int n =  sc.nextInt();
        for(int i = 0; i < n; i++){
            list.addElement(sc.nextInt());
        }
        list.print();
        System.out.println();
        list.deleteElement();
        System.out.println();
        list.print();
    }
}