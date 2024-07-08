import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person {
    int age;
    String name;

    public Person(int a, String n){
        age = a;
        name = n;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n=0;

        n=Integer.parseInt(br.readLine());

        Person arr[] = new Person[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Person m = new Person(Integer.parseInt(st.nextToken()),st.nextToken());
            arr[i]=m;
        }

        Arrays.sort(arr, new Comparator<Person>() {
            public int compare(Person m1, Person m2){
                return m1.age - m2.age;
            }
        } );

        for(int i=0; i<n; i++){
            bw.write(arr[i].age+" "+arr[i].name+"\n");
        }


        bw.flush();
        bw.close();
    }
}