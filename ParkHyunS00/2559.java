import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int [N + 1];
        int[] accSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++) {
            accSum[i] = accSum[i - 1] + arr[i];
        }

        int result = Integer.MIN_VALUE;
        for (int i=1; i<=N; i++) {
            if (i + K - 1 > N) break;

            result = Math.max(result, (accSum[i + K - 1] - accSum[i - 1]));
        }

        System.out.print(result);
    }
}
