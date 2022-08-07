package Java;

import java.util.Arrays;

public class Programmers_Immigration {
    public static void main(String[] args){
        Programmers_Immigration p = new Programmers_Immigration();
        int n = 6;
        int[] times = new int[]{7,10};
        System.out.println(p.solution(n,times));
    }
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long)n*times[times.length-1];
        while (left<right){
            long mid = (left+right)/2;
            long num = 0;
            for(int i =0;i<times.length;i++){
                num += (mid/times[i]);
            }
            if(num<n){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        answer = left;
        return answer;
    }
}
