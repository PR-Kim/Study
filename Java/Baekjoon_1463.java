package Java;

import java.io.*;
import java.util.Arrays;

public class Baekjoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Baekjoon_1463 b = new Baekjoon_1463();
        int res = b.solution(n);

        bw.write(res + "");
        bw.flush();
    }
    public int solution(int n){
        int answer = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        if(n==1) return 0;
        if(n==2 || n==3) return 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i =4;i<dp.length;i++){
            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
            if(i%2==0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            dp[i] = Math.min(dp[i],dp[i-1]+1);

            //System.out.println("dp[ " + i + "] : " + dp[i]);
        }
        answer = dp[n];
        return answer;
    }
}
