
import java.util.Scanner;
import java.util.Arrays;
class Sali{
    public int min_sali(int[] start, int[] end, int n){
        int min = 0;
        int brojac = 0;
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        while(i<n && j<n){
            if(start[i] <= end[j]){     //ako sostanokov pocvit ped da imat zavrseno momentalniov sostanok
                brojac++;
                i++;
            }
            else{
                brojac--;
                j++;
            }
            min = Math.max(min, brojac);
        }
        return min;
    }


}

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int broj_na_sostanoci = sc.nextInt();
      int[] start = new int[broj_na_sostanoci];
      int[] end = new int[broj_na_sostanoci];
      for (int i = 0; i < broj_na_sostanoci; i++) {
          start[i] = sc.nextInt();
          end[i] = sc.nextInt();
      }
      Sali sali = new Sali();
      int min = sali.min_sali(start, end, broj_na_sostanoci);
      System.out.println(min);
    }
}

