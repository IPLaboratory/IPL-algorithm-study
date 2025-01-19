import java.util.Scanner;
//test 외않되
public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String substitution_temp = "wghuvijxpqrstacdebfklmnoyz";
    	String original_temp = "abcdefghijklmnopqrstuvwxyz";
    	
    	char[] substitution = new char[substitution_temp.length()];
    	char[] original = new char[original_temp.length()];
    	
    	for (int i = 0; i < substitution.length; i++) {
    		substitution[i] = substitution_temp.charAt(i);
    		original[i] = original_temp.charAt(i);
    	}
    	
    	int count = sc.nextInt();
    	sc.nextLine();
    	for(int j = 0; j < count; j++) {
    		// 수정할 부분
        	int[] frequency = new int[26];
        	int max_index = 0;
        	boolean det = true;
        	
    		String request = sc.nextLine();
    		for (int k = 0; k < request.length(); k++) {
                char ch = request.charAt(k); // 문자열의 k번째 문자 가져오기
                if (Character.isLetter(ch)) { // 알파벳인지 확인
                    frequency[ch - 'a']++; // 해당 알파벳 빈도 증가
                }
            }
    		for (int r = 1; r < frequency.length; r++) {
    			if (frequency[r] > frequency[max_index]) {
    				max_index = r;
    				det = true;
    			}
    			else if (frequency[r] == frequency[max_index]) {
    				det = false;
    			}
    		}
    		if(det == true) {
    			System.out.println(original[max_index]);
    		}
    		else {
    			System.out.println("?");
    		}
    	}
    }
}