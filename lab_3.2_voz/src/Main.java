import java.util.Scanner;
import java.util.Arrays;
class Vozovi{
    public static int min_platforms(int[] arrivals, int[] departures, int n){
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int i = 0;
        int j = 0;
        int min_pat = 0;
        int max_pat = 0;
        while(i < n && j < n){
            if(arrivals[i] <= departures[j]){
                min_pat++;
                i++;
            }
            else{
                min_pat--;
                j++;
            }
            max_pat = Math.max(max_pat, min_pat);
        }
        return max_pat;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int br_vozovi = sc.nextInt();
        int[] arrivals = new int[br_vozovi];
        int[] departures = new int[br_vozovi];
        for (int i = 0; i < br_vozovi; i++) {
            arrivals[i] = sc.nextInt();
            departures[i] = sc.nextInt();
        }
        System.out.println("Minimum platformi: " + Vozovi.min_platforms(arrivals, departures, br_vozovi));
    }
}