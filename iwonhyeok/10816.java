import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader와 출력하기 위한 BufferedWriter 초기화
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력 및 카드 배열 초기화
        int N = Integer.parseInt(reader.readLine());
        int[] cardArray = new int[N];
        StringTokenizer cardTokens = new StringTokenizer(reader.readLine(), " ");

        // 카드 배열에 입력된 값 저장
        for (int i = 0; i < N; i++) {
            cardArray[i] = Integer.parseInt(cardTokens.nextToken());
        }

        // M 입력 및 타겟 숫자 배열 초기화
        int M = Integer.parseInt(reader.readLine());
        int[] queryArray = new int[M];
        StringTokenizer queryTokens = new StringTokenizer(reader.readLine(), " ");

        // 타겟(구해야 할) 숫자 배열에 입력된 값 저장
        for (int i = 0; i < M; i++) {
            queryArray[i] = Integer.parseInt(queryTokens.nextToken());
        }

        // 카드 배열 정렬
        Arrays.sort(cardArray);

        // 각 타겟 숫자에 대한 결과 계산 및 출력
        for (int target : queryArray) {
            writer.write(countOccurrences(cardArray, target) + " ");
        }

        writer.flush();
        reader.close();
        writer.close();
    }

    // 이진 탐색을 통해 특정 숫자의 개수를 세는 함수
    public static int countOccurrences(int[] sortedArray, int target) {
        return findUpperBound(sortedArray, target) - findLowerBound(sortedArray, target);
    }

    // lowerBound: target 이상의 첫 번째 위치 찾기
    public static int findLowerBound(int[] sortedArray, int target) {
        int low = 0;
        int high = sortedArray.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] >= target) {
                high = mid;  // target 이상의 값을 찾으면 high를 mid로 갱신
            } else {
                low = mid + 1;  // target보다 작은 값을 찾으면 low를 mid+1로 갱신
            }
        }
        return low;
    }

    // upperBound: target 초과의 첫 번째 위치 찾기
    public static int findUpperBound(int[] sortedArray, int target) {
        int low = 0;
        int high = sortedArray.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] > target) {
                high = mid;  // target 초과의 값을 찾으면 high를 mid로 갱신
            } else {
                low = mid + 1;  // target 이하의 값을 찾으면 low를 mid+1로 갱신
            }
        }
        return low;
    }
}
