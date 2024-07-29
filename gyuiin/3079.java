import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 심사대의 수
        int M = Integer.parseInt(st.nextToken()); // 상근이와 친구들 수

        int[] times = new int[N]; // 심사대의 심사 시간

        for (int i = 0; i < N; i++) { // 심사 시간을 심사대의 수만큼 입력 받기
            times[i] = Integer.parseInt(br.readLine());
        }
    }
}
