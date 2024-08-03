import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dasomVote = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;

        if (N != 1) {
            for (int i=0; i<N-1; i++) pq.add(Integer.parseInt(br.readLine()));

            while (pq.peek() >= dasomVote) {
                int otherVote = pq.poll();

                otherVote--;
                dasomVote++;
                result++;
                pq.add(otherVote);
            }
        }
        System.out.print(result);
    }
}
