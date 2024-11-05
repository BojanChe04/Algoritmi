import java.util.Scanner;

class Sjalicki{
    public static int min_broj_sjalicki(int[] positions, int n, int street_dolzina){
        int brojac=0;
        for(int i=0; i<n; ){
            brojac++;
            int position = positions[i] + 2;
            while(i<n && positions[i] <= position){
                i++;
            }
            position = positions[i-1] + 2;
            while(i<n && positions[i] <= position){
                i++;
            }
        }
        return brojac;

    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int br_pozicii = sc.nextInt();
        int dolz_na_ulica = sc.nextInt();
        int[] niza = new int[br_pozicii];
        for(int i = 0; i < br_pozicii; i++){
            niza[i] = sc.nextInt();
        }
        System.out.println("Min Sjalicki: " + Sjalicki.min_broj_sjalicki(niza, br_pozicii, dolz_na_ulica));
    }
}