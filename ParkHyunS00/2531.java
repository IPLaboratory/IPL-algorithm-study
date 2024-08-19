import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushiKinds = new int[d + 1];
        int[] dishes = new int[N];

        for (int i=0; i<N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        int unique = 0;
        for (int i=0; i<k-1; i++) {
            if (sushiKinds[dishes[i]]++ == 0) unique++;
        }

        int result = 0;
        for (int i=0; i<N; i++) {
            if (sushiKinds[dishes[(i + k - 1) % N]]++ == 0) unique++;

            result = Math.max(result, unique + (sushiKinds[c] == 0 ? 1 : 0));
            sushiKinds[dishes[i]]--;
            if (sushiKinds[dishes[i]] == 0) unique--;
        }

        System.out.print(result);
    }
}
