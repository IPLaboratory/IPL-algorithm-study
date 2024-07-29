import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 선언
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수 N 입력 받기
        int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이 M 입력 받기
        int[] trees = new int[N];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) { // 각 나무의 높이를 N번 입력 받기
            trees[i] = Integer.parseInt(st.nextToken());
        }

        long start = 0; // 절단기 높이의 최솟값 (0)
        long end = Arrays.stream(trees).max().getAsInt(); // 절단기 높이의 최댓값 (가장 높은 나무의 길이)
        long result = 0; // 최종 절단기 높이

        while (start <= end) { // 절단기 높이의 최솟값이 최댓값보다 작거나 같을동안
            long total = 0;
            long mid = (start + end) / 2; // 중간값 (현재 설정된 절단기 높이)

            for (int x : trees) { // 모든 나무에 대해 반복
                if (x > mid) { // 높이가 mid보다 크면
                    total += x - mid; // 잘린 부분의 길이(x - mid)를 total에 누적
                }
            }

            if (total < M) {  // total이 M보다 작다면
                end = mid - 1; // 절단기 높이 줄이기
            } else {
                result = mid; // result를 mid로 갱신
                start = mid + 1; // 절단기 높이 늘리기
            }
        }

        writer.write(String.valueOf(result)); // 결과 출력 후 버퍼 정리
        writer.newLine();
        reader.close();
        writer.close();
    }
}
