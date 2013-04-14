import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 @Author: Ivan Voroshilin
 @Date: April 13 2013
 Problem C
 Large inputs
 Comment: Poor time complexity
 */
public class FairNSquareLarge {

    private static boolean isPalindrome(BigInteger num) {
        BigInteger reversed = BigInteger.ZERO;
        BigInteger n = num;

        while (n.compareTo(BigInteger.ZERO) > 0) {
            reversed = reversed.multiply(BigInteger.valueOf(10)).add(n.mod(BigInteger.valueOf(10)));
            n = n.divide(BigInteger.valueOf(10));
        }

        return num.compareTo(reversed) == 0;
    }

    private static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while(b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
            else a = mid.add(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }

    private void solve(Scanner sc, PrintWriter pw) {

        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger number = a;
        long count = 0;

        while(number.compareTo(b) <= 0) {
            if(isPalindrome(number)) {

                BigInteger d = sqrt(number);

                if(d.multiply(d).compareTo(number) == 0 && isPalindrome(d)) {
                    count++;
                }
            }
            number = number.add(BigInteger.ONE);
            System.out.println(number.toString());
        }

        pw.println(count);
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader("C-large-1.in.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        int caseCnt = sc.nextInt();
        sc.nextLine();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new FairNSquareLarge().solve(sc, pw);
        }

        pw.flush();
        pw.close();
        sc.close();
    }

}
