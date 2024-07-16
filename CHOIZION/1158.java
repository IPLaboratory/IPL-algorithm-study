import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append("<");

        int idx = K;

        while (list.size() != 1) {
            sb.append(list.get(idx));
            sb.append(", ");

            list.remove(idx);

            idx += K;

            if (idx >= list.size()) {
                idx %= list.size();
            }
        }

        sb.append(list.get(0));
        sb.append(">");

        System.out.println(sb);
    }
}