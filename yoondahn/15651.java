import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] list;  // 자연수 배열
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 자연수 최댓값 (1~n)
        m = Integer.parseInt(st.nextToken());   // 수열의 길이
        br.close();

        list = new int[m];  // 자동으로 0으로 초기화

        backTracking(0);
        System.out.print(sb);
    }

    static void backTracking(int row) {
        if (row == m) {     // 수열의 길이와 같아지면
            for (int i = 0; i < m; i++) {
                sb.append(list[i]).append(" "); // 수열 출력
            }
            sb.append("\n");
            return;
        }

        // 1부터 n까지의 숫자를 선택
        for (int i = 1; i <= n; i++) {
            list[row] = i;  // 현재 값을 저장
            backTracking(row + 1);  // 재귀호출
        }
    }
}