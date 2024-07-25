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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N + 1][N + 1];
        int[][] matrixSum = new int[N + 1][N + 1];

        // 초기 배열 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 배열 누적합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                matrixSum[i][j] = matrix[i][j] + matrixSum[i - 1][j] + matrixSum[i][j - 1] - matrixSum[i - 1][j - 1];
            }
        }

        // 구간합 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = matrixSum[x2][y2] - matrixSum[x1 - 1][y2] - matrixSum[x2][y1 - 1] + matrixSum[x1 - 1][y1 - 1];
            bw.write(result + "\n");
        }

        // 리소스 정리
        bw.flush();
        bw.close();
        br.close();
    }
}
