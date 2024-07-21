import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 표쥰 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 표준 출력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1부터 n까지의 숫자 사용
        int m = Integer.parseInt(st.nextToken()); // 수열의 길이

        arr = new int[m];
        dfs(n, m, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    // DFS 깊이 우선 탐색 알고리즘
    private static void dfs(int n, int m, int level) {
        if (level == m) { // 길이가 m이 되면 출력
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 1부터 n까지의 숫자를 사용하여 수열 만들기
        for (int i = 0; i < n; i++) {
            arr[level] = i + 1;
            dfs(n, m, level + 1);
        }
    }

}