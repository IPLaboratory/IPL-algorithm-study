import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j_1735_yes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[2][2];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][1] = st.nextToken(); //분모
            arr[i][0] = st.nextToken(); //분자
        }

        int num1 = Integer.parseInt((arr[0][0]))*Integer.parseInt((arr[1][1]));
        int num2 = Integer.parseInt((arr[1][0]))*Integer.parseInt((arr[0][1]));
        int num3 = num1+num2;

        //최소공배수 이용하여 분자 구하기
        //최소공배수를 이용한 분자 구하기의 오류점 :
        // 음수값이 있어도 두 값 사이의 최소공배수를 구하기때문에 값이 정확하게 나오지 않음
        /*int numerator1 = findlcm(Integer.parseInt((arr[0][0])),Integer.parseInt((arr[1][1])));
        int numerator2 = findlcm(Integer.parseInt((arr[1][0])),Integer.parseInt((arr[0][1])));
        int numerator3 = numerator1+numerator2;*/

        int denom1 = Integer.parseInt((arr[0][0]))*Integer.parseInt((arr[1][0]));

        int gcd = 0; //최대공약수를 담을 변수

        for (int i = 1; i <= num3 && i <= denom1; i++) {
            if((num3 % i == 0) && (denom1 % i == 0)) {
                gcd = i;
            }
        }

        num3 = num3/gcd;
        denom1 = denom1/gcd;

        String s = num3 + " " + denom1;
        System.out.println(s);

    }
}
    //최소공배수 이용하여 분자 구하기
    //최소공배수를 이용한 분자 구하기의 오류점 :
    // 음수값이 있어도 두 값 사이의 최소공배수를 구하기때문에 값이 정확하게 나오지 않음
    /*private static int findlcm(int a, int b) {
        int lcm = 0;
        int max;

        if(a > b) max = a;
        else max = b;

        int tmp = max;
        while (true){
            //두 수가 모두 나우어 떨어지는 경우
            if(max%a == 0 && max%b == 0){
                lcm = max;
                break;
            }
            max += tmp;
        }
        return lcm;
    }
}*/
