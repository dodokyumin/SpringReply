package Programmers_Lv1;

public class lotto {

	public static void main(String[] args) {

		int[] lottos = { 0, 0, 0, 0, 0, 0 };
		int[] win_nums = { 38, 19, 20, 40, 15, 25 };

		solution(lottos, win_nums);
	}

	public static int[] solution(int[] lottos, int[] win_nums) {

		int sol;
		int max = 0;
		int min = 0;

		// 최고 순위
		for (int i = 0; i < lottos.length; i++) {
			sol = lottos[i];
			if (sol == 0) {
				max++;
			} else {
				for (int j = 0; j < win_nums.length; j++) {
					if (sol == win_nums[j]) {
						max++;
						min++;
					}
				}
			}
		}

		int[] answer = { ranking(max), ranking(min) };

		System.out.println(ranking(max) + "," + ranking(min));
		return answer;
	}

	public static int ranking(int point) {
		switch (point) {
		case 6:
			point = 1;
			break;
		case 5:
			point = 2;
			break;
		case 4:
			point = 3;
			break;
		case 3:
			point = 4;
			break;
		case 2:
			point = 5;
			break;
		default:
			point = 6;
			break;
		}
		return point;
	}
}
