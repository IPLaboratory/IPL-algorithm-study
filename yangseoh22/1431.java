import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());  // 기타 개수
        String[] number = new String[n];  // 시리얼 번호와 그 길이 저장

        for(int i = 0; i < n; i++){
            number[i] = br.readLine();  // 시리얼 번호 입력
        }

        Arrays.sort(number, new Comparator<String>() {
            // 길이순으로 정렬
            public int compare(String s1, String s2) {
                // 숫자형 문자열이므로 숫자로 변환 후 오름차순 정렬
                int com = s1.length() - s2.length();
                if(com!=0){  //길이가 다르면
                    return com;
                }
                else{  //길이가 같으면 포함된 숫자들의 합을 비교
                    int sum1 = number_Sum(s1);
                    int sum2 = number_Sum(s2);
                    if (sum1 != sum2) {  // 숫자 합이 다르면 오름차순 정렬
                        return sum1 - sum2;
                    } else {
                        return s1.compareTo(s2); // 숫자 합이 같으면 사전순으로 정렬
                    }
                }
            }
        });

        // 출력
        for(int i = 0; i < n; i++){
            sb.append(number[i]+"\n");
        }
        System.out.println(sb);
    }

    // 시리얼 넘버 속 숫자들의 합
    private static int number_Sum(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i);
            if(ch >=48 && ch <= 57) {  // 0~9는 아스키 코드 48~57이므로 해당하면
                sum += ch - '0';  //합에 더함
            }
        }
        return sum;
    }
}