import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1740 - 거듭제곱
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());     // 입력된 수 (1~500,000,000,000)

        long result = 0L;   // 최종 계산된 거듭제곱수들의 합을 저장
        long power = 1L;   // 현재 계산 중인 거듭제곱수를 저장 (3^0 = 1)

        while (n > 0) {
            if ((n & 1) == 1) result += power; // 현재 비트가 1인지 확인
            n >>= 1;    // 오른쪽 비트로 1비트 이동
            power *= 3;    // 3의 거듭제곱으로 처리
        }
        System.out.println(result);
    }
}
