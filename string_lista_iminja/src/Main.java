
// lista od iminja
//kolku se validni?
//da se ispecatat iminjata obratno 

import java.util.Scanner;
import java.util.LinkedList;
class Node<E>{
    E data;
    Node <E> next;
    Node(E data){
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList<E extends Comparable<E>>{
    Node<E> head;
    public MyLinkedList(){
        this.head = null;
    }
   public void addElement(E data){
       Node<E> newNode = new Node<>(data);
       if(this.head == null){
           this.head = newNode;
       }
       else{
           Node<E> curr = head;
           while(curr.next != null){
               curr = curr.next;
           }
           curr.next = newNode;
       }
   }
   public void sort(){
        if(head == null || head.next == null){
            return;
        }
        Node<E> curr = head;
        while(curr != null){
            Node <E> index = curr.next;
            Node<E> min = curr;
            while(index != null){
                if(index.data.compareTo(min.data)<   0){
                    min = index;
                }
                index = index.next;
            }
            E tmp = curr.data;
            curr.data = min.data;
            min.data = tmp;
            curr = curr.next;
        }
   }
   public int validni (){
        Node<E> curr = head;
        int broj = 0;
        while(curr != null){
            if(curr.data.toString().length() > 0 && Character.isUpperCase(curr.data.toString().charAt(0))){
                broj++;
            }
            curr = curr.next;
        }
        return broj;
   }
   public void obratno(){
        Node<E> curr = head;
        while(curr != null){
            String name = curr.data.toString();
            String obratno_ime = new StringBuilder(name).reverse().toString();
            System.out.println(obratno_ime);
            curr = curr.next;
        }
   }
   public void display(){
        Node<E> curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
   }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList<String> list = new MyLinkedList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            list.addElement(sc.nextLine());
        }
        list.display();
        System.out.println();
//        list.sort();
//        list.display();
        System.out.println("broj na vneseni validni iminja: " + list.validni());
        System.out.println();
        System.out.println("obratno ispecateni : ");
        list.obratno();

    }
}