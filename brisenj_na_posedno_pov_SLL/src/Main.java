//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
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
    public void deleteElement(E key){
        if(head == null){
            return;
        }
        SLLNode<E> curr = head;
        SLLNode<E> prev = null;
        SLLNode<E> prev_last_occ = null;
        SLLNode<E> last_occ = null;
        while(curr != null){
            if(curr.data.equals(key)){
                prev_last_occ = prev;
                last_occ = curr;
            }
            prev = curr;
            curr = curr.next;
        }
        if(last_occ != null){
            if(prev_last_occ != null){
                prev_last_occ.next =last_occ.next;
            }
            else{
                head = head.next;
            }
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
        int key = sc.nextInt();
        list.deleteElement(key);
        System.out.println();
        list.print();
    }
}
