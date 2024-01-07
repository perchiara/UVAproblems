import java.util.Scanner;

/**
 *
 * DA CORREGERE
 *
 * Vengono date n coppie di numeri. In ogni coppia, il primo numero è sempre più piccolo del secondo.
 * Una coppia (c, d) può seguire un'altra coppia (a, b) se b < c. Si possono formare catene di coppie in questo modo.
 * Trovate la catena più lunga che può essere formata da un dato insieme di coppie.
 *
 * Esempio:
 * [ (5, 24)
 *   (39, 60)
 *   (15, 28)
 *   (27, 40)
 *   (50, 90) ]
 *
 * Output: 3   --  [ (5, 24) (27, 40) (50, 90)]
 */

public class maximumLengthChainOfPairs {

    private static int findMaxLength(int[][] matrice, int[] memo, int indiceCorrente) {
        int maxLength = 1;

        if (indiceCorrente == 0) {
            return 1;
        }

        if (memo[indiceCorrente] != -1) {
            return memo[indiceCorrente];
        }

        for (int i = 0; i < indiceCorrente; i++) {
            if (matrice[i][1] < matrice[indiceCorrente][0]) {
                int length = 1 + findMaxLength(matrice, memo, i);
                maxLength = Math.max(maxLength, length);
            }
        }

        memo[indiceCorrente] = maxLength;

        return maxLength;
    }

    public static void initMemo(int[] memo, int dim){
        for(int i=0; i<dim; i++){
            memo[i] = -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casiTest = 0;

        System.out.println("Inserisci numero casi di test: ");
        casiTest = input.nextInt();

        while(casiTest != 0){

            System.out.println("Quante coppie vuoi inserire? ");
            int dim = input.nextInt();

            int[][] matrice = new int[dim][2];

            System.out.println("Inserisci coppie: ");
            for(int i=0; i<dim; i++){
                for(int j=0; j<2; j++){
                    matrice[i][j] = input.nextInt();
                }
            }

            int[] memo = new int[dim];

            initMemo(memo, dim);

            int maxLength = findMaxLength(matrice, memo, dim-1);

            System.out.println("Lunghezza massima della catena: " + maxLength);

            casiTest--;
        }
    }

}