import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> leftStr = new Stack<>();
    static Stack<Character> rightStr = new Stack<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            leftStr.push(str.charAt(i));
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String op = br.readLine();
            char command = op.charAt(0);

            switch (command) {
                case 'L':
                    if (!leftStr.isEmpty()) {
                        rightStr.push(leftStr.pop());
                    }
                    break;
                case 'D':
                    if (!rightStr.isEmpty()) {
                        leftStr.push(rightStr.pop());
                    }
                    break;
                case 'B':
                    if (!leftStr.isEmpty()) {
                        leftStr.pop();
                    }
                    break;
                case 'P':
                    char c = op.charAt(2);
                    leftStr.push(c);
                    break;
            }
        }

        while (!leftStr.isEmpty()) {
            rightStr.push(leftStr.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rightStr.isEmpty()) {
            sb.append(rightStr.pop());
        }

        System.out.println(sb.toString());
    }
}
