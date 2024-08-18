import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String catSpeak = br.readLine();
        int[] alphabetFrequency = new int[26];

        int index = 0;
        int length = 1;
        for (int i=0; i<catSpeak.length(); i++) {
            while (index < catSpeak.length()) {
                alphabetFrequency[catSpeak.charAt(index++) - 'a']++;

                if (getAlphabetCount(alphabetFrequency) > N) {
                    alphabetFrequency[catSpeak.charAt(--index) - 'a']--;
                    break;
                }
            }

            length = Math.max(length, index - i);
            alphabetFrequency[catSpeak.charAt(i) - 'a']--;
        }
        System.out.print(length);
    }

    static int getAlphabetCount(int[] alphabetFrequency) {
        int count = 0;

        for (int i=0; i<alphabetFrequency.length; i++) {
            if (alphabetFrequency[i] > 0) count++;
        }
        return count;
    }
}
