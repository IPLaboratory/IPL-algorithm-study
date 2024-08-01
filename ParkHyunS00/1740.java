import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = Long.toBinaryString(Long.parseLong(br.readLine()));

        long result = 0L;
        long digit = 1L;
        for (int i=N.length()-1; i>=0; i--) {
            result += Long.parseLong(String.valueOf(N.charAt(i))) * digit;
            digit *= 3;
        }

        System.out.print(result);
    }
}
