import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lanLines = new int[K];

        for (int i=0; i<K; i++) {
            lanLines[i] = Integer.parseInt(br.readLine());
        }

        long lo = 1L;
        long hi = Arrays.stream(lanLines).max().getAsInt();
        long result = 1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (isPossible(lanLines, mid, N)) {
                lo = mid + 1;
                result = Math.max(result, mid);
            } else {
                hi = mid - 1;
            }
        }

        System.out.print(result);
    }

    static boolean isPossible(int[] lanLines, long length, int totalCount) {
        long count = 0;

        for (int i=0; i<lanLines.length; i++) {
            count += (lanLines[i] / length);
        }

        return count >= totalCount;
    }
}
