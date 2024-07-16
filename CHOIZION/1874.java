import java.io.*;
import java.util.*;

class StackBuild {
    private Stack<Integer> stack;
    private int nextNumber;
    private StringBuilder operations;

    public StackBuild(int maxNumber) {
        stack = new Stack<>();
        nextNumber = 1;
        operations = new StringBuilder();
    }

    public String BuildSeq(List<Integer> targetSeq) {
        for (int target : targetSeq) {
            if (!pushTarget(target)) {
                return "NO";
            }
            popTarget();
        }
        return operations.toString();
    }

    private boolean pushTarget(int target) {
        while (nextNumber <= target) {
            stack.push(nextNumber++);
            operations.append("+\n");
        }
        return !stack.isEmpty() && stack.peek() == target;
    }

    private void popTarget() {
        stack.pop();
        operations.append("-\n");
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seqLength = Integer.parseInt(br.readLine());

        List<Integer> targetSeq = readTargeSeq (br, seqLength);
        StackBuild builder = new StackBuild(seqLength);

        String result = builder.BuildSeq(targetSeq);
        System.out.println(result);

        br.close();
    }
    private static List<Integer> readTargeSeq(BufferedReader br, int seqLength) throws IOException {
        List<Integer> sequence = new ArrayList<>(seqLength);
        for (int i = 0; i < seqLength; i++) {
            sequence.add(Integer.parseInt(br.readLine()));
        }
        return sequence;
    }
}