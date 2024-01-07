import java.util.Scanner;

/**
 * Il simbolo di un codice a barre è costituito da barre scure e chiare alternate, che iniziano con una barra scura a sinistra. Ogni barra è larga un certo numero di unità. La Figura 1 mostra un simbolo di codice a barre composto da 4 barre che si estendono per 1 + 2 + 3 + 1 = 7 unità.
 * In generale, il codice a barre BC(n, k, m) è l'insieme di tutti i simboli con k barre che insieme si estendono esattamente su n unità e ogni barra è larga al massimo m unità. Ad esempio, il simbolo della Figura 1 appartiene a BC(7,4,3) ma non a BC(7,4,2). La Figura 2 mostra tutti i 16 simboli di BC(7,4,3). Ogni '1' rappresenta un'unità scura, ogni '0' un'unità chiara.
 * 0: 1000100 | 4: 1001110 | 8: 1100100 | 12: 1101110
 * 1: 1000110 | 5: 1011000 | 9: 1100110 | 13: 1110010
 * 2: 1001000 | 6: 1011100 | 10: 1101000 | 14: 1110100
 * 3: 1001100 | 7: 1100010 | 11: 1101100 | 15: 1110110
 * Figura 2: Tutti i simboli di BC(7,4,3)
 *
 * Input:
 * 2
 * 7 4 3
 * 7 4 2
 *
 * Output: 16 4
 */
public class barcode {

    public static int totBarcode(int[][] memo, int n, int k, int m){
        if(n==0 && k==0){
            return 1;
        }

        if(n == 0 || k == 0){
            return 0;
        }

        if(memo[n][k] != -1){
            return memo[n][k];
        }

        memo[n][k] = 0;

        for(int i=1; i<=m; i++){
            if(n>=i){
                memo[n][k] = memo[n][k] + totBarcode(memo, n-i, k-1, m);
            }
        }

        return memo[n][k];
    }

    public static void initMemo(int[][] memo, int n, int k){
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                memo[i][j] = -1;
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int casiTest = 0;

        casiTest = input.nextInt();

        while(casiTest != 0){
            int numUnita = 0;
            int numBarre = 0;
            int maxLunghezza = 0;

            numUnita = input.nextInt(); //n
            numBarre = input.nextInt(); //k
            maxLunghezza = input.nextInt(); //m

            if(numUnita<1 || numUnita>50 || numBarre<1 || numBarre>50 || maxLunghezza<1 || maxLunghezza>50){
                break;
            }

            int[][] memo = new int[numUnita+1][numBarre+1];
            initMemo(memo, numUnita+1, numBarre+1);
            System.out.println(totBarcode(memo, numUnita, numBarre, maxLunghezza));

            casiTest--;
        }
    }
}
