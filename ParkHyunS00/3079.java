import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long lo = 1L;
        long hi = (long) Arrays.stream(arr).max().getAsInt() * M;
        long result = 0L;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (isPossible(arr, mid, M)) {
                hi = mid - 1;
                result = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.print(result);
    }

    static boolean isPossible(int[] arr, long time, int friends) {
        long count = 0;

        for (int i=0; i<arr.length; i++) {
            count += time / arr[i];

            if (count >= friends) return true;
        }

        return count >= friends;
    }
}
