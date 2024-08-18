import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = 100_001;
        int index = 0;
        int currSum = arr[0];
        for (int i=0; i<N; i++) {
            while (currSum < S && index < N - 1) currSum += arr[++index];

            if (currSum >= S) {
                length = Math.min(index - i + 1, length);
            }

            currSum -= arr[i];
        }

        System.out.print((length == 100_001) ? 0 : length);
    }
}
