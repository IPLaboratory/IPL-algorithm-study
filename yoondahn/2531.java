import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2531 - 회전 초밥
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 전체 접시의 수
        int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        // 주어진 회전 초밥 벨트
        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] visit = new int[d+1]; // 각 초밥 종류의 개수 (1~d)
        int distinct = 0;   // 현재 윈도우에서의 초밥 종류의 수

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (visit[sushi[i]] == 0) {
                distinct++;
            }
            visit[sushi[i]]++;
        }

        // 초기 윈도우에 쿠폰 초밥이 포함되어 있는지 확인
        int max = distinct; // 현재 최대로 먹을 수 있는 초밥 종류의 수
        if (visit[c] == 0) max++;

        // 슬라이딩 윈도우
        for (int i = 0; i < n; i++) {
            // 맨 앞 초밥 제거
            int front = sushi[i];
            visit[front]--; // 초밥의 개수를 감소
            if (visit[front] == 0) {
                distinct--; // 초밥 종류의 수를 감소
            }

            // 맨 뒤 초밥 추가
            int back = sushi[(i + k) % n];
            if (visit[back] == 0) {
                distinct++;
            }
            visit[back]++;

            // 쿠폰 초밥이 포함되어 있는지 확인
            int total = distinct;
            if (visit[c] == 0) total++;

            max = Math.max(max, total);
        }
        System.out.println(max);
    }
}
