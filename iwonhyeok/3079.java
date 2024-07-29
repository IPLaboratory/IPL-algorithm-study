import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader와 출력하기 위한 BufferedWriter 초기화
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken()); // 심사대의 수
        int M = Integer.parseInt(st.nextToken()); // 사람 수

        // 심사대 배열 초기화 및 입력 받기
        long[] inspectionTimes = new long[N];
        for (int i = 0; i < N; i++) {
            inspectionTimes[i] = Long.parseLong(reader.readLine());
        }

        long low = 1; // 이진탐색의 하한값
        long high = Arrays.stream(inspectionTimes).max().getAsLong() * M; // 이진탐색의 상한값
        long minTime = high; // 최소 시간

        // 이진 탐색 수행
        while (low <= high) {
            long mid = (low + high) / 2;
            long peopleProcessed = calculatePeople(inspectionTimes, mid);

            if (peopleProcessed >= M) {
                minTime = mid;  // 주어진 시간 내에 충분한 사람을 처리할 수 있다면 시간을 줄여봄
                high = mid - 1;
            } else {
                low = mid + 1;  // 충분한 사람을 처리하지 못한다면 시간을 늘려봄
            }
        }

        // 출력 및 리소스 정리
        writer.write(String.valueOf(minTime));
        writer.flush();
        reader.close();
        writer.close();
    }

    // 주어진 시간 내에 처리할 수 있는 사람의 수를 계산하는 함수
    public static long calculatePeople(long[] inspectionTimes, long givenTime) {
        long totalPeople = 0;
        for (long time : inspectionTimes) {
            totalPeople += givenTime / time;  // 각 심사대가 주어진 시간 내에 처리할 수 있는 사람의 수를 합산
        }
        return totalPeople;
    }
}
