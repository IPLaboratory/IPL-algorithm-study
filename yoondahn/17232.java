import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17232 - 생명 게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 바둑판의 세로길이
        int m = Integer.parseInt(st.nextToken());   // 바둑판의 가로길이
        int t = Integer.parseInt(st.nextToken());   // 바둑판을 관찰하고자 하는 시간

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());   // 주위의 기준이 되는 정수
        int a = Integer.parseInt(st.nextToken());   // 상황을 결정하는 최소 정수
        int b = Integer.parseInt(st.nextToken());   // 상황을 결정하는 최대 정수

        // 바둑판 배열의 초기 상태 입력
        char[][] map = new char[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 1; j < m+1; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }

        // 누적합 배열을 이용하여 상태 업데이트
        int[][] sum = new int[n+1][m+1];
        for (int time = 0; time < t; time++) {  // 입력받은 시간동안 반복
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < m+1; j++) {
                    // 주위 생명 수 = 위쪽 부분 누적합 + 왼쪽 부분 누적합 - 중복된 부분의 누적합
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
                    if (map[i][j] == '*') sum[i][j]++;  // 자기자신 추가
                }
            }

            // 각 칸의 주위 생명 수 계산 및 상태 업데이트
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < m+1; j++) {
                    // 주위 영역 좌표 계산 (바둑판 경계를 넘지 않도록 제한)
                    int r1 = Math.max(i-k, 1);
                    int c1 = Math.max(j-k, 1);
                    int r2 = Math.min(i+k, n);
                    int c2 = Math.min(j+k, m);

                    // 주위 생명 수 = 오른쪽 하단 - 왼쪽 열 - 오른쪽 열 + 중복된 부분
                    int around = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
                    if (map[i][j] == '*') around--;     // 자기자신 제외

                    // 상태 업데이트
                    if (map[i][j] == '*') { // 생명이 있을 때
                        if (around < a || around > b) map[i][j] = '.';  // 고독 또는 과밀
                        else map[i][j] = '*';   // 생존
                    } else {    // 생명이 없을 때
                        if (around > a && around <= b) map[i][j] = '*'; // 탄생
                        else map[i][j] = '.';
                    }
                }
            }
        }
        // 최종 상태 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}