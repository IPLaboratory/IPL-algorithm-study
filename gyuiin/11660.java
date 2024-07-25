import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int[][] arr = new int[N + 1][N + 1]; // 배열의 인덱스를 1부터 사용하기 위해
        for (int i = 1; i <= N; i++) { // 배열의 값을 입력 받아 arr에 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] accSum = new int[N + 1][N + 1]; // 배열의 인덱스를 1부터 사용하기 위해
        for (int i = 1; i <= N; i++) { // 각 위치에서의 누적합
            for (int j = 1; j <= N; j++) {
                accSum[i][j] = arr[i][j] + accSum[i - 1][j] + accSum[i][j - 1] - accSum[i - 1][j - 1];
                          // 현재 위치의 값 + 위쪽 누적 합 + 왼쪽 누적 합 - 대각선왼쪽 위 누적 합
                          // 중복되어 더해진 값은 다시 빼주기
            }
        }

        for (int i = 0; i < M; i++) { // 합을 구해야 하는 횟수만큼 반복
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); // 네 개의 정수 입력 받기
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = accSum[x2][y2] - accSum[x1 - 1][y2] - accSum[x2][y1 - 1] + accSum[x1 - 1][y1 - 1];
                   // 전체 합에서 원하는 구간을 제외한 부분 제거해주고 두 번 제거된 부분은 더해주기
            sb.append(sum).append("\n"); // 결과 sb에 추가
        }

        bw.write(sb.toString()); // 결과 출력
        bw.flush(); // 사용한 버퍼 제거
        br.close();
        bw.close();
    }
}
