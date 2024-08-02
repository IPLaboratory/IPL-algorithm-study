import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String[] record = br.readLine().split(" ");
            HashMap<String, String> sounds = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            String animal = "";
            while (!(animal = br.readLine()).split(" ")[0].equals("what")) {
                sounds.put(animal.split(" ")[0], animal.split(" ")[2]);
            }

            for (String sound : record) {
                if (!sounds.containsValue(sound)) sb.append(sound).append(" ");
            }

            System.out.print(sb);
        }
    }
}
