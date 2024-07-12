import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fraction[] fractions = new Fraction[2];

        for (int i=0; i<2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            fractions[i] = new Fraction(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int denominator = fractions[0].B * fractions[1].B / getGCD(Math.max(fractions[0].B, fractions[1].B), Math.min(fractions[0].B, fractions[1].B));
        int numerator = (fractions[0].A * (denominator / fractions[0].B)) + (fractions[1].A * (denominator / fractions[1].B));
        int gcd = getGCD(Math.max(denominator, numerator), Math.min(denominator, numerator));

        int resultA = numerator / gcd;
        int resultB = denominator / gcd;

        System.out.print(resultA + " " + resultB);
    }

    static int getGCD(int a, int b) {
        if (a % b == 0) return b;
        return getGCD(b, a % b);
    }

    static class Fraction {
        int A;
        int B;

        public Fraction(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}
