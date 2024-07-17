import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력 버퍼 설정
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); // 초기 편집기 문자열을 입력 받기
        int N = Integer.parseInt(br.readLine()); // 입력할 명령어의 개수를 입력 받기

        LinkedList<Character> list = new LinkedList<Character>(); // 연결리스트 선언

        for(int i = 0; i < str.length(); i++) { // 초기 문자열 str을 연결리스트에 추가
            list.add(str.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator(); // 양방항 이동이 가능한 ListIterator 생성

        while(iter.hasNext()) { // 문자열 끝으로 커서를 이동시킴
            iter.next();
        }

        for(int i = 0; i < N; i++) { // 입력 받은 명령어 개수 만큼 반복
            String control = br.readLine(); // 명령어를 입력 받기
            char cont = control.charAt(0); // 명령어의 첫 글자 저장
            switch(cont) {
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous(); // 커서를 왼쪽으로 한 칸 이동
                    break;

                case 'D':
                    if(iter.hasNext())
                        iter.next(); // 커서를 오른쪽으로 한 칸 이동
                    break;

                case 'B': // 커서 왼쪽 문자를 삭제
                    if(iter.hasPrevious()) {
                        iter.previous(); // 커서를 원래 위치로 유지하기 위해 이전 문자로 이동
                        iter.remove(); // 문자 삭제
                    }
                    break;

                case 'P':
                    char in = control.charAt(2); // 세 번째 문자를 in에 저장
                    iter.add(in); // in에 저장된 문자 삽입
                    break;

                default:
                    break;
            }
        }
        for(Character res : list) { // 결과 출력
            bw.write(res);
        }
        bw.flush(); // 사용한 버퍼 정리
        bw.close();
    }
}
