import java.util.Scanner;

/**
 * VERSIONE BOTTOM UP
 * Dato un insieme di interi positivi, controllare se può esser suddiviso in due sottoinsiemi di elementi contigui con stessa somma.
 *
 * Esempio:
 * 6
 * [ 3 1 1 2 2 1 ]
 *
 * Output: 5  --- [3, 1, 1] e [2, 2, 1]
 */

public class partitionProblemBU {

    public static int findSum(int[] numeri, int dim){
        int somma1 = 0;
        int somma2 = 0;
        int sommaTot = 0;
        int[] dp = new int[dim];

        if(dim <= 1){
            return 0;
        }

        for(int i=0; i<dim; i++){
            sommaTot = sommaTot + numeri[i];
        }

        if(sommaTot % 2 != 0){
            return 0;
        }

        for(int j=1; j<dim; j++){
            somma1 = somma1 + numeri[j];
            dp[j] = somma1;

            if(somma1 == sommaTot/2){

                for(int k=dim-2; k>j; k--){
                    somma2 = somma2 + numeri[k];
                    dp[k] = somma2;

                    if(dp[j] == dp[k]) return dp[j];
                }
            }
        }

        return 0;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int casiTest = 0;
        int dim = 0;

        System.out.println("Inserisci casi di Test: ");
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

            somma = findSum(numeri, dim);


            if(somma == 0) {
                System.out.println("Non esiste.");
            }
            else{
                System.out.println("La somma dei due array è: " + somma);
            }

            casiTest--;
        }
    }
}