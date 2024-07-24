import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄에서 N을 입력받음 (학생 수)
        int N = Integer.parseInt(br.readLine());
        // 예상 등수를 저장할 배열 생성
        int[] expectedRanks = new int[N];

        // N개의 예상 등수를 입력받아 배열에 저장
        for (int i = 0; i < N; i++) {
            expectedRanks[i] = Integer.parseInt(br.readLine());
        }

        // 예상 등수를 오름차순으로 정렬
        Arrays.sort(expectedRanks);

        // 불만도의 합을 계산할 변수
        long dissatisfactionSum = 0;
        // 예상 등수와 실제 등수(1부터 N까지)를 비교하여 불만도 계산
        for (int i = 0; i < N; i++) {
            dissatisfactionSum += Math.abs(expectedRanks[i] - (i + 1));
        }

        // 불만도의 합을 출력
        bw.write(String.valueOf(dissatisfactionSum));

        bw.flush();
        br.close();
        bw.close();
    }
}
