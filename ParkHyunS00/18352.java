import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>();

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, 1));
        }

        int[] dist = dijkstra(graph, N, X);

        for (int i=0; i<=N; i++) {
            if (dist[i] != Integer.MAX_VALUE && dist[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if (sb.toString().isEmpty()) sb.append("-1").append("\n");
        System.out.print(sb);
    }

    static int[] dijkstra(List<List<Node>> graph, int N, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Node next : graph.get(node.vertex)) {
                if (dist[next.vertex] > dist[node.vertex] + next.weight) {
                    dist[next.vertex] = dist[node.vertex] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        return dist;
    }

    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
