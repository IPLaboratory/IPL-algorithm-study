import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 입력(데이터의 개수)을 정수로 변환
        String[][] inf = new String[N][2]; // 나이, 이름 정보를 저장할 2차원 배열

        for(int i = 0; i < N; i++) { // N번 반복하여 나이, 이름 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄의 입력을 공백을 기준으로 분리
            inf[i][0] = st.nextToken(); // 첫 번째 요소에 나이 저장
            inf[i][1] = st.nextToken(); // 두 번쨰 요소에 나이 저장
        }

        Arrays.sort(inf, new Comparator<String[]>() { // 나이를 오름차순 정렬
            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]); // 정수로 변환하여 비교
            }
        });

        StringBuilder sb = new StringBuilder(); // 문자열을 효율적으로 조작

        for(int i = 0; i < N; i++) { // 정렬된 배열의 각 요소를 sb에 추가
            sb.append(inf[i][0]).append(' ').append(inf[i][1]).append('\n');
        }   // 나이 + ' ' + 이름 + \n

        System.out.println(sb); // 최종 문자열 출력
    }
}

