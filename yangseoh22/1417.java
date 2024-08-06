import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());  //후보 수

        int[] num = new int[N];  //후보별 받을 표 수
        int one = Integer.parseInt(br.readLine());  //1번 투표 수
        for(int i = 0; i < N-1; i++) {  //나머지 투표 수
            num[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;  //현재 최댓값 인덱스
        int cnt = 0;  //매수해야하는 사람 수
        while(true){
            int max = 0;
            for(int i = 0; i < num.length; i++) {
                if(max < num[i]){
                    max = num[i];  //현재 가장 많은 득표수
                    idx = i;  //해당 위치
                }
            }

            if(one > max) break;  //1번 후보가 최다득표일때 종료

            num[idx]--;  //최대 득표 수인 후보의 표 감소
            one++;  //1번 후보 득표 수 증가
            cnt++;  //매수할 사람 증가
        }

        System.out.println(cnt);
    }
}