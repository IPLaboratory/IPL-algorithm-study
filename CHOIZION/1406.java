import java.io.*;
import java.util.*;




public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       LinkedList<Character> editor = new LinkedList<>();
       String initialText = br.readLine();
       for (char c : initialText.toCharArray()) {
       editor.add(c);
       }

       int commandCount = Integer.parseInt(br.readLine());
       ListIterator<Character> cs = editor.listIterator(editor.size());

       while (commandCount-- > 0) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           char command = st.nextToken().charAt(0);

           // 나중에 커맨드 넣을 곳
           switch (command) {

               case 'L' :
                   LeftMove(cs);
                   break;

               case 'D' :
                   RightMove(cs);
                   break;

               case 'B' :
                   ReMove(cs);
                   break;

               case 'P' :
                   char charToInsert = st.nextToken().charAt(0);
                   AddMove(cs, charToInsert);
                   break;

           }
       }

       for (char c : editor) {
           bw.write(c);
       }

       bw.flush();
       bw.close();
       br.close();
    }

    private static void LeftMove(ListIterator<Character> cs) {
        if (cs.hasPrevious()) {
            cs.previous();
        }
    }

    private static void RightMove(ListIterator<Character> cs) {
        if (cs.hasNext()) {
            cs.next();
        }
    }

    private static void ReMove(ListIterator<Character> cs) {
        if (cs.hasPrevious()) {
            cs.previous();
            cs.remove();
        }
    }

    private static void AddMove(ListIterator<Character> cs, char c) {
        cs.add(c);
    }
}



