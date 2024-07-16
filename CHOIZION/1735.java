import java.io.*;
import java.util.*;

public class Main {
    static class Number {
        int boonza, boonmo;

        Number(int n , int d) {
            boonza = n;
            boonmo = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Number f1 = readNumber(br);
        Number f2 = readNumber(br);

        int resultboonza = f1.boonza * f2.boonmo + f2.boonza * f1.boonmo;
        int resultboonmo = f1.boonmo * f2.boonmo;

        simpleNumber(resultboonza, resultboonmo);
        br.close();
    }

    static Number readNumber(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        return new Number(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    static void simpleNumber(int boonza, int boonmo) {
        int gcd = euclidGCD(Math.abs(boonza), boonmo);
        System.out.println((boonza / gcd) + " " + (boonmo / gcd));
    }

    static int euclidGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}