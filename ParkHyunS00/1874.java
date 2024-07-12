import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        int num = 1;
        for (int i=0; i<n; i++) {
            int now = Integer.parseInt(br.readLine());
            while(now >= num) {
                stack.push(num++);
                sb.append("+").append("\n");
            }

            if (stack.peek() == now) { // 목표는 수열을 만드는 것
                stack.pop();
                sb.append("-").append("\n");
            } else flag = false;
        }

        String result = (flag) ? sb.toString() : "NO";
        System.out.print(result);
    }
}
