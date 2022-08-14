package baekjoon_10828_Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
//백준 10828 스택
public class baekjoon_10828_Stack {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		// Stack 객체 생성.
		Stack<Integer> stack = new Stack<>();

		// 첫 라인에서 받은 정수 값 만큼 입력을 반복한다.
		for (int i = 0; i < n; i++) {

			// 매번 받는 라인을 저장할 변수.
			String cons = br.readLine();

			// push 기능 구현
			if (cons.contains("push")) {
				String spt[] = cons.split(" ");
				stack.push(Integer.parseInt(spt[1]));

				// pop 기능 구현
			} else if (cons.contains("pop")) {
				if (stack.empty())
					bw.write(-1 + "\n"); // 별도의 empty() 체크가 필요하다.
				else
					bw.write(stack.pop() + "\n");

				// size 기능 구현
			} else if (cons.contains("size")) {
				bw.write(stack.size() + "\n");

				// empty 기능 구현
			} else if (cons.contains("empty")) {
				if (stack.empty())
					bw.write(1 + "\n"); // 별도의 empty() 체크가 필요하다.
				else
					bw.write(0 + "\n");

				// top 기능 구현
			} else if (cons.contains("top")) {
				if (stack.empty())
					bw.write(-1 + "\n"); // 별도의 empty() 체크가 필요하다.
				else
					bw.write(stack.peek() + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}