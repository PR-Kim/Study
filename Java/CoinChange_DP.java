package Java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChange_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coins = new int[n];
        //int curr = Integer.parseInt(st.nextToken());
        for(int i =0;i<coins.length;i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        CoinChange_DP c = new CoinChange_DP();
        int res = c.solution(target,coins);

        bw.write(res + "");
        bw.flush();
    }
    public int solution(int target, int[] coins){
        int answer = 0;

        int[] dp = new int[target+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i =0; i<coins.length;i++){
            for(int j=0;j<dp.length;j++){
                if(j-coins[i]<0)dp[j] = Math.min(dp[j],Integer.MAX_VALUE);
                else if(j-coins[i] == 0) dp[j] = Math.min(dp[j],1);
                else
                {
                    if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                        dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                    }else{
                        dp[j] = Math.min(dp[j],Integer.MAX_VALUE);
                    }
                }
            }
        }
        answer = dp[target];

        return answer;
    }
}
