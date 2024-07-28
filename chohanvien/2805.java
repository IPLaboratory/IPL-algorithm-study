import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class j_2805_y {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); //나무의 수
        long M = Integer.parseInt(st.nextToken()); // 집으로 가져가려고 하는 나무의 길이
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; //시작점은 0
        int end = Arrays.stream(arr).max().getAsInt(); //끝점은 가장 큰 값 사용
        long result = 0; // int가 아니라 long 형태로 지정
        while (start <= end) {
            long total = 0; // int가 아니라 long 형태로 지정
            int mid = (start + end) / 2;

            for(int x : arr){
                if(x > mid){
                    total += x - mid;
                }
            }
            //나무의 양이 부족하다면 왼쪽 부분 선택
            if(total < M){
                end = mid-1;
                //떡의 양이 충분하다면 result 저장 및 오른쪽 부분 탐색
            }else{
                result = mid;
                start = mid + 1;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
