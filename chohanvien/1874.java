import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class j_1874 {
    public static void main(String[] args) throws IOException {
        //값을 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();
        //입력받을 값의 개수
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int su = arr[i];

            if(su >= num){
                while (su>=num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{
                int n = stack.pop();
                if(n>su){
                    System.out.println("NO");
                    flag = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(flag)
            System.out.println(bf.toString());
    }
}