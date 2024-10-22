import java.util.Scanner;
import java.util.List;
class SLLNode<E> {
    E data;
    SLLNode<E> next;
    public SLLNode(E data){
        this.data = data;
        this.next = null;
    }
}
class SLL<E extends CharSequence>{
    public SLLNode<E> head;
    public SLL(){
        this.head = null;
    }
    public void add(E data){
        SLLNode<E> newNode = new SLLNode<>(data);
        if(head == null){
            head = newNode;
        }
        else{
            SLLNode <E> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    public void addToEnd(E data){
        SLLNode<E> newNode = new SLLNode<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        SLLNode<E> curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    public void promena(int l) {
        SLLNode<E> curr = head;
        SLL<E> newList = new SLL<>();
        SLL<E> matchList = new SLL<>();
        if(curr == null || curr.next == null){
            return;
        }
        while(curr != null){
            if(curr.data.length() == l){
                matchList.addToEnd(curr.data);
            }
            else{
                newList.add(curr.data);
            }
            curr = curr.next;
        }
       if(newList.head != null){
           head = newList.head;
           SLLNode<E> curr2 = newList.head;
           while(curr2.next != null){
               curr2 = curr2.next;
           }
           curr2.next = matchList.head;
       }
       else{
           head = matchList.head;
       }
    }

    public void display(){
        SLLNode<E> curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<String> lista = new SLL<>();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            lista.add(sc.nextLine());
        }
        int l = sc.nextInt();
        lista.display();
        System.out.println();
        lista.promena(l);
        lista.display();
    }
}



