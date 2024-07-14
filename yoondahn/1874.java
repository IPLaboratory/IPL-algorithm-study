import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int current = 1;    // 스택에 넣을 숫자

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // 현재 숫자보다 작은 숫자들을 스택에 추가 (push)
            if (current <= num) {
                while (current <= num) {
                    stack.push(current++);
                    sb.append("+").append("\n");
                }
            }
            // 스택의 top이 현재 숫자와 다르면 종료
            if (stack.peek() != num) {
                System.out.print("NO");
                return; // 프로그램 종료
            }
            // 현재 숫자와 입력받은 숫자가 일치하면 스택에서 삭제 (pop)
            stack.pop();
            sb.append("-").append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}