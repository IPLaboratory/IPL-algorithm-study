import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 횟수 설정
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];

        // 입력 횟수만큼 수열 입력
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int current = 1;


        // 스택에 push 및 pop에 따른 + - NO 출력
        for (int i = 0; i < N; i++) {
            int target = sequence[i];

            if (target >= current) {
                while (target >= current) {
                    stack.push(current++);
                    result.append("+\n");
                }
                stack.pop();
                result.append("-\n");
            } else {
                if (stack.peek() != target) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                result.append("-\n");
            }
        }

        System.out.println(result);
    }
}
