package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Baekjoon_15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        Baekjoon_15990 b = new Baekjoon_15990();
        long[][] resarr = b.solution();
        for(int i =0;i<t;i++){
            int tmp = Integer.parseInt(br.readLine());
            long res = (resarr[tmp][1] + resarr[tmp][2] + resarr[tmp][3])%1000000009;
            bw.write(res + "\n");

        }
        bw.flush();
    }
    public long[][] solution(){

        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i =4;i<dp.length;i++){
            dp[i][1] = (dp[i-1][3] + dp[i-1][2])%1000000009;
            dp[i][2] = (dp[i-2][3] + dp[i-2][1])%1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%1000000009;
        }

        return dp;
    }
}
