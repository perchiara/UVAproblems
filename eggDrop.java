import java.util.Scanner;

 /**
 * Data una certa quantità di piani di un edificio (diciamo F numero di piani) e data anche una certa quantità di uova
 * (diciamo E numero di uova).
 * Qual è il minor numero di uova che si devono lanciare per trovare il piano soglia?
 * - Un uovo che sopravvive a una caduta può essere riutilizzato.
 * - Un uovo rotto deve essere scartato.
 * - L'effetto di una caduta è lo stesso per tutte le uova.
 * - Se un uovo si rompe quando cade, si romperà anche se viene fatto cadere da un piano più alto.
 * - Se un uovo sopravvive a una caduta, allora sopravviverà a una caduta più breve.
 *
 * Lasciate cadere l'uovo dalla finestra del primo piano; se sopravvive, lasciatelo cadere dalla finestra del secondo
 * piano. Continuare a salire fino a quando non si rompe.
 *
 * Esempio:
 * F = 36
 * E = 2
 *
 * Output: 2
 */

public class eggDrop {

    static int countDrops(int[] memo, int f, int e){
        int drops = Integer.MAX_VALUE;

        if(f == 0 || f == 1){
            return f;
        }

        if(e == 1){
            return f;
        }

        if(memo[f] != -1){
            return memo[f];
        }

        for(int i=1; i<f; i++){
            memo[i] = 1+ Math.max(countDrops(memo, i-1, e-1), countDrops(memo, f-i, e));

            if(memo[i] < drops){
                drops = memo[i];
            }

            memo[f] = drops +1;
        }

        return memo[f];
    }

    static void initMemo(int[] memo, int f){
        for(int i=0; i<f+1; i++){
            memo[i] = -1;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int testCase = 0;
        int f = 0;
        int e = 0;

        System.out.println("Inserisci numero casi di test: ");
        testCase = input.nextInt();

        while(testCase != 0){

            System.out.println("Inserisci numero di piani: ");
            f = input.nextInt();

            System.out.println("Inserisci numero di uova: ");
            e = input.nextInt();

            int[] memo = new int[f+1];

            initMemo(memo, f);
            int drops = countDrops(memo, f, e);
            System.out.println("Minimum number of egg drops for " + e + " eggs and " + f + " floors is: " + drops);

            testCase--;
        }
    }
}










    /*
    static int countDrops(int[][] memo, int f, int e){
        int drops = Integer.MAX_VALUE;
        int res;

        if(f == 0 || f == 1){
            return f;
        }

        if(e == 1){
            return f;
        }

        if(memo[f][e] != -1){
            return memo[f][e];
        }

        for(int i=1; i<f; i++){
            res = Math.max(countDrops(memo, i-1, e-1), countDrops(memo, f-i, e));

            if(res < drops){
                drops = res;
            }

            memo[f][e] = drops +1;
        }


        return memo[f][e] ;
    }

    static void initMemo(int[][] memo, int f, int e){
        for(int i=0; i<f+1; i++){
            for(int j=0; j<e+1; j++){
                memo[i][j] = -1;
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int testCase = 0;
        int f = 0;
        int e = 0;

        System.out.println("Inserisci numero casi di test: ");
        testCase = input.nextInt();

        while(testCase != 0){

            System.out.println("Inserisci numero di piani: ");
            f = input.nextInt();

            System.out.println("Inserisci numero di uova: ");
            e = input.nextInt();

            int[][] memo = new int[f+1][e+1];

            initMemo(memo, f, e);
            int drops = countDrops(memo, f, e);
            System.out.println("Minimum number of egg drops for " + e + " eggs and " + f + " floors is: " + drops);

            testCase--;
        }
    }
}
*/