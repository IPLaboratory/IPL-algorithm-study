import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int point = 1;  //1~n의 수
        int n = Integer.parseInt(br.readLine());  //수열 길이

        //목표 수열 생성
        int[] goal = new int[n];
        for(int i = 0; i < n; i++) {
            goal[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            if(goal[i]>=point){  //목표 수열의 현재 위치 값과 같을 때까지 push
                while(goal[i] >= point){
                    stack.push(point++);
                    sb.append("+").append("\n");
                }
            }

            if(goal[i] < point){
                if(stack.peek()!=goal[i]){  //목표 수열 생성 불가
                    System.out.println("NO");
                    return;
                }
            }

            stack.pop();
            sb.append("-").append("\n");

        }

        System.out.println(sb);
        br.close();
    }
}