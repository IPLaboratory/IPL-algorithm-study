import java.io.*;
import java.util.Arrays;

public class j_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(arr[i] - (i + 1));
        }

        System.out.print(sum);
    }
}

