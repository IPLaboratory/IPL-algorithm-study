import java.io.*;
import java.util.StringTokenizer;

public class j_1158_yes {
    private static int front;
    private static int rear;
    private static int N;
    private static int[] queue;

    // 큐의 삽입 연산
    private static void enQueue(int item) {
        if (isFull()) {
            System.out.println("큐가 꽉참");
        } else {
            queue[rear] = item;
            rear++;
            rear %= queue.length;
        }
    }

    // 큐가 가득 차있는지 확인
    private static boolean isFull() {
        return front == (rear + 1) % queue.length;
    }

    private static void dequeue(int item2) {
        queue[item2] = 0;
        front++;
        front %= queue.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 인원수
        int K = Integer.parseInt(st.nextToken()); // 제거할 번호
        queue = new int[N+1];
        front = 0;
        rear = 0;

        for (int i = 0; i < N; i++) {
            enQueue(i + 1);
        }

        sb.append('<');
        int cnt = 0;
        //원형 큐에서 K번째 사람을 찾도록 해줌
        int currentPos = 0;
        // 모든 사람들이 제거될 때까지 반복
        while (cnt < N) {
            int step = 0;

            // K번째 사람을 찾기 위한 루프
            while (step < K) {
                if (queue[currentPos] != 0) {
                    step++;
                }
                if (step == K) {
                    break;
                }
                currentPos++;
                //원형 큐를 순환하도록 %=N 연산을 이용
                currentPos %= N;
            }

            // 현재 위치의 사람을 제거
            sb.append(queue[currentPos] + ", ");
            dequeue(currentPos);
            cnt++;
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');
        System.out.println(sb);
    }
}
