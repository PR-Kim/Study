package Java;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_TargetNumber {
    public static void main(String[] args){
        Programmers_TargetNumber p = new Programmers_TargetNumber();
        int[] numbers = new int[]{1, 1, 1, 1,1};
        System.out.println(p.solution(numbers,3));
    }
    public int solution(int[] numbers, int target){
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(numbers[0]);
        que.offer(numbers[0]*-1);
        for(int i=1;i<numbers.length;i++){

            int cnt = 0;
            while (cnt<Math.pow(2,i)){
                int tmp = que.poll();
                //System.out.println((tmp==target) + " / i : " + i + " number.Lenth : " + numbers.length);

                int plus = tmp+numbers[i];

                int minus = tmp-numbers[i];
                //System.out.println("Plus : " + plus + " / Minus : " +minus );
                if(plus == target && i==numbers.length-1){
                    answer+=1;
                    //continue;
                }
                if(minus == target && i==numbers.length-1){
                    answer+=1;
                    //continue;
                }
                //System.out.println("Plus : " + plus + " / Minus : " +minus );
                que.offer(plus);
                que.offer(minus);
                cnt++;
            }
        }

        return answer;
    }
}
