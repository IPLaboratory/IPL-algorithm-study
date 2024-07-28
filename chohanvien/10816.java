import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class j_10816 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //출력
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 문자 쪼개기

        int N = Integer.parseInt(st.nextToken());  // 가지고 있는 숫자 카드의 개수 N
        arr = new int[N]; //arr 배열 생성

        //숫자 카드에 적혀있는 정수를 배열에 저장
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //찾고 싶은 총 카드의 갯수 M
        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr2 = new int[M]; //arr2 배열 생성
        //찾고 싶은 카드의 숫자를 arr2 배열에 저장
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); //배열 오름차순
        int start1 = 0;
        int end1 = 0;
        for(int i = 0; i < M; i++){
            start1 = lowerBound(arr2[i]);
            end1 = upperBound(arr2[i]);
            if(i==M-1){
                bw.write(end1-start1+1+"");
            }else{
                bw.write(end1-start1+1+" ");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }

    //Upper Bound(변형): 특정 값 x이하를 만족하는 값들중 위치가 가장 큰 값
    private static int upperBound(int target) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] <= target){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }

    //Lower Bound: 배열에서 x 이상의 값이 처음으로 나타나는 위치 깂
    private static int lowerBound(int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
