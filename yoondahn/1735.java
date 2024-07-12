import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 유클리드 호제법을 사용하여 최대공약수 구현
    public static int findGCD(int a, int b) {
        if (a%b == 0) return b;
        return findGCD(b, a%b);     // a->b, b->a%b
    }

    // 최소공배수 구현
    public static int findLCM(int a, int b) {
        return (a*b) / findGCD(a, b);   // (a*b) / 최대공약수
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num = new int[4];     // 분자 배열
        int[] denum = new int[4];   // 분모 배열
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
            denum[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 분수 합 구하기
        denum[2] = findLCM(denum[0], denum[1]);     // 분모를 최소공배수로 통일
        num[2] = num[0] * (denum[2] / denum[0]) + num[1] * (denum[2] / denum[1]);

        // 기약분수 구하기 (최대 공약수를 구해서 나눔)
        int gcd = findGCD(num[2], denum[2]);
        num[3] = num[2] / gcd;
        denum[3] = denum[2] / gcd;

        bw.write(num[3] + " " + denum[3]);
        bw.flush();
        bw.close();
    }
}