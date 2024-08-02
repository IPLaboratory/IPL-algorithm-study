import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine()); // N 입력 받기
        long result = 0; // 결과를 저장할 변수
        int cnt = 0; // 비트 위치를 저장할 변수

        while (N > 0) { // N을 2진법으로 변환하고 각 비트가 1인 위치에 대해 거듭제곱 계산
            if ((N & 1) == 1) { // 최하위 비트가 1이면
                result += power(3, cnt); // result에 3의 cnt 거듭제곱 값을 더하기
            }
            cnt++; // 다음 비트
            N = (N >> 1); // 다음 비트를 검사하기 위해 N을 오른쪽으로 1비트 시프트
        }
        bw.write(String.valueOf(result)); // 결과 출력
        bw.newLine();
        bw.flush(); // 버퍼 정리
        br.close();
        bw.close();
    }

    private static long power(long a, long b) { // a와 b의 거듭제곱을 계산하는 메소드
        if (b == 0) return 1; // b가 0이면 1 반환
        if (b == 1) return a; // b가 1이면 a 반환

        long tmp = power(a, b / 2); // b를 반으로 줄여서 재귀호출

        if (b % 2 == 0) { // b가 짝수이면
            return (tmp * tmp); // tmp * tmp 반환
        } else { // b가 홀수이면
            return ((tmp * tmp) * a); // tmp * tmp * a 반환
        }
    }
}

