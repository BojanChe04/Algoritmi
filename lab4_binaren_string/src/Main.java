import java.util.Scanner;
public class Main {
    public static int binarenString(String s, int n, int index, int br) {
        if(index == n) return br;
        int brojac0 = 0;
        int brojac1 = 0;
        for (int i = index; i < n; i++) {
            if(s.charAt(i) == '1') {
                brojac1++;
            }
            else {
                brojac0++;
            }
            if(brojac1 > brojac0){
                br++;
            }
        }
        return (binarenString(s,n,index+1,br));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int rez = binarenString(s,n,0,0);
        System.out.println(rez);
    }
}