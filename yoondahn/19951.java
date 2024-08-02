import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 연병장의 크기 (1~100,000)
        int m = Integer.parseInt(st.nextToken());   // 조교의 수 (1~100,000)

        st = new StringTokenizer(br.readLine());
        int[] h = new int[n+1];   // 연병장의 각 칸의 높이 (-10,000~10,000)
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int sum[] = new int[n+2];   // 높이 변경을 적용할 누적합 배열
        // a번 칸부터 b번 칸까지 높이가 각각 |k| 만큼 증가/감소
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sum[a] += k;    // 시작점에 k를 더함
            sum[b+1] -= k;  // 끝나는 지점 다음 칸에 k를 뺌
        }

        // 누적합 배열을 이용하여 높이 변경 적용
        for (int i = 1; i <= n; i++) {
            sum[i+1] += sum[i];
            sb.append(h[i] + sum[i]).append(" ");
        }
        System.out.print(sb);
    }
}