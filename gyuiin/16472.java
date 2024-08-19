import java.io.*;

public class Main {
    static int[] arr = new int[26]; // 각 알파벳 문자의 개수 저장 (a~z)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String string = br.readLine();

        int cnt = 0; // 윈도우 안에서 서로 다른 문자 종류의 수
        int a = 0; // 조건을 만족하는 가장 긴 부분 문자열의 길이

        int start = 0;
        int end = 0;

        for(start = 0, end = 0; end < string.length(); end++) { // 슬라이딩 윈도우
            if(arr[string.charAt(end) - 'a']++ == 0) {
                cnt++;
            }

            while (N < cnt && start < end) {
                if (--arr[string.charAt(start++) - 'a'] == 0) cnt--;
            }
            a = Math.max(a, end - start + 1);
        }
        System.out.println(a);
    }
}

