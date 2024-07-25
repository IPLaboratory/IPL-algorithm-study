import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] variance = new int[N + 2];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            variance[a] += k;
            variance[b + 1] += (-1 * k);
        }

        int[] accSum = new int[N + 1];
        for (int i=1; i<=N; i++) {
            accSum[i] = accSum[i - 1] + variance[i];
        }

        for (int i=1; i<=N; i++) {
            sb.append(arr[i] + accSum[i]).append(" ");
        }

        System.out.print(sb);
    }
}
