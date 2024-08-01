import java.io.*;
import java.util.*;

public class j_9536_y {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력 정의
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //출력 정의

        int T = Integer.parseInt(br.readLine()); // 변수 T 정의

        for (int k = 0; k < T; k++) { //반복문
            String s = br.readLine();
            String[] arr = s.split(" "); //입력받는 값은 split으로 쪼깨서 배열에 저장

            HashSet<String> set = new HashSet<>(); //HashSet 정의
            while (true){ //무한루프
                String str = br.readLine();
                if(str.equals("what does the fox say?")){//what does the fox say?가 입력되면
                    break; //반복문 중지
                } else { //그렇지 않으면
                    String[] strArr = str.split(" ");//입력받는 값은 split으로 쪼깨서 배열에 저장
                    set.add(strArr[2]); //set에 값 추가
                }
            }

            List<String> result = new ArrayList<>(); // ArrayList 정의
            for(String word : arr) { //반복문
                if(!set.contains(word)) { //조건문으로 비교하여
                    result.add(word); //result에 값 저장
                }
            }

            bw.write(String.join(" ", result) + "\n"); //bw에 값 저장
        }
        bw.flush(); //출력
        bw.close();
        br.close();
    }
}
