import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 표준 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 표준 출력

        N = Integer.parseInt(br.readLine());

        long[] expectedRankingArr = new long[N];

        for (int i = 0; i < N; i++) {
            expectedRankingArr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(expectedRankingArr);

        int cnt = 1;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            long tmpRanking = expectedRankingArr[i];
            ans += Math.abs(tmpRanking - cnt);
            cnt++;
        }

        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
