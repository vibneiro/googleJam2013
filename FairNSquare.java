import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 @Author: Ivan Voroshilin
 @Date: April 13 2013
 Problem C
 Small inputs
 */
public class FairNSquare {

    private boolean isPalindrome(long num) {
        long reversed = 0;
        long n = num;

        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }

        return num == reversed;
    }

    private void solve(Scanner sc, PrintWriter pw) {

        sc.nextLong();


        long a = sc.nextLong();
        long b = sc.nextLong();

        System.out.println(a);
        System.out.println(b);

        long number = a;
        long count = 0;

        while(number <= b) {
            if(isPalindrome(number)) {
                double d = Math.sqrt(number);
                if((d % 1) == 0 && isPalindrome((long)d)) {
                    count++;
                }
            }
            number++;
        }

        pw.println(count);
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader("C-small-attempt0.in.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        int caseCnt = sc.nextInt();
        sc.nextLine();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new FairNSquare().solve(sc, pw);
        }

        pw.flush();
        pw.close();
        sc.close();
    }

}
