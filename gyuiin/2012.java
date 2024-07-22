import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 설정
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 학생 수 입력받기
        int[] expect = new int[n]; // 학생 수(n)만큼의 예상 등수 베열 생성

        for (int i = 0; i < n; i++) { // 학생 수 만큼 예상등수 입력받기
            expect[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expect); // 예상등수를 오름차순으로 정렬 (불만도의 합을 최소화하기 위해)

        int discont = 0; // 불만도를 저장할 변수 discont 선언

        for (int i = 0; i < n; i++) { // 예상등수와 실제등수 비교
            int rank = i + 1; // 실제 등수 (배열 인덱스에 맞춰서)
            discont += Math.abs(expect[i] - rank); // 예상등수와 실제등수 차이의 절대값을 discont에 누적
        }
        bw.write(discont + "\n"); // 계산된 총 불만도 출력

        bw.flush(); // 버퍼 정리
        bw.close();
        br.close();
    }
}
