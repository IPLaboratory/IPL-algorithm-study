import java.io.*;
import java.util.*;

public class first{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.split(" ")[0].equals(o2.split(" ")[0])) return 0;
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
        br.close();
    }
}
