import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(st.nextToken());	// 사람
		int K = Integer.parseInt(st.nextToken());	// 제거할 사람
		Queue<Integer> queue = new LinkedList<>();
		int[] removeArr = new int[N];

		for (int i = 0; i < N; i++) {	// 사람번호 queue에 추가
			queue.add(i+1);
		}

		int front = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < K; j++) {	// front 증가
				front++;
			}
			while (front > queue.size()-1) {	// front가 size보다 클 경우
				front = front-queue.size();		// front에서 size를 빼줘야 함
			}
			removeArr[i] = ((LinkedList<Integer>) queue).get(front);	// 사람한 사람 배열에 추가
			((LinkedList<Integer>) queue).remove(front);	// 사람 제거
		}
		System.out.println(Arrays.toString(removeArr)
				.replace("[", "<")
				.replace("]", ">"));
	}
}
