import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 행=열의 수
        int[][] arr = new int[n+1][n+1];  //(n+1)*(n+1) 2차원 배열 생성. 0행, 0열은 사용x
        int m = Integer.parseInt(st.nextToken());  // 합을 구해야하는 횟수
        int[][] acc = new int[n+1][n+1];  // 누적 합을 저장할 배열

        // 행렬 값 입력 받기
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬의 누적 합 구하기
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                acc[i][j] = arr[i][j] + acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1];
            }
        }

        // 합을 구할 범위의 좌표값 입력 받기 (x1, y1, x2, y2)
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(prefixSum(x1, y1, x2, y2, acc));  //구간합 계산 함수 호출
            if(i != m - 1) sb.append("\n");
        }

        System.out.println(sb);
    }

    // 구간 합 계산 함수
    static int prefixSum(int x1, int y1,int x2, int y2, int[][] arr){
        int sum = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1];

        return sum;
    }
}