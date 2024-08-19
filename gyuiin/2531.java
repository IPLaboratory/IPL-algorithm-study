import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] list=new int[N + k - 1];
        for (int i = 0; i < N; i++) { // 벨트에 놓인 접시들 번호 입력 받기
            list[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k-1; i++) { // 벨트의 원형으로 처리
            list[N++] = list[i];
        }

        int[] eaten = new int[d + 1];  // 각 초밥 번호가 몇 번 먹혔는지
        int max = 1; // 먹은 초밥의 최대 종류의 수
        eaten[c] += 1;

        int start = 0;
        for (int i = start; i < k; i++) { // 초밥 확인, 종류 카운트 후 배열 업데이트
            if(eaten[list[i]] == 0) {
                max++;
            }
            eaten[list[i]] += 1;
        }

        // 슬라이딩 윈도우
        start=0;
        int end = k;

        int result = max;
        for (int i = end; i < list.length; i++) {
            eaten[list[start]] -= 1;
            if(eaten[list[start]] == 0) {
                result -= 1;
            }
            if(eaten[list[i]] == 0) result += 1;
            eaten[list[i]] += 1;
            max = Math.max(max, result);
            start++;
        }

        System.out.println(max);
    }
}
