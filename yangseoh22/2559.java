import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 온도의 개수
        int k = Integer.parseInt(st.nextToken());  // 며칠 간의 온도를 더할 것인지
        int[] arr = new int[n+1];  // 온도 저장 배열 (인덱스 0은 사용x)
        int[] acc = new int[n+1]; // 누적 합 계산 결과 저장 배열

        st = new StringTokenizer(br.readLine());  // 온도 수열 입력 받기
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적 합 구하기
        acc[1] = arr[1];  // 첫 번째 누적 합은 그대로
        for(int i=2; i<=n; i++){
            acc[i] = acc[i-1] + arr[i];
        }

        // 누적 합을 이용해 구간 합 구하기
        int max = acc[1];
        for(int i=1; i<=n-k; i++){
            int tmp = acc[i+k] - acc[i];
            if(tmp > max) max = tmp;
        }

        System.out.println(max);
    }
}
