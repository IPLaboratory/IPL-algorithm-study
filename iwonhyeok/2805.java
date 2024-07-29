import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader와 출력하기 위한 BufferedWriter 초기화
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄에서 나무의 수와 필요한 나무의 길이 입력 받기
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 나무 높이 배열 초기화 및 입력 받기
        int[] treeHeights = new int[N];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            treeHeights[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 위한 변수 초기화
        int low = 0;
        int high = Arrays.stream(treeHeights).max().getAsInt();
        int optimalHeight = 0;

        // 이진 탐색 수행
        while (low <= high) {
            int mid = (low + high) / 2;
            long woodObtained = calculateWood(treeHeights, mid);

            if (woodObtained >= M) {
                optimalHeight = mid;  // 충분한 나무를 얻었다면 더 높은 위치에서 자르기 시도
                low = mid + 1;
            } else {
                high = mid - 1;  // 충분한 나무를 얻지 못했다면 더 낮은 위치에서 자르기 시도
            }
        }

        // 출력
        writer.write(String.valueOf(optimalHeight));
        writer.flush();
        reader.close();
        writer.close();
    }

    // 주어진 높이에서 나무를 잘랐을 때 얻을 수 있는 나무의 길이를 계산하는 함수
    public static long calculateWood(int[] treeHeights, int cutHeight) {
        long totalWood = 0;
        for (int height : treeHeights) {
            if (height > cutHeight) {
                totalWood += (height - cutHeight);  // cutHeight보다 높은 부분만 잘라서 합산
            }
        }
        return totalWood;
    }
}
