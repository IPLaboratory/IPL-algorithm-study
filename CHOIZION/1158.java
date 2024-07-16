import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> circle = JCircle(N);
        List<Integer> result = Josephus(circle, K);

        System.out.println(Output(result));
        br.close();
    }


    private static Queue<Integer> JCircle(int N) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        return q;
    }
    private static List<Integer> Josephus(Queue<Integer> circle, int K) {
        List<Integer> sequence = new ArrayList<>();
        while (!circle.isEmpty()) {
            for (int i = 1; i < K; i++) {
                circle.offer(circle.poll());
            }
            sequence.add(circle.poll());
        }
        return sequence;
    }

    private static String Output(List<Integer> result) {
        return "<" + String.join(", ", result.stream().map(String::valueOf).toArray(String[]:: new)) + ">";
    }
}