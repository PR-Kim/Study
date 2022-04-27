package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueAndStack {
    public static void main(String[] args){
        //Queue
        // 선입선출
        //큐는 링크드리스트로 구현
        Queue<Integer> que = new LinkedList<>();
        //삽입
        que.offer(1);
        que.offer(2);
        que.add(3);

        //삭제 혹은 추출
        // 첫번째값 반환 후 제거
        int tmp = que.poll();

        // 첫번째 값 제거
        que.remove();
        //모두삭제
        //que.clear();

        //참조
        //값 반환 후 제거는 안함함
        int tmp2 = que.peek();


 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Stack
        //선입후출
        Stack<Integer> stk = new Stack<>();

        //값 입력

        stk.push(1);
        stk.push(2);
        stk.push(3);


        //값 제거
        //제일 마지막에 들어간 값 반환 후 제거
        int tmp3 = stk.pop();

        //제일 마지막에 들어간 값 참조
        stk.peek();

        //사이즈
        stk.size();

        //스택이 비엇는지
        stk.empty();
        //스택에 해당 값이 포함되었는지
        stk.contains(1);
    }
}
