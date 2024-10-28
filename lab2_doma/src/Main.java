//
//import java.util.Scanner;
//class DLLNode {
//    int data;
//    DLLNode next;
//    DLLNode prev;
//
//    public DLLNode(int data) {
//        this.data = data;
//        this.next = null;
//        this.prev = null;
//    }
//}
//class DLL{
//    DLLNode head;
//    public DLL() {
//        this.head = null;
//    }
//    public void addElement(int data){
//        DLLNode newNode = new DLLNode(data);
//        if(head == null){
//            head = newNode;
//            return;
//        }
//        DLLNode current = head;
//        while(current.next != null){
//            current = current.next;
//        }
//        current.next = newNode;
//        newNode.prev = current;
//    }
//    public DLLNode getLast() {
//        if (head == null) {
//            return null;
//        }
//        DLLNode current = head;
//        while (current.next != null) {
//            current = current.next;
//        }
//        return current;
//    }
////    public int prosek_from(DLLNode node){
////        if(node == null){
////            return 0;
////        }
////        int sum = 0;
////        int brojac=0;
////        DLLNode current = node.next;
////        while(current != null){
////            sum += current.data;
////            brojac++;
////            current = current.next;
////        }
////        if(brojac == 0){
////            return 0;
////        }
////        else{
////            return sum/brojac;
////        }
////    }
////    public int prosek_to(DLLNode node){
////        if(node == null){
////            return 0;
////        }
////        int sum = 0;
////        int brojac=0;
////        DLLNode current = head;
////        while(current != node){
////            sum += current.data;
////            brojac++;
////            current = current.next;
////        }
////        if(brojac == 0){
////            return 0;
////        }
////        else{
////            return sum/brojac;
////        }
////    }
//    public int funkcija(){
//        int brojac = -1;
//        DLLNode current = head;
//        while(current != null){
//            int before_SUM = 0;
//            int before_Brojac = 0;
//            DLLNode pred = current.prev;
//            while(pred != null){
//                before_SUM += pred.data;
//                before_Brojac++;
//                pred = pred.prev;
//            }
//            double predProsek;
//            if (before_Brojac > 0) {
//                predProsek = (double) before_SUM / before_Brojac;
//            } else {
//                predProsek = 0;
//            }
//            int posle_sum= 0;
//            int posle_brojac=0;
//            DLLNode posle = current.next;
//            while(posle != null){
//                posle_sum += posle.data;
//                posle_brojac++;
//                posle = posle.next;
//            }
//            double posleProsek;
//            if (before_Brojac > 0) {
//                posleProsek = (double) posle_sum / posle_brojac;
//            } else {
//                posleProsek = 0;
//            }
//            if (predProsek > posleProsek) {
//                brojac++;
//            }
//            current=current.next;
//        }
//        return brojac;
//    }
//    public void printList(){
//        DLLNode current = head;
//        while(current!=null){
//            System.out.print(current.data+" ");
//            current = current.next;
//        }
//        System.out.println();
//    }
//
//}
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        DLL lista = new DLL();
//        int n = sc.nextInt();
//        for(int i = 0; i < n; i++){
//            lista.addElement(sc.nextInt());
//        }
//        int rezultat = lista.funkcija();
//        System.out.println(rezultat);
//    }
//}
//
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

class DLL {
    DLLNode head;

    public DLL() {
        this.head = null;
    }

    public void addElement(int data) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DLLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public int calculateAverage() {
        int count = -1;
        DLLNode current = head;

        while (current != null) {
            int beforeSum = 0;
            int beforeCount = 0;
            DLLNode pred = current.prev;
            while (pred != null) {
                beforeSum += pred.data;
                beforeCount++;
                pred = pred.prev;
            }

            double predAverage;
            if (beforeCount > 0) {
                predAverage = (double) beforeSum / beforeCount;
            } else {
                predAverage = 0;
            }

            int afterSum = 0;
            int afterCount = 0;
            DLLNode after = current.next;
            while (after != null) {
                afterSum += after.data;
                afterCount++;
                after = after.next;
            }

            double afterAverage;
            if (afterCount > 0) {
                afterAverage = (double) afterSum / afterCount;
            } else {
                afterAverage = 0;
            }

            if (predAverage > afterAverage) {
                count++;
            }

            current = current.next;
        }

        return count;
    }

    public void printList() {
        DLLNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL list = new DLL();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.addElement(sc.nextInt());
        }
        int result = list.calculateAverage();
        System.out.println(result);
        sc.close();
    }
}
