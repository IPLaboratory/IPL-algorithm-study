import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 1417 - 국회의원 선거
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 국회의원 후보 수 (1~50)
        int first = Integer.parseInt(br.readLine());  // 기호 1번을 찍으려는 사람 수
        if (n == 1) {   // 후보가 1명인 경우
            System.out.println(0);
            return;
        }

        // 우선순위가 높은 순자 순으로 큐를 선언
        PriorityQueue<Integer> pqueue = new PriorityQueue<>((Comparator.reverseOrder()));
        for (int i = 0; i < n-1; i++) {
            pqueue.add(Integer.parseInt(br.readLine()));    // 득표 수 (1~100)
        }
        int money = 0;  // 매수해야 하는 사람
        while(first <= pqueue.peek()) { // 최다득표수보다 작거나 같으면 반복
            int highest = pqueue.poll();
            highest--; // 최다 득표수 -1
            pqueue.add(highest);
            first++;    // 후보 1번 득표수 +1
            money++;    // 매수 인원 +1
        }
        System.out.println(money);
    }
}
