import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        List<List<Integer>> graph = new ArrayList<>(); // 각 도시의 인접 도시를 저장할 리스트
        for (int i = 0; i <= N; i++) { // 모든 도시를 초기화
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // M만큼 반복하여 도로의 정보를 읽어오는 반복문
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 도시 A와 B 입력 받기
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B); // 도시A의 리스트에 도시B 추가 (도시A -> 도시B)
        }

        int[] dis = new int[N + 1]; // 각 도시까지의 최단거리 저장할 dis
        Arrays.fill(dis, -1); // -1로 초기값 설정 (해당 도시 방문 X)
        dis[X] = 0; // 출발도시 X의 거리를 0으로 초기화

        Queue<Integer> queue = new LinkedList<>(); // 출발도시를 저장할 큐
        queue.add(X); // 출발도시 X를 큐에 저장

        while (!queue.isEmpty()) { // 큐가 비어있을 때까지 반복
            int current = queue.poll();
            for (int neighbor : graph.get(current)) { // 현재 도시에서 갈 수 있는 모든 이웃도시 확인
                if (dis[neighbor] == -1) { // 아직 방문하지 않았다면
                    dis[neighbor] = dis[current] + 1; // 거리 업데이트
                    queue.add(neighbor); // 이웃 도시를 큐에 추가 (다음 단계 탐색을 위해)
                }
            }
        }

        List<Integer> result = new ArrayList<>(); // 거리를 저장할 result리스트
        for (int i = 1; i <= N; i++) { // N번 반복하여
            if (dis[i] == K) { result.add(i); } // 거리가 K인 도시를 result리스트에 추가
        }

        if (result.isEmpty()) { // result리스트가 비어있으면
            bw.write("-1"); // -1출력
        } else { // 비어있지 않으면
            Collections.sort(result); // result를 오름차순으로 정렬
            for (int city : result) { // 도시를 순회하면서 도시번호를 출력
                bw.write(city + "\n");
            }
        }
        bw.flush(); // 버퍼 정리
        br.close();
        bw.close();
    }
}
