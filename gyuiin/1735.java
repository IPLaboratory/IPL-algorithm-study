import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int a, int b) { // 유클리드 호제법을 사용한 최대공약수 구하는 메소드
        if (a <= b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (b == 0) { return a; }
        return gcd(b , a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 정의
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 첫 번째 줄의 입력 읽기
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 두 번째 줄의 입력 읽기
        int D = Integer.parseInt(st.nextToken());

        int num = A * D + B * C; // 분자 계산
        int den = B * D; // 분모 계산

        int gcd = gcd(num, den);
        num /= gcd;
        den /= gcd;

        bw.write(num + " " + den + "\n"); // 결과 출력
        bw.flush();
        bw.close();
        br.close(); // 사용한 버퍼들을 정리
    }
}
