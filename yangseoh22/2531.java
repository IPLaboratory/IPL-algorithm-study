import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  //접시 수
        int d = Integer.parseInt(st.nextToken());  //초밥 최대 가짓 수
        int k = Integer.parseInt(st.nextToken());  //연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken());  //쿠폰 번호

        //현재 초밥 벨트 위의 초밥 종류
        int[] sushi = new int[N];
        for(int i=0; i<N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] eat = new int[d+1];  //먹은 초밥의 종류별 개수

        //처음 초밥부터 k개 연속 먹기
        int cnt = 0;  //현재 먹을 수 있는 가짓수
        for(int i=0; i<k; i++) {
            int now = sushi[i];
            //먹지 않은 것이면 cnt 증가
            if(eat[now]==0) cnt++;
            eat[now]++;
        }
        int max = cnt; //최대 가짓수 갱신
        //쿠폰 접시를 먹지 않았다면 증가
        if(eat[c] == 0) max++;

        //그 다음 초밥부터 k개 연속 먹을 때
        for(int i=1; i<N; i++){

            int startIdx = sushi[i-1];  //이전 주기의 시작 스시
            int endIdx = sushi[(i+k-1)%N];  //이번 주기의 마지막 스시

            //전 주기에서 먹은 스시가 이번엔 없다면 감소
            eat[startIdx]--;
            if(eat[startIdx] == 0) cnt--;

            //이번에 새로 주기에 들어온 스시가 처음이라면 증가
            if(eat[endIdx] == 0) cnt++;
            eat[endIdx]++;

            //쿠폰 접시를 먹지 않았다면 증가
            int curCnt = cnt;
            if(eat[c] == 0) curCnt++;

            if(curCnt>max) max=curCnt; //현재 주기의 가짓수가 최대값이면 갱신
        }

        System.out.println(max);
    }
}