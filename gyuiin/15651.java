import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // N : 1~N까지 자연수, M : 수열의 길이
    static int[] seq; // 현재 수열을 저장
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 버퍼 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼 선언
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N, M을 차례로 입력 받기
        M = Integer.parseInt(st.nextToken());

        seq = new int[M]; // 길이가 M인 배열 seq 생성

        backTracking(0); // 백트래킹 메소드 호출

        bw.flush(); // 출력 버퍼 정리
        bw.close();
    }
    static void backTracking(int loca) throws IOException {
        if (loca == M) { // loca(현재 위치)가 M(수열의 길이)와 같아지면
            for (int i = 0; i < M; i++) { // seq배열을 출력
                bw.write(seq[i] + " ");
            }
            bw.newLine();
            return; // 재귀호출 종료
        }
        // 그렇지 않으면
        for (int i = 1; i <= N; i++) { // 1부터 N까지 반복
            seq[loca] = i; // 숫자 i를 현재위치(loca)에 삽입
            backTracking(loca + 1); // 다음 위치(loca + 1)로 재귀 호출
        }
    }
}
