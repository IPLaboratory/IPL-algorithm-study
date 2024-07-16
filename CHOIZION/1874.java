import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        int idx = 0;
        while(N --> 0) {
            int value = Integer.parseInt(br.readLine());
            if(value > idx) {
                // 1부터 value까지 push
                for (int i = idx+1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                idx = value; // 중간 저장

            // top에 있는 원소가 입력받은 값과 같이 않을 때
            }else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
