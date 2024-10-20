import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> niza = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            niza.add(in.nextInt());
        }
        System.out.println("Nizata pred transformacija: ");
        printArray(niza);
        double prosek = prosekk(niza);
        ArrayList<Integer> novaNiza = new ArrayList<>();
        for (int i = 0; i < niza.size(); i++) {
            if(niza.get(i) >= prosek) {
                novaNiza.add(niza.get(i));
            }
        }
        printArray(novaNiza);
    }
    private static void printArray(ArrayList<Integer> niza) {
        System.out.print("{");
        for (int i = 0; i < niza.size(); i++) {
            System.out.print(niza.get(i) + "," );
        }
        System.out.println("}");
        System.out.println();
    }
    private static double prosekk(ArrayList<Integer> niza) {
        double suma = 0;

        for (int i = 0; i < niza.size(); i++) {
            suma += niza.get(i);
        }
        return suma/niza.size();
    }
}