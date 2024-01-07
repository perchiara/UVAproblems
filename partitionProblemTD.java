import java.util.Scanner;

/**
 * VERSIONE TOP DOWN
 * Dato un insieme di interi positivi, controllare se può esser suddiviso in due sottoinsiemi di elementi contigui con stessa somma.
 *
 * Esempio:
 * 6
 * [ 3 1 1 2 2 1 ]
 *
 * Output: 5  --- [3, 1, 1] e [2, 2, 1]
 */

public class partitionProblemTD {

    public static int findSum(int[][] memo, int[] numeri, int dim, int somma) {

        if (dim == 0 || somma == 0) {
            return 0;
        }

        if (memo[dim][somma] != -1) {
            return memo[dim][somma];
        }

        if (numeri[dim-1] <= somma) {
            memo[dim][somma] = Math.max(numeri[dim-1] + findSum(memo,numeri, dim-1, somma-numeri[dim-1]),
                    findSum(memo, numeri, dim-1, somma));
        } else {
            memo[dim][somma] = findSum(memo, numeri, dim-1, somma);
        }

        return memo[dim][somma];
    }

    public static void initMemo(int[][] memo, int dimR, int dimC){

        for(int i=0; i<=dimR; i++){
            for (int j=0; j<=dimC; j++){
                memo[i][j] = -1;
            }
        }

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int casiTest = 0;
        int dim = 0;

        System.out.println("Inserisci casi di test: ");
        casiTest = input.nextInt();

        while(casiTest != 0){
            System.out.println("Inserisci dimensione: ");
            dim = input.nextInt();

            int[] numeri = new int[dim];
            int somma = 0;

            System.out.println("Inserisci vettore: ");
            for(int i=0; i<dim; i++){
                numeri[i] = input.nextInt();
            }

            int sommaTot = 0;

            for (int i = 0; i < dim; i++) {
                sommaTot += numeri[i];
            }

            if (sommaTot % 2 != 0) {
                System.out.println("Non esiste.");
            }
            else {
                int[][] memo = new int[dim+1][sommaTot/2 +1];

               initMemo(memo, dim, sommaTot/2);
               somma = findSum(memo, numeri, dim, sommaTot/2);

               if (somma == 0) {
                   System.out.println("Non esiste.");
               } else {
                   System.out.println("La somma dei due array è: " + somma);
               }
            }

            casiTest--;
        }
    }
}
