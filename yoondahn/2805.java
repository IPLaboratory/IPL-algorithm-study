import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());    // 나무의 수 (1~1,000,000)
        int m = Integer.parseInt(st.nextToken());    // 필요한 나무의 길이 (1~2,000,000,000)

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[n];    // 나무의 높이 (0~1,000,000,000)
        long min = 0, max = 0;      // mid가 long 타입이므로 long으로 통일
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > max) max = tree[i];   // max 변수를 나무의 높이 배열 중 최댓값으로 갱신
        }

        long h = 0; // 절단기 높이
        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;   // 잘린 나무의 길이의 합

            for (int x : tree) {
                if (x > mid) sum += x - mid; // 높이가 mid보다 큰 나무를 자르고 sum에 더함
            }

            if (sum < m) {  // 잘린 나무의 길이 < 필요한 나무의 길이 -> 왼쪽 부분 탐색
                max = mid - 1; // 절단기 높이를 낮춤
            } else {
                h = mid; // 필요한 나무의 길이보다 많으면 결과를 저장
                min = mid + 1; // 오른쪽 부분 탐색 -> 절단기 높이를 높임
            }
        }
        System.out.println(h);
    }
}