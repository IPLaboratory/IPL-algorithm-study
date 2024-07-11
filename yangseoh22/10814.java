import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 온라인 저지 회원 수

        String[][] info = new String[n][2];  // 회원 별 나이와 이름 저장

        for(int i=0;i<n;i++){  // 회원 별 정보를 입력 받음
            StringTokenizer st = new StringTokenizer(br.readLine());  // 반복할 때마다 초기화 필요
            info[i][0] = st.nextToken();
            info[i][1] = st.nextToken();
        }

        Arrays.sort(info, new Comparator<String[]>() {
            // 나이순으로 정렬
            public int compare(String[] s1, String[] s2) {
                // 숫자형 문자열이므로 숫자로 변환 후 오름차순 정렬
                return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){  // 정렬 결과 출력
            sb.append(info[i][0]+" ").append(info[i][1]).append("\n");
        }

        System.out.println(sb);

    }
}
