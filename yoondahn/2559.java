import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 온도를 측정한 전체 날짜 수 (2~100,000)
        int k = Integer.parseInt(st.nextToken());   // 합을 구하기 위한 연속적인 날짜의 수 (1~n)

        int[] temp = new int[n+1];  // 온도 배열
        int[] acc = new int[n+1];   // 누적합 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
            acc[i] = acc[i-1] + temp[i];
        }

        int max = Integer.MIN_VALUE;    // 온도합의 최대
        int sum = 0;       // 현재 온도합
        for (int i = 0; i <= n-k; i++) {
            sum = acc[i+k] - acc[i];
            max = Math.max(max, sum);   // 최댓값 비교
        }
        System.out.println(max);
    }
}