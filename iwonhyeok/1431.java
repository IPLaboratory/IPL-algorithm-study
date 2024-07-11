import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] serials = new String[N];

        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }

            int sum1 = 0;
            int sum2 = 0;
            for (char c : s1.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum1 += c - '0';
                }
            }
            for (char c : s2.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum2 += c - '0';
                }
            }
            if (sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }

            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (String serial : serials) {
            sb.append(serial).append("\n");
        }

        System.out.print(sb.toString());
    }
}
