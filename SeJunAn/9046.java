import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 암호화 배열
    	String substitution_temp = "wghuvijxpqrstacdebfklmnoyz";
    	// 평소 배열
    	String original_temp = "abcdefghijklmnopqrstuvwxyz";
    	
    	// 배열 to ArrayList
    	char[] substitution = new char[substitution_temp.length()];
    	char[] original = new char[original_temp.length()];
    	
    	for (int i = 0; i < substitution.length; i++) {
    		substitution[i] = substitution_temp.charAt(i);
    		original[i] = original_temp.charAt(i);
    	}
    	
    	
    	int count = sc.nextInt();
    	sc.nextLine();
    	
    	
    	for(int j = 0; j < count; j++) {
    		// a ~ z 크기의 배열 생성 -> 빈도 표기 
        	int[] number = new int[26];
        	int max_index = 0;	// 높은 빈도의 알파벳 인덱스를 저장(초기 0)
        	boolean det = true;	// 빈도 동일 시 false로 변경
        	
    		String request = sc.nextLine();
    		for (int k = 0; k < request.length(); k++) {
                char ch = request.charAt(k); 
                if (Character.isLetter(ch)) { // 공백 처리
                    number[ch - 'a']++; // 해당 알파벳의 인덱스 값을 계산하여 배열에 저장
                }
            }
    		// 최빈 알파벳 구하기
    		for (int r = 1; r < number.length; r++) {
    			// max_index를 변경하며 true로 처리한다.
    			if (number[r] > number[max_index]) {
    				max_index = r;
    				det = true;
    			}
    			// 동일한 값의 경우에는 false로 변경한다.
    			else if (number[r] == number[max_index]) {
    				det = false;
    			}
    		}
    		// det 여부에 따라 출력을 달리한다.
    		if(det == true) {
    			System.out.println(original[max_index]);
    		}
    		else {
    			System.out.println("?");
    		}
    	}
    }
}