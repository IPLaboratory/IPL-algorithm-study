import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 9536 - 여우는 어떻게 울지?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] sounds = new String[st.countTokens()]; // 녹음된 소리들의 배열

            // 녹음된 소리를 배열에 저장
            int index = 0;
            while (st.hasMoreTokens()) {
                sounds[index++] = st.nextToken();
            }

            HashSet<String> otherSounds = new HashSet<>();  // 다른 동물의 소리
            int max = 100;
            while (max-- > 0) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) break;

                // 동물의 소리 정보를 파싱
                st = new StringTokenizer(input);
                st.nextToken(); // 동물 이름 무시
                st.nextToken(); // "goes" 무시
                String crying = st.nextToken(); // 동물 소리 추출
                otherSounds.add(crying);
            }

            // 녹음된 소리에서 다른 동물 소리를 제외
            for (String s : sounds) {
                if (!otherSounds.contains(s)) { // 여우의 소리만 출력
                    sb.append(s).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
