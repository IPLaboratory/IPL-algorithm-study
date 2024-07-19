import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class j_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //시간초가 안걸리기 위해 ArrayList를 LinkedList로 변경, Character로 변경
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();

        String get = br.readLine();
        for (int i = 0; i < get.length(); i++) {
            iter.add(get.charAt(i));
        }
        //입력받을 값의 개수
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String arr = br.readLine();
            char fst = arr.charAt(0);
            if(fst == 'L') {
                if(iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (fst == 'D') {
                if(iter.hasNext()) {
                    iter.next();
                }
            }else if(fst == 'B') {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }else if(fst == 'P') {
                iter.add(arr.charAt(2));
            }
        }
            
        //시간초가 안걸리기 위해 for문 형식 아래와 같이 작성
        for (Character c : list) {
            bw.write(c);
        }

        bw.flush();
        bw.close();
    }
}
