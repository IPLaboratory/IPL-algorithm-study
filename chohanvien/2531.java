import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j_2531 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
    private static int N, D, k, C;
    private static int[] arr;
    private static int[] eat;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시의 수 N
        D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수 D
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수 K
        C = Integer.parseInt(st.nextToken()); //쿠폰 번호 C

        eat = new int[D+1]; // 초밥 종류를 카운트 eat
        arr = new int[N]; // 접시 arr
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 각 접시에 놓인 초밥 번호
        }
        System.out.println( twoPointers() );
        br.close();
    }

    private static int twoPointers() {
        int count = 0, max;

        //반복문으로 초기 k개의 초밥을 선택해 카운트
        for (int i = 0; i < k; i++) {
            if (eat[ arr[i] ] == 0) count++; // 처음 먹는 종류의 초밥 종류라면 카운트 + 1
            eat[ arr[i] ]++; //초밥 개수 증가
        }
        max = count; // 현재까지 먹은 최대 종류의 초밥 개수

        //반복문으로 최대 초밥 종류를 계산
        for (int i = 1; i < N; i++) {
            if (max <= count) {
                if (eat[C] == 0) max = count + 1;
                else max = count;
            }

            // 왼쪽 끝 초밥 제거
            eat[arr[i-1]]--;
            if (eat[arr[i-1]] == 0) count--;

            //오른쪽 끝에 새로운 초밥 추가
            if (eat[arr[(i+k-1) % N]] == 0) count++;
            eat[arr[(i+k-1) % N]]++;
        }

        return max;// 계산된 최대 초밥 종류 반환
    }
}
