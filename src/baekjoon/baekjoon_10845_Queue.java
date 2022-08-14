package baekjoon_10845_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_10845_Queue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int back = 0;
		//Queue는 데이터의 추가 삭제가 쉬운 LinkedList로 구현하는 것이 더 적합하다.
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		//명령 입력을 N번 진행할 것임.
		for(int i = 0; i < N; i++) {
			String order = br.readLine();
			
			switch (order) {
				//데이터 입력 : add()
			case "push":
				int inputNum = Integer.parseInt(br.readLine());
				back = inputNum;
				queue.add(inputNum);
				break;
				
				//데이터 삭제 후 출력 : poll()
			case "pop":
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
				}
				break;
				
				//큐에 저장된 데이터 수 출력 : size()
			case "size":
				System.out.println(queue.size());
				break;
				
				//큐가 비어있는지 확인 : isEmpty()
			case "empty":
				if(queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
				
				//큐의 가장 앞에 있는 데이터를 삭제 없이 출력 : peek()
			case "front":
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());
				}
				break;
				
				//Queue는 FIFO방식. 마지막에 추가("push")한 값이 맨 뒤의 숫자가 되므로 back을 출력해준다. 
			case "back":
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(back);
				}
				break;
			}
			
		}
	}

}
