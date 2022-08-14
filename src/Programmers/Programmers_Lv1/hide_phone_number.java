package Programmers_Lv1;

public class hide_phone_number {

	public static void main(String[] args) {

		System.out.println(solution("01033334444"));
	}

	public static String solution(String phone_number) {
		String answer = "";
		int cnt = 0;
		String Arr[] = phone_number.split("");

		for (int i = Arr.length; i >= 0; i--,cnt++) {
			if(cnt > 4) {
				Arr[i] = "*";
			}
		}
		
		for(String c : Arr) {
			answer += c;
		}

		return answer;
	}
}
