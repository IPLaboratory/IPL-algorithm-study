import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수 T 입력 받기

        for (int i = 0; i < T; i++) { // 개수만큼 반복
            String[] recorded = br.readLine().split(" "); // 녹음된 소리를 공백 단위로
            Set<String> animals = new HashSet<>(); // 여우가 아닌 다른 동물들의 소리

            while (true) { // 계속 입력 받기
                String line = br.readLine();
                if (line.equals("what does the fox say?")) { break; } // "what does the fox say?"이면 break
                String[] parts = line.split(" "); // 입력을 공백 단위로 분리하여
                animals.add(parts[2]); // 3번째(동물의 소리)를 해시셋에 저장
            }
            StringBuilder sb = new StringBuilder();
            for (String sound : recorded) { // 녹음된 소리 배열 순회
                if (!animals.contains(sound)) { // 다른동물들의 소리가 없는 경우에
                    if (sb.length() > 0) { sb.append(" "); } // 여우의 소리를 공백으로 나누어 sb에 추가
                    sb.append(sound);
                }
            }
            bw.write(sb.toString()); // 결과 출력
            bw.newLine();
        }
        br.close(); // 버퍼 정리
        bw.flush();
        bw.close();
    }
}

