import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 표의 크기(1~1024)
        int m = Integer.parseInt(st.nextToken());   // 합을 구해야하는 횟수(1~10,000)

        int[][] arr = new int[n+1][n+1];    // 주어진 표 배열
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] acc = new int[n+1][n+1];    // 누적합 배열
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 구하고자 하는 각 행열의 앞의 구간합 - 중복되는 부분의 구간합 + 자기자신 값
                acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + arr[i][j];
            }
        }

        // (x1, y1)부터 (x2, y2)까지 합
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 전체 구간합 - 구하고자 하는 각 행열의 앞의 구간합 - 중복되는 부분의 구간합
            int sum = acc[x2][y2] - acc[x1-1][y2] - acc[x2][y1-1] + acc[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}