import java.util.Scanner;

/**
 * L'algoritmo restituisce il numero minimo di salti per arrivare alla fine della sequenza
 *
 * Esempio:
 * dim = 11
 * array = [ 1 3 5 8 9 2 6 7 6 8 9 ]
 *
 * output: 3     (1 > 3 > 9 > 9)
 */

public class minNumJump {

    static int minNumJump(int[] memo, int[] numeri, int dim, int indice){
        int min = Integer.MAX_VALUE;

        if(indice >= dim-1){
            return 0;
        }

        if(memo[indice] != dim){
            return memo[indice];
        }

        for (int i=1; i<=numeri[indice] && indice+i<dim; i++) {
            int jumps = 1 + minNumJump(memo, numeri, dim, indice+i);
            min = Math.min(min, jumps);
        }

        memo[indice] = min;

        return min;
    }

    static void initMemo(int[] memo, int dim){

        for(int i=0; i<dim; i++){
            memo[i] = dim;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int testCase = 0;
        int dim = 0;

        System.out.println("Inserisci numero di test: ");
        testCase = input.nextInt();

        while(testCase != 0 ){

            System.out.println("Dimensione array: ");
            dim = input.nextInt();

            int[] numeri = new int[dim];

            System.out.println("Inserisci array: ");
            for(int i=0; i<dim; i++){
                numeri[i] = input.nextInt();
            }

            int memo[] = new int[dim];
            int minJump = 0;

            initMemo(memo, dim);
            minJump = minNumJump(memo, numeri, dim, 0);
            System.out.println("Minimum number of jump is: " + minJump);

            testCase--;
        }

    }
}
