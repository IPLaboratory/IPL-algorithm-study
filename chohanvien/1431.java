import java.io.*;
import java.util.*;

public class three {
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
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    if (sum(o1) > sum(o2)) {
                        return 1;
                    } else if (sum(o1) < sum(o2)) {
                        return -1;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
                return 0;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int sum(String str) {
        int get = 0;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                get += str.charAt(i);
            }
        }
        return get;
    }
}

