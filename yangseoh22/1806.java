import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  //수열의 길이
        int S = Integer.parseInt(st.nextToken());  //검사 기준
        int[] arr = new int[N];

        //수열 입력 받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = N;  //최소 길이
        int right = 0;
        int currSum = arr[0];  //현재 부분합
        boolean flag = false;  //합이 S이상이 되었는가
        for(int i=0; i<N; i++){
            //부분합이 S 이상이 되기 전까지의 합
            while(currSum < S && right < N-1){
                currSum += arr[++right];
            }

            //S이상이 되었을 때의 범위
            if(currSum >= S) {
                int tmp = right-i+1;
                flag = true;
                if(min>tmp) min = tmp;
            }
            currSum -= arr[i];
        }

        //S이상의 부분합이 없으면 0 출력
        if(!flag) min = 0;

        System.out.println(min);
    }
}
