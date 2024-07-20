import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  //수의 범위
        int m = Integer.parseInt(st.nextToken());  //수열의 길이

        int[] tmp = new int[m];  //탐색 내용을 저장
        backTraking(n, m, tmp, 0);  //함수 호출

        System.out.println(sb);  //내용 출력
    }
    public static void backTraking(int n, int m, int[] arr, int depth) {
        if(depth==m){  //현재 탐색 깊이가 m과 같다면
            for(int i = 0; i < m; i++){
                sb.append(arr[i]).append(" ");  //배열 값을 출력
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=n; i++){  //1~n의 수를 반복해
            arr[depth] = i;  //현재 깊이의 배열에 수를 저장
            backTraking(n, m, arr, depth+1);  //깊이+1 하여 재귀 호출
        }
    }
}
