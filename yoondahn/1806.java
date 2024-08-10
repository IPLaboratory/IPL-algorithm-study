import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1806 - 부분합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터
        int min = n + 1;
        int right = 0;
        int currSum = arr[0];
        for (int i = 0; i < n; i++) {
            // 현재 탐색하는 구간합이 s보다 크거나 같을 때까지 j 이동
            while (currSum < s && right < n - 1) {
                currSum += arr[++right];
            }

            // 합이 s 이상이면 경우의 수 증가
            if (currSum >= s) {
                int length = right - i + 1;
                if (length < min ) min = length;
            }
            // 현재 구간합이 s보다 크므로 i 이동
            currSum -= arr[i];
        }
        System.out.println(min == n + 1 ? "0" : min);
    }
}
