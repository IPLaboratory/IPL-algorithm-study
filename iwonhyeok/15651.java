import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄에서 N과 M을 입력받음
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // M 크기의 배열을 생성하여 순열을 저장
        int[] sequence = new int[M];
        // DFS를 사용하여 모든 가능한 순열을 생성
        dfs(N, M, 0, sequence);
        // StringBuilder에 저장된 결과를 BufferedWriter로 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    // 깊이 우선 탐색(DFS) 함수
    public static void dfs(int N, int M, int depth, int[] sequence) {
        // 현재 깊이가 M과 같으면 배열의 내용을 StringBuilder에 추가
        if (depth == M) {
            for (int num : sequence) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 1부터 N까지의 숫자를 순서대로 배열에 넣고 재귀 호출
        for (int i = 1; i <= N; i++) {
            sequence[depth] = i;
            dfs(N, M, depth + 1, sequence);
        }
    }
}
