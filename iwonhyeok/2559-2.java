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
        int[] temperatures = new int[N];
        for (int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 K일의 합 계산
        int maxSum = 0;
        for (int i = 0; i < K; i++) {
            maxSum += temperatures[i];
        }

        int currentSum = maxSum;

        // 누적합을 이용해서 계산
        for (int i = K; i < N; i++) {
            currentSum = currentSum + temperatures[i] - temperatures[i - K];
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
