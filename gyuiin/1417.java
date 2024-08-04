import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 설정
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N]; // 후보자의 수

        for (int i = 0; i < N; i++) { // 후보자의 수만큼 득표수 저장
            num[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐를 내림차순으로 선언

        for (int i = 1; i < N; i++) { // 후보들의 득표수를 큐에 삽입
            pq.offer(num[i]);
        }

        int dasom = num[0]; // 다솜이의 초기 득표수
        int count = 0; // 매수한 사람의 수

        while (!pq.isEmpty() && pq.peek() >= dasom) { // 다솜이의 득표수가 다른 후보들보다 많아질 때까지 반복
            int maxVotes = pq.poll(); // 가장 많은 득표수를 가진 후보를 한 표 매수 (큐에서 제거)
            maxVotes--; // 가져온 후보의 득표수를 감소
            dasom++; // 다솜이의 득표수 증가
            count++; // 매수한 사람의 수 증가
            pq.offer(maxVotes); // 득표수를 하나 줄인 후보를 다시 큐에 삽입
        }

        bw.write(String.valueOf(count)); // 결과 출력
        bw.flush(); // 버퍼 정리
        br.close();
        bw.close();
    }
}
