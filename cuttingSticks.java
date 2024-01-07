import java.util.Scanner;

/**
 * Si consideri un bastone di lunghezza L, e si desidera tagliarlo in pezzi più piccoli di lunghezza specifica.
 * La lunghezza del bastone è rappresentata da un numero intero positivo L, e si ha a disposizione
 * un elenco di posizioni su cui è possibile effettuare tagli. Il costo di taglio in un punto specifico è proporzionale
 * alla sua distanza dalla fine del bastone. L'obiettivo è minimizzare il costo totale per tagliare il bastone in pezzi
 * di lunghezza specifica alle posizioni date.
 * la prima riga contiene l'intero L (1 ≤ L ≤ 1000), la lunghezza del bastone. La seconda riga contiene un intero n
 * (0 ≤ n ≤ 50), il numero di posizioni in cui è possibile effettuare tagli.
 * Le posizioni dei tagli sono date successivamente in ordine crescente. La fine dell'input è segnalata da L = 0.
 * Stampare una riga contenente il costo minimo per tagliare il bastone in pezzi di lunghezza specifica.
 *
 * Esempio:
 * 100
 * 3
 * 25 50 75
 * 10
 * 4 4 5 7 8
 * 0
 *
 * Output: 200 22
 */

public class cuttingSticks {



    // Metodo per calcolare il costo minimo del taglio
    public static int findMinCost(int[] tagli, int[][] memo, int inizio, int fine) {
        int costo = Integer.MAX_VALUE;

        if (fine - inizio <= 1) {
            return 0;
        }

        if (memo[inizio][fine] != -1) {
            return memo[inizio][fine];
        }

        for (int i = inizio + 1; i < fine; i++) {
            int currentCost = (tagli[fine] - tagli[inizio]) + findMinCost(tagli, memo, inizio, i) + findMinCost(tagli, memo, i, fine);
            costo = Math.min(costo, currentCost);
        }

        memo[inizio][fine] = costo;
        return costo;
    }

    public static void initMemo(int[][] memo, int dim){
        for (int i = 0; i < dim + 2; i++) {
            for (int j = 0; j < dim + 2; j++) {
                memo[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lunghezza = 0;
        int costoMinimo = 0;

        lunghezza = input.nextInt();

        while (lunghezza != 0) {

            if(lunghezza>0 && lunghezza<1000){

                int dim = input.nextInt();

                if(dim<50){
                    int[] tagli = new int[dim + 2];

                    tagli[0] = 0;

                    for (int i = 1; i <= dim; i++) {
                        tagli[i] = input.nextInt();
                    }

                    tagli[dim + 1] = lunghezza;

                    int[][] memo = new int[dim + 2][dim + 2];
                    initMemo(memo, dim);

                    costoMinimo = findMinCost(tagli, memo, 0, dim + 1);
                    System.out.println("Il costo minimo è " + costoMinimo);
                }

            }

            lunghezza = input.nextInt();
        }
    }
}
