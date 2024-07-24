import java.io.*;
import java.util.StringTokenizer;

public class j_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //문자 쪼개기

        int N = Integer.parseInt(st.nextToken()); //온도를 측정한 전체 날짜 수 N
        int K = Integer.parseInt(st.nextToken()); //연속적인 날짜의 수 K
        int[] arr = new int[N]; //배열

        //입력 받은 값 " " 단위로 쪼개서 arr배열에 담기
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //입력 받을 값들의 합을 구함
        int arrsum = 0;
        for (int i = 0; i < K; i++) {
            arrsum += arr[i];
        }
        //maxSum을 값들의 합으로 지정
        int maxSum = arrsum;

        // K일씩 이동하면서 합을 업데이트
        for (int i = K; i < N; i++) {
            arrsum = arrsum - arr[i-K] + arr[i];
            if (arrsum > maxSum) {
                maxSum = arrsum;
            }
        }
        //출력
        System.out.println(maxSum);
    }
}
