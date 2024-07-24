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

        // 첫 번째 줄 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기 높이 배열 입력받기
        int[] heights = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 조교 수만큼 명령 입력받고 시행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int j = a; j <= b; j++) {
                heights[j] += k;
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            bw.write(heights[i] + " ");
        }
        // 리소스 정리
        bw.flush();
        bw.close();
        br.close();
    }
}
