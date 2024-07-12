import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");

        int a1, b1, a2, b2, a3, b3;

        a1 = Integer.parseInt(st1.nextToken());
        b1 = Integer.parseInt(st1.nextToken());
        a2 = Integer.parseInt(st2.nextToken());
        b2 = Integer.parseInt(st2.nextToken());
        a3 = (a1*b2)+(a2*b1);
        b3 = b1*b2;

        int result = getGcd(a3,b3);

        System.out.println(a3/result+" "+b3/result);
    }

    public static int getGcd(int a, int b) {
        if(a%b==0) {
            return b;
        }
        return getGcd(b, a%b);
    }
}
