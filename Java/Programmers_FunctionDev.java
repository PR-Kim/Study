package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_FunctionDev {
    public static void main(String[] args){
        Programmers_FunctionDev p = new Programmers_FunctionDev();
        int[] prog = new int[]{95, 90, 99, 99, 80, 99};
        int[] spd = new int[]{1,1,1,1,1,1};
        System.out.println(Arrays.toString(p.solution(prog,spd)));
    }
    public int[] solution(int[] progresses, int[] speeds){
        int[] answer = {};
        int[] answerCandi = new int[101];
        int ex = 0;
        for(int i =0;i<progresses.length;i++){
            int x = (100-progresses[i])%speeds[i]>0 ? ((100-progresses[i])/speeds[i])+1:(100-progresses[i])/speeds[i];
            //System.out.println("x : " + x);
            if(ex>=x) x= ex;
            System.out.println("xx : " + x);
            answerCandi[x] +=1;
            ex = x;
        }
        List<Integer> lst = new ArrayList<>();
        for(int i =0;i<answerCandi.length;i++){
            if(answerCandi[i] >0) lst.add(answerCandi[i]);
        }
        answer = lst.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}

