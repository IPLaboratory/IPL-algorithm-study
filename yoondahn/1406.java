import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 변수 선언
        String existing = br.readLine();
        int n = existing.length();
        LinkedList<String> list = new LinkedList<>();
        ListIterator<String> iter = list.listIterator();

        // 초기 문자열을 ListIterator에 삽입
        for (int i = 0; i < n; i++) {
            iter.add(String.valueOf(existing.charAt(i)));
        }

        // 편집기 명령어
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            switch (num) {
                case "L":   // 커서를 왼쪽으로 한 칸 옮김
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case "D":   // 커서를 오른쪽으로 한 칸 옮김
                    if (iter.hasNext()) iter.next();
                    break;
                case "B":   // 커서 왼쪽에 있는 문제를 삭제
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P":   // 입력받은 문자를 커서 왼쪽에 추가
                    String num1 = st.nextToken();
                    iter.add(num1);
                    break;
                default:
                    break;
            }
        }
        br.close();

        // listIterator를 시작 시점으로 초기화 후 요소 출력
        iter = list.listIterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
        }
        System.out.print(sb);
    }
}