import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 배열 arr
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1]; // 누적합 배열
        for (int i = 1; i <= N; i++) {
            // 이전까지의 누적합에 현재 값을 더하여 저장
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        // 최대값을 찾아야 한다.
        int max = Integer.MIN_VALUE;
        // K 길이의 구간합 중 최대값 찾기
        for (int i = K; i <= N; i++) {

            // arr[i] - arr[i - K]는 구간 [i-K+1, i]의 합
            max = Math.max(max, arr[i] - arr[i - K]);
        }

        bw.write(max + "");
        bw.close();
        br.close();
    }

}
