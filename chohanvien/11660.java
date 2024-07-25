import java.io.*;
import java.util.StringTokenizer;

public class j_11660_y {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //출력
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //문자 쪼개기

        int N = Integer.parseInt(st.nextToken()); //표의 크기 N
        int M = Integer.parseInt(st.nextToken()); //합을 구해야 하는 횟수 M
        int[][] N2 = new int[N + 1][N + 1]; //값 담을 2차 배열 N2 생성
        int[][] prefixSum = new int[N + 1][N + 1]; //누적합 담을 2차 배열 prefixSum 생성

        //반복문 통해 N2배열에 값을 넣고 누적 합 계산
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                N2[i][j] = Integer.parseInt(st.nextToken());
                // 누적 합 계산
                prefixSum[i][j] = N2[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
        
        //반복문 통해 입력 받은 값을 x1, y1, x2, y2에 각각 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 후에 구간 합 계산
            int sum = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
            //bw에 구간 합 저장
            bw.write(sum + "\n");
        }
        
        //출력
        bw.flush();
        //닫기
        bw.close();
        br.close();
    }
}
