import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); //StringTokenizer 선언

        int N = Integer.parseInt(st.nextToken()); // N 입력 받기
        int K = Integer.parseInt(st.nextToken()); // K 입력 받기

        Queue<Integer> queue = new LinkedList<>(); // Queue 인터페이스를 구현하는 LinkedList 인스턴스

        for (int i = 1; i <= N; i++) { // 1부터 N까지 숫자를 큐에 추가 (N명의 사람을 큐에 추가)
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder(); // StringBuilder 선언
        sb.append("<"); // < 출력

        while(queue.size() != 1) { // 큐의 크기가 1이 될 떄까지 반복
            for (int i = 0; i < K - 1; i++) { // K-1번 반복
                queue.offer(queue.poll()); // 큐의 앞에서 값을 꺼내서(poll) 뒤에 넣기(offer)
            }
            sb.append(queue.poll() + ", "); // K번째 값을 큐에서 꺼내서 sb에 넣기
        }

        sb.append(queue.poll() + ">"); // 마지막 값을 큐에서 꺼내서 sb에 넣기

        bw.write(sb.toString() + "\n"); // 결과값 출력
        bw.flush(); // 사용한 버퍼 정리
        bw.close();
        br.close();
    }
}

