import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class SLLNode<E>{
    E data;
    SLLNode<E> next;
    public SLLNode(E data){
        this.data = data;
        this.next = null;
    }
}
class SLL<E> {
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
    public List<E> toArrayList() {
        List<E> arrayList = new ArrayList<>();
        SLLNode<E> curr = head;
        while (curr != null) {
            arrayList.add(curr.data);
            curr = curr.next;
        }
        return arrayList;
    }

    public void toList(List<E> arrayList) {
        this.head = null;
        for (E element : arrayList) {
            addElement(element);
        }
    }
    public void spojuvanje(SLL lista1, SLL lista2){
       List<E> arrayList1 = lista1.toArrayList();
       List<E> arrayList2 = lista2.toArrayList();

       List<E> fina_lista = new ArrayList<>();
        int index1 = 0, index2 = 0;

        while (index1 < arrayList1.size() || index2 < arrayList2.size()) {
            for (int count = 0; count < 2 && index1 < arrayList1.size(); count++) {
                fina_lista.add(arrayList1.get(index1));
                index1++;
            }
            for (int count = 0; count < 2 && index2 < arrayList2.size(); count++) {
                fina_lista.add(arrayList2.get(index2));
                index2++;
            }
        }
        this.toList(fina_lista);
    }


    public void print(){
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
//        System.out.println("Original List: ");
//        list.print();

        SLL<Integer> list1 = new SLL<>();
        int n1 = sc.nextInt();
        for(int i = 0; i < n1; i++){
            list1.addElement(sc.nextInt());
        }
//        System.out.println("Original List1: ");
//        list1.print();
        SLL<Integer> resultList = new SLL<>();
        resultList.spojuvanje(list,list1);
        resultList.print();
        sc.close();
    }
}