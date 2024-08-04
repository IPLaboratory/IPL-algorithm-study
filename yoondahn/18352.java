import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 18352 - 특정 거리의 도시 찾기
public class Main {
    static class Node implements Comparable<Node> {
        int vertex;     // 정점
        int distance;   // 거리

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return this.distance - other.distance;  // 거리를 오름차순으로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 도시의 개수
        int m = Integer.parseInt(st.nextToken());   // 도로의 개수
        int k = Integer.parseInt(st.nextToken());   // 목표 거리
        int x = Integer.parseInt(st.nextToken());   // 출발 도시의 번호

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());   // 그래프 초기화
        }

        for (int i = 0; i < m; i++) {   //  A번 도시에서 B번 도시로 이동하는 단방향 도로 그래프
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, 1)); // 간선 추가 (거리는 항상 1)
        }
        br.close();

        int[] distances = dijkstra(n, graph, x);    // 최단 거리 계산

        boolean found = false;  // k만큼 떨어진 도시가 존재하는지 여부
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (distances[i] == k) {    // 최단 거리가 k이면 출력
                sb.append(i).append("\n");
                found = true;
            }
        }
        if (!found) {   // 최단 거리가 k인 도시가 존재하지 않으면 출력
            sb.append("-1");
        }
        System.out.println(sb);
    }

    // 시작 도시로부터의 최단 거리 계산
    static int[] dijkstra(int V, List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1]; // 거리 배열
        boolean[] visited = new boolean[V + 1]; // 방문 배열

        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;    // 모든 거리를 무한대로 초기화
        }
        dist[start] = 0; // 시작 도시의 거리를 0으로 설정
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) { // 큐가 빌 때까지 반복
            Node current = pq.poll();
            int currentNode = current.vertex;

            if (visited[currentNode]) { // 이미 처리된 노드는 무시
                continue;
            }
            visited[currentNode] = true;

            // 현재 노드에 연결된 모든 인접 노드를 탐색
            for (Node neighbor : graph.get(currentNode)) {
                // 새로운 경로의 거리 = 현재 노드까지의 최단 거리 + 현재 노드에서 인접 노드까지의 거리
                int newDist = dist[currentNode] + neighbor.distance;

                if (newDist < dist[neighbor.vertex]) {  // 새로운 경로가 더 짧으면 갱신
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }
        return dist;
    }
}
