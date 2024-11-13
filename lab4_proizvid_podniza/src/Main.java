
import java.util.Scanner;
import java.util.ArrayList;
class prog {
    public static int proizvod(int[] niza, int n, int index, int element) {
        if (index == n){
           return element;
        }
        int maxProizvod = element;
        for (int i = index + 1; i < n; i++){
            if(niza[i] > niza[index]){
                maxProizvod = Math.max(maxProizvod, proizvod(niza, n, i, element*niza[i]));
            }
        }
        return maxProizvod;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] niza = new int[n];
        for (int i = 0; i < n; i++) {
            niza[i] = sc.nextInt();
        }
        int maxProizvod = 0;
        for (int i = 0; i < niza.length; i++) {
            maxProizvod = Math.max(maxProizvod, proizvod(niza, n, i, niza[i]));
        }
        System.out.println(maxProizvod);
    }
}










