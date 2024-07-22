import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(list);  // 오름차순 정렬

        long discontent = 0; // 불만도 (1 ≤ N ≤ 500,000이므로 |1-500,000| x 500,500)
        for (int i = 0; i < n; i++) {
            if (list[i] != i+1) {   // 예상한 등수와 다른 경우
                discontent += Math.abs(list[i] - (i+1));    // 오차값을 불만도에 더함
            }
        }
        System.out.println(discontent);
    }
}