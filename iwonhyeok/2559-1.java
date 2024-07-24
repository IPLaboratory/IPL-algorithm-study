import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 최대로 입력받을 일 수
        int K = Integer.parseInt(st.nextToken()); // 누적합 계산할 연속된 일 수

        st = new StringTokenizer(br.readLine());
        int[] temperatures = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        int accSum[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            accSum[i] = accSum[i - 1] + temperatures[i];
        }

        int maxSum = -2147483648;
        for (int i = K; i <= N; i++) {
            int currentSum = accSum[i] - accSum[i - K];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        // 결과 출력 및 리소스 정리
        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();
        br.close();
    }
}
