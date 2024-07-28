import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        long maxTime = 0L;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, arr[i]);
        }

        long result = binarySearch(arr, N, M, maxTime);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 시간에 대한 이분탐색
    private static long binarySearch(int[] arr, int N, int M, long maxTime) {
        long low = 0;
        long high = maxTime * M;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            long count = 0;


            // 여기서 count가 long 최대 값보다 커질 수 있다고 한다. 이건 진짜 몰랐다...
            // 사람 수가 오버플로우 될 수 있으니 M을 넘는지 확인하고 for 루프를 탈출할 수 있게 해줘야 한다.
            // if(count >= M) break; 오버플로우가 되지 않도록 아래에 이 코드를 넣어주면 된다...
            for (int i = 0; i < N; i++) {
                count += mid / arr[i];
            }

            // M명을 전부 보낸 시간을 찾더라도, 계속해서 시간을 탐색해야 한다.
            if (count >= M) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
