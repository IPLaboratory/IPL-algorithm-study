import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 정의
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // 문자열을 조작하는 StringBuilder 정의

        int N = Integer.parseInt(br.readLine()); // 수열의 길이 N 입력 받기
        int[] stack = new int[N]; // 길이가 N인 배열 생성
        int cur = 0; // 스택의 현재 인덱스
        int add = 0; // 스택에 마지막으로 추가된 값

        while (N-- > 0) { // N개의 수열을 입력 받기
            int A = Integer.parseInt(br.readLine()); // 수열 값 입력
            if (A > add) { // '현재 입력한 값 > 마지막으로 추가된 값'일 경우
                for (int i = add + 1; i <= A; i++) { // add+1 부터 A까지 스택에 push
                    stack[cur] = i;
                    cur++;
                    sb.append('+').append('\n'); // +(push)를 sb에 추가
                }
                add = A; // add값 갱신
            } else if (stack[cur - 1] != A) { // '현재 입력한 값 != 마지막으로 추가된 값'일 경우
                bw.write("NO\n"); // 'NO'출력
                bw.flush(); // 사용한 버퍼들 정리하고 종료
                bw.close();
                br.close();
                return;
            }
            cur--; // pop
            sb.append('-').append('\n'); // -(pop)을 sb에 추가
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close(); // 결과 출력하고 사용한 버퍼들 정리
    }
}
