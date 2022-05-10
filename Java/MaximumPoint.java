package Java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        Problem2[] pros = new Problem2[n];
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            pros[i] = new Problem2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        MaximumPoint m = new MaximumPoint();

        int res = m.solution(pros, time);

        bw.write(res + "");
        bw.flush();
    }
    public int solution(Problem2[] pros, int limit){
        int answer = 0;
        //Arrays.sort(pros);
        int[] dp = new int[limit+1];

        for(int j=0;j<pros.length;j++){
            for(int i =limit;i>-1;i--){
                if(i-pros[j].time>-1 && i-pros[j].time != pros[j].time){
                    dp[i] = Math.max(dp[i],dp[i-pros[j].time]+pros[j].point );
                    System.out.println("i : " + i + " / point : " + dp[i]);
                }

            }
        }
        answer = dp[limit];
        return answer;
    }
}
class Problem2 implements Comparable<Problem2>{
    public int point;
    public int time;
    public Problem2(int point, int time){
        this.point = point;
        this.time = time;
    }
    public int compareTo(Problem2 p){
        if(this.time>p.time) return 1;
        else if(this.time < p.time) return -1;
        else{
            if(this.point>p.point) return 1;
            else if(this.point<p.point) return -1;
            return 0;
        }
    }
}
