package Programmers_Lv1;

public class make_strange_string {

	public static void main(String[] args) {

		System.out.println(solution("try hello world"));
	}

	public static String solution(String s) {
		String answer = "";

		String[] sArr = s.split("");
		int cnt = 1;
		for (int i = 0; i < sArr.length; i++) {
			
			
			if (!sArr[i].equals(" ")) {

				// 단어의 홀수번째
				if (cnt % 2 != 0) {
					sArr[i] = sArr[i].toUpperCase();
				} else {
					sArr[i] = sArr[i].toLowerCase();
				}
				cnt++;
			} else {
				cnt = 1;
			}

		}

		for (String str : sArr) {
			answer += str;
		}
		return answer;
	}

}
