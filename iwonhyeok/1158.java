import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 요세푸스 문제 조건 N, K
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        //LinkedList로 구현되어있는 Queue 사용
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll()); //.poll()은 queue의 front를 리턴하고 제거
            }
            result.append(queue.poll());
            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }

        result.append(">");
        System.out.println(result);
    }
}
