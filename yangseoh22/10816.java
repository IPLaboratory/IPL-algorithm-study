import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());  //카드 개수
        int[] card = new int[n];  //카드 정보
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);  //카드를 오름차순 정렬

        int m = Integer.parseInt(br.readLine());  //검사할 케이스 개수
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());  //검사할 케이스 숫자

            //타겟 초과의 수가 처음 나오는 인덱스 - 타겟이 처음 나오는 인덱스
            sb.append(getUpperbound(x, card)-getLowerbound(x, card)).append(" ");
        }

        System.out.println(sb);
    }

    //lowerbound 반환
    public static int getLowerbound(int target, int[] arr){
        int low = 0;  //배열의 왼쪽 맨 끝 인덱스
        int high = arr.length;  //배열의 오른쪽 맨 끝 인덱스

        while(low < high){
            int mid = low + (high - low) / 2;  //low와 high의 중간 인덱스

            //조건 별 인덱스 변경
            if(arr[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }
    //upperbound 반환
    public static int getUpperbound(int target, int[] arr){
        int low = 0;  //배열의 왼쪽 맨 끝 인덱스
        int high = arr.length;  //배열의 오른쪽 맨 끝 인덱스

        while(low < high){
            int mid = low + (high - low) / 2;  //low와 high의 중간 인덱스

            //조건 별 인덱스 변경
            if(arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return high;
    }
}