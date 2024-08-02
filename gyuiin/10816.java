import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 카드의 개수 N 입력받기
        int[] cards = new int[N]; // N 크기의 배열 cards

        String[] card = br.readLine().split(" "); // 공백으로 분리
        for (int i = 0; i < N; i++) { // 숫자를 N번만큼 입력 받아 cards에 저장
            cards[i] = Integer.parseInt(card[i]);
        }

        int M = Integer.parseInt(br.readLine()); // M개의 정수 (몇 개 가지고 있는 숫자 카드인지)
        int[] num = new int[M];

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < M; i++) { // M번만큼 입력 받아 num에 저장
            num[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(cards); // 이분탐색을 위해 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) { // lower과 upper의 차이 계산
            int n = num[i];
            int count = upper(cards, n) - lower(cards, n); // n이 몇 개 있는지
            sb.append(count).append(" "); // sb에 저장
        }

        bw.write(sb.toString().trim()); // 결과 출력하고 버퍼 정리
        bw.newLine();
        br.close();
        bw.close();
    }

    private static int lower(int[] array, int value) { // value보다 크거나 같은 값이 처음 나타내는 위치 찾는 메소드
        int low = 0; // 처음
        int high = array.length; // 끝

        while (low < high) {
            int mid = (low + high) / 2; // 중간값
            if (array[mid] >= value) { // array[mid]가 value보다 크거나 같으면 high를 mid로 갱신
                high = mid;
            } else { // 작으면
                low = mid + 1; // low를 mid+1로 갱신
            }
        }
        return low; // value가 처음 나타나는 인덱스
    }

    private static int upper(int[] array, int value) { // value보다 큰 값이 처음 나타내는 위치 찾는 메소드
        int low = 0;
        int high = array.length;

        while (low < high) {
            int mid = (low + high) / 2; // 중간값
            if (array[mid] > value) { // array[mid]가 value보다 크면 high를 mid로 갱신
                high = mid;
            } else { // 작거나 같으면
                low = mid + 1;
            }
        }
        return low;
    }
}
