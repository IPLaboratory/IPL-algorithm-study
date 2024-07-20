import java.io.*;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class j_15651 {
    static int[] output;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken()); //4
        int M = Integer.parseInt(st.nextToken()); //2
        arr = new int[N];
        output = new int[M];

        repeatCombination(0,N,M);
        bw.flush();
        bw.close();
    }

    private static void repeatCombination(int depth, int n, int m) throws IOException {

        if(depth == m) {
            for(int i = 0; i < output.length; i++) {
                if(i+1 == output.length) {
                    bw.append(output[i]+"");
                }else{
                    bw.append(output[i]+" ");
                }
            }
            bw.append("\n");
            return;
        }
        for(int i = 0; i < n; i++) {
            output[depth] = i+1;
            repeatCombination(depth+1, n, m);
        }
    }
}
