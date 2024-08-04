import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class j_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //후보의 수 N
        int dasom = Integer.parseInt(br.readLine()); //다솜의 표 dasom

        // 우선순위가 높은 숫자가 먼저 나옴 (큰 숫자)
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N-1; i++) {
            pQ.add(Integer.parseInt(br.readLine()));
        }

        int ck = 0; //매수해야 하는 사람의 최소값을 담을 변수
        while (!pQ.isEmpty() && dasom <= pQ.peek()) {
        //반복문 통해 다솜이 가장 큰 후보보다 작으면 반복
        // 이때 pQ가 비어있으면 런타임 에러 뜨기 때문에 !pQ.isEmpty() 작성
            int largest = pQ.poll(); //가장 큰 값을 변수에 담고 삭제
            largest -= 1;
            pQ.add(largest); //pQ에 1줄인 값 추가
            dasom += 1;
            ck += 1;
        }
        System.out.println(ck);
    }
}