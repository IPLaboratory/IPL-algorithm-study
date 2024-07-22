import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  //학생 수
        int[] expect = new int[n];  //학생들이 예상하는 등수
        for(int i=0;i<n;i++){
            expect[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expect);  //예상 등수를 오름차순 정렬

        long cnt = 0;  //불만도 합
        //오름차순 된 상태에서 본인의 인덱스+1과 본인의 예상 등수의 차이를 계산
        for(int i=0;i<n;i++){
            cnt += Math.abs(expect[i]-(i+1));
        }

        System.out.println(cnt);
    }
}