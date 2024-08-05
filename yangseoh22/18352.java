import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int vertex;  //노드 번호
        int weight;  //가중치

        Node(int v, int w){
            this.vertex = v;
            this.weight = w;
        }

        //가중치 기준으로 정렬
        public int compareTo(Node other){ return this.weight - other.weight; }
    }

    //출발~다른 모든 노드 사이의 최단 거리 계산
    public static int[] dijkstra(int V, List<List<Node>> graph, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();  //최단거리 정보 저장
        int[] dist = new int[V + 1];  //각 노드까지의 최단거리 저장 (노드번호가 1부터여서 V+1크기)
        Arrays.fill(dist, Integer.MAX_VALUE);  //정수의 최대값으로 초기화
        dist[start] = 0;  //출발 노드의 거리는 0
        pq.add(new Node(start, 0));  //

        //큐가 비어있지 않으면 반복
        while(!pq.isEmpty()){
            Node cur = pq.poll();  //최단 거리가 가장 짧은 노드 꺼내기
            int curNode = cur.vertex;  //해당 노드의 번호

            //현재 노드와 인접한 모든 노드 탐색
            for(Node neighbor : graph.get(curNode)){
                //현재~인접 노드로 가는 거리 계산
                int newDist = dist[curNode] + neighbor.weight;

                //새 경로가 기존 경로보다 짧으면 최단거리 갱신
                if (newDist < dist[neighbor.vertex]){
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());  //도시 개수
        int M = Integer.parseInt(st.nextToken());  //도로 개수
        int K = Integer.parseInt(st.nextToken());  //거리 정보
        int X = Integer.parseInt(st.nextToken());  //출발 도시 번호

        //그래프 초기화
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //간선 입력
        for(int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());  //시작 노드
            int y = Integer.parseInt(st.nextToken());  //끝 노드
            graph.get(x).add(new Node(y, 1));  //가중치는 모두 1
        }

        //다익스트라 실행
        int[] distances = dijkstra(N, graph, X);

        List<Integer> result = new ArrayList<>();
        //거리 K인 도시를 결과에 추가
        for (int i = 1; i <= N; i++) {
            if (distances[i] == K) {
                result.add(i);
            }
        }

        // 결과 출력
        if (result.isEmpty()) {  //만족하는 경우가 없으면 -1 출력
            sb.append(-1);
        } else {
            Collections.sort(result);  //오름차순 정렬
            for (int city : result) {  //정렬 순으로 출력
                sb.append(city).append("\n");
            }
        }

        System.out.println(sb);
    }
}