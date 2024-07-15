import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N - 1; i++) {
            sb.append(answer.get(i)).append(", ");
        }
        sb.append(answer.get(N - 1)).append(">");

        System.out.println(sb.toString());
    }
}
