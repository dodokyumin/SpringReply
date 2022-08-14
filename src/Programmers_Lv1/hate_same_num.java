package Programmers_Lv1;

import java.util.Stack;

public class hate_same_num {

	public static void main(String[] args) {
		
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		solution(arr);
	}

	public static int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        
        for(int i: arr) {
        	if(stack.peek() != i) {
        		stack.push(i);
        	}
        }
        
         return answer;
    }
}
