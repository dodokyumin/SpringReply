package Programmers_Lv1;

public class x_space_n_num {

	public static void main(String[] args) {
		
		solution(-4,2);
	}

	public static long[] solution(long x, int n) {
        long[] answer = new long[n];
        
        for(int i = 0; i < n; i++) {
        	answer[i] = x * (i+1);
        }
        
        return answer;
    }
}
