import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class j_1740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //변수 생성 및 입력 받기
        long N = Long.parseLong(br.readLine()); //문자열을 long으로 변환
        long num = 1;
        long ans = 0;

        while(N > 0){
            // &연산이 1인 경우 3의 거듭제곱을 합해준다.
            if((N&1) == 1){
                ans += num;
            }
            num *= 3; //거듭제곱 하기
            N = N>>1; //오른쪽 시프트 연산으로 이진수를 하나씩 줄여나가기
        }
        System.out.println(ans);
    }
}
