import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 문자 쪼개기

        int N = Integer.parseInt(st.nextToken()); // N짜리 수열
        int S = Integer.parseInt(st.nextToken()); // 합 S 이상
        int[] arr = new int[N]; //배열 arr

        //반복문 통해서 arr값에 값 저장
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE; // 최소 길이 min
        int start = 0; // 시작
        int end = 0; // 끝
        int total = 0; // 현재 부분 합
        // 반복문으로 투 포인터를 이용한 부분 합 계산
        while(start <= N && end < N) {
            if(total >= S && min > end - start) min = end - start;

            if(total < S) total += arr[end++];
            else total -= arr[start++];
        }

        // 최소 길이가 갱신되지 않았으면 0을 출력
        if(min == Integer.MAX_VALUE){
            System.out.println("0");
        //그렇지 않으면 최소 길이를 출력
        }else{
            System.out.println(min);
        }
    }
}
