import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] serials = new String[n];

        for (int i=0; i<n; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, (o1, o2) -> {
            if (o1.length() != o2.length())
                return o1.length() - o2.length();
            else if (digitSum(o1) != digitSum(o2)) {
                return digitSum(o1) - digitSum(o2);
            } else {
                return o1.compareTo(o2);
            }
        });

        for (int i=0; i<n; i++) {
            sb.append(serials[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static int digitSum(String n) {
        int sum = 0;
        for (int i=0; i<n.length(); i++) {
            if (Character.isDigit(n.charAt(i))) {
                sum += Integer.parseInt(String.valueOf(n.charAt(i)));
            }
        }
        return sum;
    }
}