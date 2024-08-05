import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());  //테스트 케이스 수

        for(int i = 0; i < t; i++) {
            String record = br.readLine();  //녹음된 소리

            // 녹음된 소리를 단어별로 분리
            StringTokenizer st = new StringTokenizer(record);

            ArrayList<String> crying = new ArrayList<String>();
            while (st.hasMoreTokens()) {
                // 각 울음소리를 저장
                crying.add(st.nextToken());
            }

            // 여우 제외의 동물들의 울음 소리를 입력 받고 제외
            while(true){
                String str = br.readLine();
                if (str.equals("what does the fox say?")) break;  // 종료 문장이면 종료
                st = new StringTokenizer(str);
                st.nextToken(); st.nextToken();  // <동물> goes 다음이 <소리>

                String sound = st.nextToken();  //다른 동물의 울음소리

                // 다른 동물의 울음소리와 같을 경우 리스트에서 제거
                for (int j = 0; j < crying.size(); j++) {
                    if (crying.get(j).equals(sound)) {
                        crying.remove(j);
                        j--;  // 리스트 크기가 줄어들었으므로 인덱스를 조정
                    }
                }
            }

            // 결과 출력
            for (String c : crying) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
