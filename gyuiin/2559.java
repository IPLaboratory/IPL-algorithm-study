import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입출력 버퍼 설정
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); //입력 읽기 위해

        int N = Integer.parseInt(st.nextToken()); // 배열의 길이
        int K = Integer.parseInt(st.nextToken()); // 연속된 배열의 길이

        int[] arr = new int[N + 1]; // 배열
        int[] accSum = new int[N + 1]; // 배열의 누적합

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열의 요소를 읽어들이고
            accSum[i] = accSum[i - 1] + arr[i]; // 누적합 배열
        }

        int sum1 = accSum[K]; // 길이가 K인 배열의 합을 sum1에 저장
        for (int i = 1; i <= N - K; i++) { // 최대 배열의 합 찾기
            int sum2 = accSum[i + K] - accSum[i]; // sum2에 다음 부분배열 합 저장
            if (sum2 > sum1) { // 더 큰 값을 sum1에 갱신
                sum1 = sum2;
            }
        }

        bw.write(String.valueOf(sum1)); // 결과 출력
        bw.flush(); // 사용한 버퍼 정리
        br.close();
        bw.close();
    }
}

