package Programmers_Lv1;

public class check_pow {

	public static void main(String[] args) {
		
		//int n = 121;
		int n = 3;
		
		System.out.println(solution(n));
		

	}

	public static long solution(long n) {
		long answer = 0;
		
		if(Math.sqrt(n) % 1 == 0) {
			answer = (long) Math.pow(Math.sqrt(n)+1, 2);
		} else {
			answer = -1;
		}
		
		return answer;
	}

}
