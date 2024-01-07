import java.util.Scanner;

/**
 * UVA - 11081
 *
 * Date 3 stringhe di sole lettere minuscole, bisogna contare il numero di modi in cui è possibile costruire
 * la terza stringa combinando due sottosequenze delle prime due stringhe.
 * Dopo aver eliminato 0 o più caratteri da una stringa possiamo ottenere la sua sottosequenza. Una sottosequenza può anche essere vuota.
 * Supponiamo ora che ci siano due sottosequenze "abc" e "de". Combinandole si ottengono le seguenti stringhe
 * "abcde", "abdce", "abdec", "adbce", "adbec", "adebc", "dabce", "dabec", "daebc" e "deabc".
 *
 * Input
 * La prima riga dell'input contiene un singolo numero intero T (0 < T < 271) che indica il numero di casi di test.
 * Ogni caso di test contiene 3 stringhe contenenti solo caratteri minuscoli. Le lunghezze delle stringhe sono comprese tra 1 e 60.
 * Output
 * Per ogni caso di test produrre un singolo intero che indichi il numero di modi in cui è possibile costruire la
 * terza stringa a partire dalle prime due stringhe con il metodo sopra descritto. Il risultato può essere molto grande.
 * Il risultato dovrebbe essere %10007.
 *
 * Input:
 * 2
 * abc abc abc
 * abbcd bccde abcde
 *
 * Output: 8 18
 */


public class threeStringsCombo {

    public static int comboStringhe(int[][] memo, String[] stringhe, int i, int j, int k){

        if(i == stringhe[0].length() || j == stringhe[1].length() || k == stringhe[2].length()){
            return 1;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int modi = 0;

        if(i<stringhe[0].length() && stringhe[0].charAt(i)==stringhe[2].charAt(k)){
            modi = modi + comboStringhe(memo,stringhe, i+1, j, k+1);
        }

        if(j<stringhe[1].length() && stringhe[1].charAt(j)==stringhe[2].charAt(k)){
            modi = modi + comboStringhe(memo, stringhe, i, j+1, k+1);
        }

        memo[i][j] = modi;
        return memo[i][j];
    }

    public static void initMemo(int[][] memo, int dim1, int dim2){
        for(int i=0; i<dim1; i++){
            for(int j=0; j<dim2; j++){
                memo[i][j] = -1;
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int casiTest = 0;

        System.out.println("Inserisci casi di test: ");
        casiTest = input.nextInt();
        input.nextLine();

        while(casiTest!=0){
            int modi = 0;

            String[] stringhe = new String[3];

            System.out.println("Inserisci stringhe ");
            for (int i=0; i<3; i++){
                stringhe[i] = input.next();
            }

            for (int i=0; i<3; i++){
                System.out.println(stringhe[i]);
            }

            if( stringhe[0].length()<1 || stringhe[0].length()>60){
                break;
            }

            int lengthX = stringhe[0].length();
            int lengthY = stringhe[1].length();

            int[][] memo = new int[lengthX+1][lengthY+1];
            initMemo(memo, lengthX+1, lengthY+1);

            modi = comboStringhe(memo, stringhe, 0, 0, 0);

            System.out.println(modi);

            casiTest--;
        }
    }
}
