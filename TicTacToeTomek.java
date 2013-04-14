import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
  @Author: Ivan Voroshilin
  @Date: April 13 2013
  Problem A
  Small and large inputs
 */
public class TicTacToeTomek {

    private final static char XPLAYER = 'X';
    private final static char OPLAYER = 'O';
    private final static char T = 'T';
    private final static char EMPTY = '.';

    private final static String X_WON = "X won";
    private final static String O_WON = "O won";
    private final static String DRAW = "Draw";
    private final static String NOT_COMPLETED = "Game has not completed";


    private void solve(Scanner sc, PrintWriter pw) {

        char[][] array = { sc.next().toCharArray(), sc.next().toCharArray(), sc.next().toCharArray(), sc.next().toCharArray() };

        int xXCount = 0;
        int yXCount = 0;
        int xOCount = 0;
        int yOCount = 0;

        int dForwardXCount = 0;
        int dBackwardXCount = 0;
        int dForwardOCount = 0;
        int dBackwardOCount = 0;
        boolean hasEmptyCells = false;
        boolean hasWinner = false;

        for(int x = 0; x < array.length; x++) { // 4

            for(int y = 0; y < array.length; y++) { // 4

                //x-X
                if(array[x][y] == XPLAYER || array[x][y] == T) {
                    xXCount++;
                }

                //y-X
                if(array[y][x] == XPLAYER || array[x][y] == T) {
                    yXCount++;
                }

                //x-O
                if(array[x][y] == OPLAYER || array[x][y] == T) {
                    xOCount++;
                }

                //y-O
                if(array[y][x] == OPLAYER || array[x][y] == T) {
                    yOCount++;
                }

                if(array[x][y] == EMPTY) {
                    hasEmptyCells = true;
                }
            }

            if(!hasWinner && (xXCount == array.length || yXCount == array.length)) {
                System.out.println(X_WON);
                pw.println(X_WON);
                hasWinner = true;
            }

            if(!hasWinner && (xOCount == array.length || yOCount == array.length)) {
                System.out.println(O_WON);
                pw.println(O_WON);
                hasWinner = true;
            }

            xXCount = yXCount = xOCount = yOCount = 0;

            if(array[x][x] == XPLAYER || array[x][x] == T) {
                dForwardXCount++;
            }

            if(array[(array.length - 1 - x)][x] == XPLAYER || array[(array.length - 1 - x)][x] == T) {
                dBackwardXCount++;
            }

            if(array[x][x] == OPLAYER || array[x][x] == T) {
                dForwardOCount++;
            }

            if(array[(array.length - 1 - x)][x] == OPLAYER || array[(array.length - 1 - x)][x] == T) {
                dBackwardOCount++;
            }

        }

        if(!hasWinner && (dForwardXCount == array.length || dBackwardXCount == array.length)) {
            System.out.println(X_WON);
            pw.println(X_WON);
            hasWinner = true;
        } else
        if(!hasWinner && (dForwardOCount == array.length || dBackwardOCount == array.length)) {
            System.out.println(O_WON);
            pw.println(O_WON);
            hasWinner = true;
        }

        if(!hasWinner) {
            if(hasEmptyCells) {
                System.out.println(NOT_COMPLETED);
                pw.println(NOT_COMPLETED);
            } else {
                System.out.println(DRAW);
                pw.println(DRAW);
            }
        }

    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader("A-large.in.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        int caseCnt = sc.nextInt();
        sc.nextLine();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new TicTacToeTomek().solve(sc, pw);

        }

        pw.flush();
        pw.close();
        sc.close();
    }

}
