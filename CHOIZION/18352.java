import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] distance;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;

        distance = new int[N];
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            graph.get(from).add(new Edge(to, 1));
        }

        distance[X] = 0;

        dijkstra(X);

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (distance[i] == K) {
                answer.add(i + 1);
            }
        }

        if (answer.isEmpty()) {
            bw.write("-1\n");
        } else {
            Collections.sort(answer);
            for (int node : answer) {
                bw.write(node + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.num;
            int dist = current.distance;

            if (dist > K) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.num;
                int newDist = dist + edge.distance;
                if (newDist < distance[v]) {
                    distance[v] = newDist;
                    pq.offer(new Edge(v, newDist));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int num;
        int distance;

        public Edge(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
}
