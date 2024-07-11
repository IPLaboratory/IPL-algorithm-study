import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 회원의 수

        String[][] member = new String[N][2];

        // 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());    // 공백으로 분리
            for (int j = 0; j < 2; j++) {
                member[i][j] = st.nextToken();
            }
        }
        br.close();

        // 정렬
        Arrays.sort(member, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
//                if (o1[0].equals(o2[0])) {  // 나이가 같으면
//                    return o1[1].compareTo(o2[1]);  // 이름을 비교하여 정렬
//                }
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
//                return o1[0].compareTo(o2[0]);  // 나이를 비교하여 정렬
            }
        });

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                bw.write(member[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}