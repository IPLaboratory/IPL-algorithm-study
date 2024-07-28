import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 나무의 수, 집으로 가져가려는 나무의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 나무의 높이 배열
        int[] trees = new int[n];

        // 나무 중 최대 높이
        int maxLength = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, trees[i]);
        }

        long low = 0;
        long high = maxLength;

        while (low < high) {
            long mid = (low + high + 1) / 2;

            if (isPossible(trees, mid, m)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        bw.write(low + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPossible(int[] trees, long length, int target) {
        long count = 0;

        // 절단기로 잘리고 남은 윗부분 길이 더하기
        for (int treeHeight : trees) {
            if (treeHeight > length) {
                count += (treeHeight - length);
            }
        }

        return count >= target;
    }
}
