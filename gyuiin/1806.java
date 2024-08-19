import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열의 길이
        int s = Integer.parseInt(st.nextToken()); // 목표 합

        int[] arr = new int[n+1]; // 사용자의 입력을 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE; // 부분 배열의 최소 길이
        int sum = 0; // 시작과 끝 배열의 합

        while(start <= end && end <= n) { // 슬라이딩 윈도우
            if(sum < s) {
                sum += arr[end++];
            } else if(sum >= s) {
                len = Math.min(len, end-start);
                sum -= arr[start++];
            }
        }
        System.out.println(len==Integer.MAX_VALUE ? 0 : len);
    }
}

