package Java;

import java.util.PriorityQueue;

public class Programmers_Scoville {
    public static void main(String[] args){
        Programmers_Scoville p = new Programmers_Scoville();
        int[] arr = new int[]{1, 2, 3, 9, 10, 12};
        System.out.println(p.solution(arr,7));
    }
    public int solution(int[] scoville, int K){
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0;i<scoville.length;i++){
            que.offer(scoville[i]);
        }
        while (!que.isEmpty()){
            int tmpa = que.poll();
            if(tmpa>=K){
                break;
            }
            if(que.isEmpty()){
                answer = -1;
                break;
            }
            int tmpb = que.poll();
            int tmpc = tmpa + (tmpb*2);
            que.offer(tmpc);
            answer+=1;
        }

        return answer;
    }
}
