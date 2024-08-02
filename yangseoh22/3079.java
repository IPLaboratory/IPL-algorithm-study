import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  //심사대 개수
        int m = Integer.parseInt(st.nextToken());  //사람 수
        int[] time = new int[n];  //심사관 별 소요 시간 저장

        int max = 0;
        for(int i = 0; i<n; i++){  //각 소요 시간 입력 받기
            time[i] = Integer.parseInt(br.readLine());
            if(time[i] > max) max = time[i];  //제일 오래 걸리는 심사 시간
        }

        long high = (long)(m * max);  //모든 사람을 심사하는데 걸리는 최대 시간
        long low = 0;
        long result = high;  //최소 심사 시간

        while(low<high){
            long mid = (low + high)/2;
            long cntPeople = 0;  //현재 mid시간 내에 심사 가능한 사람 수

            for(int t : time){
                cntPeople += mid/t;  //현재 mid시간이 걸릴 때, 각 심사대에서 검사 가능한 사람 수를 누적
            }

            if(cntPeople >= m) {
                result = mid;
                high = mid-1;  //시간을 왼쪽으로 이동
            }
            else if(cntPeople < m) low = mid+1;  //시간을 오른쪽으로 이동
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}