import java.io.*;
import java.util.*;

// lowerbound, uppderbound 사용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int card = Integer.parseInt(st.nextToken());

            sb.append(getLastIndex(cards, card) - getFirstIndex(cards, card)).append(" ");
        }
        System.out.println(sb);
    }

    static int getFirstIndex(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int index = arr.length;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                index = mid;
                hi = mid - 1;
            }
        }
        return index;
    }

    static int getLastIndex(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int index = arr.length;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
                index = mid;
            }
        }
        return index;
    }
}


// Map 사용
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cards = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int card = Integer.parseInt(st.nextToken());

            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int card = Integer.parseInt(st.nextToken());

            if (cards.containsKey(card)) sb.append(cards.get(card));
            else sb.append(0);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}

