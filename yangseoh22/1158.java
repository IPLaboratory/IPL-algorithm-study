import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<Integer>();  //정수형 큐 선언

        int n = Integer.parseInt(st.nextToken());  //사람 수
        int k = Integer.parseInt(st.nextToken());  //제거할 순서

        int idx = 0;  //제거할 순서의 인덱스

        //원에 앉아있는 사람들
        int[] circle = new int[n];
        for (int i = 0; i < n; i++) {
            circle[i] = i+1;
        }

        for(int i = n; i>0; i--) {
            idx = (idx + (k-1)) % i;  //k주기
            q.add(circle[idx]);  //삭제한 사람은 큐에 넣기

            //삭제 후 재정렬 (삭제한 원소 다음 원소들을 앞으로 하나씩 이동)
            for(int j = idx; j < n-1; j++){
                circle[j] = circle[j+1];
            }
        }

        //큐의 모든 원소를 반환
        sb.append("<");

        for(int i=0; i<n; i++) {
            if(!q.isEmpty()){  //큐가 비어있지 않다면
                int tmp = q.poll();  //제일 앞의 요소를 반환
                //그 값을 sb에 추가. 단, 마지막 원소 제외하고 공백을 함께
                if (i != n - 1) sb.append(tmp+", ");
                else sb.append(tmp);
            }
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}