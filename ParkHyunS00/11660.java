import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        int[][] accSum = new int[N + 1][N + 1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                accSum[i][j] = accSum[i - 1][j] + accSum[i][j - 1] - accSum[i - 1][j - 1] + arr[i][j];
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(accSum[x2][y2] - accSum[x1 - 1][y2] - accSum[x2][y1 - 1] + accSum[x1 - 1][y1 - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
