import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }
        br.close();

        Arrays.sort(s, (a, b) -> {
            if (a.length() == b.length()) {     // 길이가 같으면
                // 모든 자리수의 합을 비교하여 작은 순으로 정렬
                int sum1 = 0, sum2 = 0;
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) >'0' && a.charAt(i) <= '9') {  // 숫자만 합산
                        sum1 += a.charAt(i) - '0';
                    }
                }
                for (int i = 0; i < b.length(); i++) {
                    if (b.charAt(i) >'0' && b.charAt(i) <= '9') {
                        sum2 += b.charAt(i) - '0';
                    }
                }

                if (sum1 == sum2) {     // 자리수의 합이 같으면
                    return a.compareTo(b);  // 사전 순으로 정렬 (숫자 < 알파벳)
                }
                return Integer.compare(sum1, sum2);
            }
            // 길이가 다르면, 길이가 짧은 순으로 정렬
            return Integer.compare(a.length(), b.length());
            // return a.length() - b.length();
        });

        for (String str : s) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
    }
}