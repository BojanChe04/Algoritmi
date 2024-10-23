import java.util.Scanner;

 class SLLNode<E>{
    SLLNode<E> next;
    E data;
    public SLLNode(E data){
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
         SLLNode<E> newNode = new SLLNode(data);
         if(head == null){
             head = newNode;
         }
         else{
             SLLNode<E> curr = head;
             while(curr.next != null){
                 curr = curr.next;
             }
             curr.next = newNode;
         }
     }
     public void mirror(){
         if(head == null){
             return;
         }
         SLLNode<E> curr = head;
         SLLNode<E> prev = null;
         SLLNode<E> next = null;
         while(curr != null){
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         head = prev;
     }
     public void preuredi_lista(int n){
         if(head == null || head.next == null){
             return;
         }
         SLLNode<E> curr = head;
         SLL<E> list1 = new SLL<>();
         SLL<E> list2 = new SLL<>();
         for(int i = 0; i < n/2; i++){
             list1.addElement(curr.data);
             curr = curr.next;
         }
         while(curr != null){
             list2.addElement(curr.data);
             curr = curr.next;
         }
         list2.mirror();
         SLL<E> final_list = new SLL<>();
         SLLNode<E> curr1 = list1.head;
         SLLNode<E> curr2 = list2.head;
         while(curr1 != null || curr2 != null){
             if(curr1 != null){
                 final_list.addElement(curr1.data);
                 curr1 = curr1.next;
             }
             if(curr2 != null){
                 final_list.addElement(curr2.data);
                 curr2 = curr2.next;
             }
         }
         final_list.display();

     }
     public void display(){
         SLLNode<E> curr = head;
         while(curr != null){
             System.out.print(curr.data + " ");
             curr = curr.next;
         }
     }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Integer> list = new SLL<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list.addElement(sc.nextInt());
        }
        System.out.println("Original List: ");
        list.display();
        System.out.println();
        list.preuredi_lista(n);

    }
}