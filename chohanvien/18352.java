import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class j_18352 {
    static int N; // 도시의 개수 N
    static int[] arr; // 각 도시까지의 최단 거리를 저장할 배열 arr
    static ArrayList<ArrayList<Integer>> graph; // 그래프를 인접 리스트로 표현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Scanner sc = new Scanner(System.in);

        //도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X 입력받기
        N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        arr = new int[N+1]; // 도시 번호가 1부터 시작, N+1 크기로 생성
        graph = new ArrayList<>();

        // 반복문으로 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        // 모든 도시에 대해 최단 거리를 무한대로 정의
        Arrays.fill(arr, (int)1e9);
        // 도로 정보 입력받기
        for(int i = 0; i < M; i++) {
            graph.get(sc.nextInt()).add(sc.nextInt());
        }
        arr[X] = 0;// 출발 도시의 최단 거리는 0으로 설정

        dijkstra(X);
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == K) { // 조건문으로 최단 거리가 K인 도시를 찾기
                System.out.println(i);
                cnt++;
            }
        }
        if(cnt == 0){ // K만큼 떨어진 도시가 없는 경우
            System.out.println(-1);
        }
    }

    // 다익스트라 알고리즘
    static void dijkstra(int start) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.offer(start); // 출발 도시를 우선순위 큐에 추가
        while(!que.isEmpty()) {
            int now = que.poll();// 현재 도시를 꺼내기

            // 반복문 통해 현재 도시에서 연결된 모든 도시를 확인
            for(int j = 0; j < graph.get(now).size(); j++) {
                int cost = arr[now]+1; // 거리는 1만큼 증가
                // 조건문으로 현재 경로가 더 짧다면 최단 거리 갱신
                if(cost < arr[graph.get(now).get(j)]) {
                    arr[graph.get(now).get(j)] = cost;
                    // 갱신된 도시는 큐에 추가
                    que.offer(graph.get(now).get(j));
                }
            }
        }
    }
}
