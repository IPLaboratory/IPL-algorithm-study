// 첫번째 풀이

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Member[] arr = new Member[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Member(Integer.parseInt(st.nextToken()), i, st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.order - o2.order;
            }
            return o1.age - o2.age;
        });

        for (int i=0; i<n; i++) {
            bw.write(arr[i].age + " " + arr[i].name + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Member {
        int age;
        int order;
        String name;

        public Member(int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }
    }
}

// 두번째 풀이
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Member[] arr = new Member[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o.age));

        for (int i=0; i<n; i++) {
            System.out.println(arr[i].age + " " + arr[i].name);
        }

    }

    static class Member{
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}