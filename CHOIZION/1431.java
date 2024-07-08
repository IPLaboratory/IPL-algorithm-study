import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n];

        for (int i = 0; i < n; i++) {
            list[i] = br.readLine();
        }

        br.close();

        Arrays.sort(list, (o1, o2) -> {
            // 백준 1번 조건 (길이 짧은 것이 먼저)
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }

            // 백준 2번 조건 (숫자 합이 작은 것이 먼저)
            int sum1 = 0, sum2 = 0;
            for (char ch : o1.toCharArray()) {
                if (Character.isDigit(ch)) {
                    sum1 += ch - '0';
                }
            }
            for (char ch : o2.toCharArray()) {
                if (Character.isDigit(ch)) {
                    sum2 += ch - '0';
                }
            }

            if (sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }

            // 백준 3번 조건 (사전순으로 하기)
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append("\n");
        }

        System.out.print(sb.toString());
    }
}