import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String existingString = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        for (char ch : existingString.toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case 'D':
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case 'B':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    iterator.add(command.charAt(2));
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : list) {
            result.append(ch);
        }

        System.out.println(result);
    }
}
