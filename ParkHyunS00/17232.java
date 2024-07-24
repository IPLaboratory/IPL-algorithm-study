import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        char[][] board = new char[N + 1][M + 1];

        for (int i=1; i<=N; i++) {
            String row = br.readLine();
            for (int j=1; j<=M; j++) {
                board[i][j] = row.charAt(j - 1);
            }
        }

        while (T-- > 0) {
            int[][] prefixSum = getPrefixSum(board);

            for (int i=1; i<=N; i++) {
                for (int j=1; j<=M; j++) {
                    int nearAlive = getRangeSum(prefixSum, i, j, K);

                    if (board[i][j] == '*') {
                        nearAlive--;

                        if (nearAlive < a || nearAlive > b) board[i][j] = '.';
                    } else if (board[i][j] == '.' && nearAlive > a && nearAlive <= b) board[i][j] = '*';
                }
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] getPrefixSum(char[][] board) {
        int[][] prefixSum = new int[board.length][board[0].length];

        for (int i=1; i<board.length; i++) {
            for (int j=1; j<board[0].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + (board[i][j] == '*' ? 1 : 0);
            }
        }
        return prefixSum;
    }

    static int getRangeSum(int[][] prefixSum, int x, int y, int k) {
        int x1 = Math.max(x - k, 1);
        int y1 = Math.max(y - k , 1);
        int x2 = Math.min(x + k, prefixSum.length - 1);
        int y2 = Math.min(y + k, prefixSum[0].length - 1);

        return prefixSum[x2][y2] - prefixSum[x2][y1 - 1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1];
    }
}
