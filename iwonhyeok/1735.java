import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 분수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int den1 = Integer.parseInt(st.nextToken());

        // 두 번째 분수 입력
        st = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(st.nextToken());
        int den2 = Integer.parseInt(st.nextToken());

        // 두 분수의 합 도출
        int numeratorSum = num1 * den2 + num2 * den1;
        int denominatorSum = den1 * den2;

        // 기약분수로 만들기 위한 최대공약수 도출
        int resultgcd = gcd(numeratorSum, denominatorSum);

        // 기약분수 도출
        numeratorSum /= resultgcd;
        denominatorSum /= resultgcd;

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(numeratorSum + " " + denominatorSum);
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
