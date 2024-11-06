import java.util.Scanner;

class Profit{
    public void sortPoEfikasnost(int[] time, int[] profit, int n){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if((double) profit[i]/time[i] < (double) profit[j]/time[j]){
                    int tmpTime = time[i];
                    int tmpProfit = profit[i];
                    time[i] = time[j];
                    time[j] = tmpTime;
                    profit[i] = profit[j];
                    profit[j] = tmpProfit;
                }
            }
        }
    }
    int maxProfit(int[] time, int[] profit, int n, int maxTime){
        int maxProfit = 0;
        sortPoEfikasnost(time, profit, n);
        for(int i=0; i<n; i++){
            if(maxTime >= time[i]){
                maxTime-=time[i];
                maxProfit+=profit[i];
            }
            else{
                maxProfit += ((double) maxTime / time[i]) * profit[i];
                break;
            }
        }
        return maxProfit;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vreme = new int[n];
        int[] zarabotka = new int[n];
        for (int i = 0; i < n; i++) {
            vreme[i] = sc.nextInt();
            zarabotka[i] = sc.nextInt();
        }
        int max_min = 40;
        Profit p = new Profit();
        int rez = p.maxProfit(vreme, zarabotka, n, max_min);
        System.out.println(rez);

    }
}