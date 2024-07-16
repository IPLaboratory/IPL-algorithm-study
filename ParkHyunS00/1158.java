import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            deque.add(i);
        }

        sb.append("<");
        for (int i=1; i<=N; i++) {
            for (int j=0; j<K-1; j++) deque.addLast(deque.removeFirst());

            if (i == N) sb.append(deque.removeFirst()).append(">");
            else sb.append(deque.removeFirst()).append(", ");
        }

        System.out.print(sb);
    }
}
