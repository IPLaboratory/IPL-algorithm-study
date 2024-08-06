import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());  // 몇 번째 제곱 수를 구할지

        // 결과를 이진수 문자열로 변환하여 출력
        String binary = Long.toBinaryString(n);

        // 삼진법 변환하듯이 변환. 단, 0, 1으로만 이루어졌음을 주의
        long result = 0L;
        long idx = 0L;  //현재 자리의 지수값 -> 3의 idx제곱
        for(int i = binary.length()-1; i >= 0 ; i--) {
            // 맨 뒷 수부터 앞으로 이동하면서 검사
            if(binary.charAt(i)=='1'){  // 1일 경우
                result += pow(3, idx);  // 3의 i승을 더해줌
            }
            idx++;  // 앞자리수로 이동할수록 지수 증가
        }
        sb.append(result);

        // 결과 출력
        System.out.println(sb);
    }

    // x의 n승 계산
    public static long pow(long x, long n) {
        long pow = 1;
        for(long i = 0; i < n; i++){
            pow *= x;  //a를 b번 곱하기
        }

        return pow;
    }
}
