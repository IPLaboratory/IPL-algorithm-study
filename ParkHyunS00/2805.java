import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int lo = 1;
        int hi = 2_000_000_000;
        int result = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if(isPossible(trees, mid, M)) {
                lo = mid + 1;
                result = Math.max(result, mid);
            } else {
                hi = mid - 1;
            }
        }

        System.out.print(result);
    }

    static boolean isPossible(int[] trees, int height, int M) {
        long count = 0;

        for (int i=0; i<trees.length; i++) {
            count += Math.max(trees[i] - height, 0);
        }

        return count >= M;
    }
}
