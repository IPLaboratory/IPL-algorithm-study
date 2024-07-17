import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        LinkedList<String> list = new LinkedList<>();  //연결리스트 생성

        //사용자에게 입력 받기
        String str = br.readLine();  //문자열 입력
        int m = Integer.parseInt(br.readLine());  //명령어 개수

        for(int i=0; i<str.length(); i++){
            list.add(str.substring(i, i+1));  //문자별로 연결리스트에 삽입
        }

        ListIterator<String> iter = list.listIterator(list.size());  //양방향 연결리스트

        for(int i=0; i<m; i++){
            String input = br.readLine();  //명령어 입력
            StringTokenizer st = new StringTokenizer(input);
            String command=st.nextToken();

            switch(command){
                case "L":  //명령어가 L이면,
                    if(iter.hasPrevious())
                        iter.previous();  //커서를 이전(왼쪽)으로 이동
                    break;
                case "D":  //명령어가 D이면,
                    if(iter.hasNext())
                        iter.next();  //커서를 다음(오른쪽)으로 이동
                    break;
                case "B":  //명령어가 B이면,
                    if(iter.hasPrevious()){
                        iter.previous();  //커서의 이전(왼쪽)으로 이동
                        iter.remove();  //이동 전의 해당 요소 삭제
                    }
                    break;
                case "P":  //명령어가 P이면,
                    String newChar = st.nextToken();
                    iter.add(newChar);  //현재 위치에서 새로운 문자 삽입
                    break;
            }
        }

        for(String ch : list){  //리스트의 모든 문자를 순회하여 빌드
            sb.append(ch);
        }

        System.out.println(sb);  //빌드 내용을 출력
    }
}