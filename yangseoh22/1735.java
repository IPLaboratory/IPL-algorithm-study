import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int den1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(st.nextToken());
        int den2 = Integer.parseInt(st.nextToken());

        //분모끼리의 최소공배수 구하기 (분수 합의 분모)
        int den_lcm = (den1 * den2) /  findGCD(den1, den2);

        //분모가 최소공배수가 되기 위해 곱해주는 값 만큼 분자에 곱해주고 더하기
        // (분수 합의 분자)
        int new_num = num1 * (den_lcm/den1) + num2 * (den_lcm/den2);

        //기약분수 구하기 -> 분모, 분자의 최대공약수를 구해 나눠줌
        int gcd = findGCD(new_num, den_lcm);
        new_num = new_num / gcd;
        den_lcm = den_lcm / gcd;

        System.out.println(new_num + " " + den_lcm);
    }

    //반복문으로 유클리드 호제법 구현
    public static int findGCD(int a, int b) {
        while(b!=0) { // b가 0인 수식의 나머지가 0이므로 종료
            int tmp = a;
            a = b; // b를 a로 대체
            b = tmp%b; // a의 나머지 값을 임담
        }
        return a; // 마지막 수식의 a(최대공약수) 가 저장되어있음
    }
}