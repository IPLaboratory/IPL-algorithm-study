import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  //나무의 수
        int m = Integer.parseInt(st.nextToken());  //가져갈 나무의 길이
        int[] tree = new int[n];  //나무의 길이들을 저장

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<n; i++){  //각 나무의 길이 입력 받기
            tree[i] = Integer.parseInt(st.nextToken());
            if(max < tree[i]) max = tree[i];
        }

        int start = 0;  //검사할 부분의 왼쪽 끝
        int end = max;  //검사할 부분의 오른쪽 끝

        int cutter = 0;  //절단기의 높이
        while(start <= end){
            long total = 0;  //가져갈 수 있는 나무의 수
            int mid = (start + end)/2;

            for(int t : tree){
                //나무가 절단기의 높이 보다 길다면 나무를 잘라 총 합계에 합산
                if(t>mid){
                    total += t - mid;
                }
            }

            //가져가려던 길이 보다 적게 나왔다면 기준을 mid 왼쪽으로 이동
            if(total < m){
                end = mid - 1;
            }
            else{  //가져가려던 길이 보다 많이 나왔다면 기준을 mid 오른쪽으로 이동
                cutter = mid;
                start = mid + 1;
            }
        }

        bw.write(Integer.toString(cutter)+"\n");
        bw.flush();
        bw.close();
    }
}