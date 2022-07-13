package Java;

import java.io.*;
import java.util.Stack;

public class Programmers_LV1 {
    public static void main(String[] args) throws IOException{

        int[] arr1 = new int[]{1,1,3,3,0,1,1};

    }
    public static int[] solution(int[] arr){
        int[] answer = {};
        Stack<Integer> stk = new Stack<>();
        stk.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(stk.peek() != arr[i]) stk.add(arr[i]);
        }
        answer = new int[stk.size()];
        for(int i =answer.length-1;i>-1;i--){
            answer[i] = stk.pop();
        }

        return answer;

    }
}
