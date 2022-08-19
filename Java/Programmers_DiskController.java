package Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_DiskController {
    public static void main(String[] args){
        Programmers_DiskController p = new Programmers_DiskController();
        //int[][] jobs = new int[][]{{0, 6}, {2, 8}, {3, 7}, {7, 1}, {11, 11}, {19, 25}, {30, 15}, {32, 6},{40, 3}};
        int[][] jobs = new int[][]{{0,3},{4,9},{4,6}};
        System.out.println(p.solution(jobs));
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        int endTime = 0;
        int idx = 0;
        PriorityQueue<int[]> pQue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!= o2[1]){
                    return o1[1]-o2[1];
                }else{
                    return o2[0]-o1[0];
                }

            }
        });
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }

            }
        });
        endTime = jobs[0][0];
        idx+=1;
        pQue.offer(jobs[0]);
        while (!pQue.isEmpty()){
            int[] tmp = pQue.poll();
            System.out.println("tmp[1]: " + tmp[1] + " / tmp[0] : " + tmp[0] + " / endTime : " + endTime);
            endTime +=tmp[1];
            answer+= (endTime-tmp[0]);
            System.out.println(answer);
            for(int i =idx;i<jobs.length;i++){
                if(jobs[i][0]<=endTime){
                    pQue.offer(jobs[i]);
                    idx++;
                }
            }
            if(pQue.isEmpty() && idx<jobs.length-1){
                endTime = jobs[idx][0];
                pQue.offer(jobs[idx]);
                idx++;
            }
        }
        //answer = endTime;
        return answer/jobs.length;
    }
}
