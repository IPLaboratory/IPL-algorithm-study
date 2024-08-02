import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class j_3079 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());  //심사대 개수
        int M = Integer.parseInt(st.nextToken()); //인원

        //반복문으로 심사대에서 걸리는 시간을 배열에 저장
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        ////////////////////////////////////////////////////////
        long answer = Long.MAX_VALUE;
        //최소값(적어도 1명 처리하는 시간 이상은 걸리므로)
        long start = arr[0];
        //최대값(최악의 경우는 가장 오래 걸리는 심사대가 모든 사람들을 처리하는 경우)
        long end = (long)arr[arr.length-1]*(long)M;

        //반복문
        while(start<=end) {
            //중간값
            long mid = (start + end) / 2;
            long sum = 0;
            for (int time : arr)
                sum += mid / time;
            //만약 처리한 사람의 수가 목표값 M 이상이면 오른쪽 절반을 버린다.
            if (sum >= M) {
                answer = mid;
                end = mid - 1;
            //만약 처리한 사람의 수가 목표값 M 미만이면 왼쪽 절반을 버린다
            } else
                start = mid + 1;
        }
        System.out.println(answer);
    }
}
