import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   // 가지고 있는 숫자 카드의 수 (1~500,000)
        int[] card = new int[n];    // 숫자 카드에 적혀있는 정수 (-10,000,000~10,000,000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);  // 가지고 있는 카드를 오름차순 정렬

        int m = Integer.parseInt(br.readLine());    // 구해야 할 숫자 카드의 수 (1~500,000)
        int[] need = new int[m];     // 몇 개 가지고 있는지 구해야 할 정수 (-10,000,000~10,000,000)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int num = 0;    // 몇 개 가지고 있는지 저장
        for (int i = 0; i < m; i++) {
            num = upperBound(card, need[i]) - lowerBound(card, need[i]);    // 중복값을 저장
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    // 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치
    private static int lowerBound(int[] card, int target) {
        int start = 0, end = card.length;
        while (start < end) {
            int mid = (start + end) / 2;

            // 찾고자 하는 값의 이상이므로 -> 찾고자하는 값보다 작을 때 적용
            if (card[mid] < target) { start = mid + 1; }
            else { end = mid; }
        }
        return end;
    }

    // 찾고자 하는 값 초과한 값을 처음 만나는 위치
    private static int upperBound(int[] card, int target) {
        int start = 0, end = card.length;
        while (start < end) {
            int mid = (start + end) / 2;

            // 찾고자 하는 값의 초과이므로 -> 찾고자하는 값보다 작거나 같을 때 적용
            if (card[mid] <= target) { start = mid + 1; }
            else { end = mid; }
        }
        return end;
    }
}