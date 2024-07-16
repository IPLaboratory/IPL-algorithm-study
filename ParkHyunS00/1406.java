import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> editor = new LinkedList<>();
        String initString = br.readLine();
        int M = Integer.parseInt(br.readLine());

        for (char c : initString.toCharArray()) {
            editor.add(c);
        }

        ListIterator<Character> it = editor.listIterator(editor.size());

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            if (command == 'L') {
                if (it.hasPrevious())
                    it.previous();
            } else if (command == 'D') {
                if (it.hasNext()) it.next();
            } else if (command == 'B') {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else {
                it.add(st.nextToken().charAt(0));
            }

        }

        StringBuilder sb = new StringBuilder();
        for (char c : editor) sb.append(c);
        System.out.print(sb);
    }
}
