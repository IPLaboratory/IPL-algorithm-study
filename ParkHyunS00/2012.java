import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] predictions = new int[N];

        for (int i=0; i<N; i++) {
            predictions[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(predictions);

        long absSum = 0L;
        for (int i=0; i<N; i++) {
            absSum += Math.abs(predictions[i] - (i + 1));
        }

        System.out.print(absSum);
    }
}
