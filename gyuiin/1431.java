import java.io.*;
import java.util.*;

public class Main {
    public static int sumNum(String s) { // 숫자들의 합 계산하는 메소드
        int sum = 0;
        for (char c : s.toCharArray()) { // 문자열의 각 문자를 하나씩 반복
            if (Character.isDigit(c)) { // 현재 문자가 숫자인지 판별
                sum += c - '0'; // 문자를 정수로 변환해 sum에 더하기
            }
        }
        return sum; // sum 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 표준 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 표준 출력

        int N = Integer.parseInt(br.readLine()); // 사용자로부터 문자열 개수 입력 받기
        String[] sNum = new String[N]; // N개의 문자열을 저장할 배열 생성

        for (int i = 0; i < N; i++) { // N개의 문자열을 sNum배열에 저장
            sNum[i] = br.readLine();
        }

        Arrays.sort(sNum, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {

                if (a.length() != b.length()) { // 1. 문자열 길이 비교
                    return a.length() - b.length(); // 길이가 다르다면 길이 순으로 정렬
                }

                int sumA = sumNum(a); // 2. 문자열 내 숫자들 합 비교
                int sumB = sumNum(b);
                if (sumA != sumB) { // 합이 다르다면 크기 순으로 정렬
                    return sumA - sumB;
                }

                return a.compareTo(b); // 3. 사전 순서대로 문자열 비교
            }
        });

        for (String serial : sNum) { // 저장된 배열 출력
            bw.write(serial);
            bw.newLine();
        }
        bw.flush(); // bw 비우기
        bw.close(); // bw 닫기
        br.close(); // br 닫기
    }
}

