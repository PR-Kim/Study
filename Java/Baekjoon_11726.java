package Java;

import java.io.*;

public class Baekjoon_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n>=2){
            dp[2] = 2;
        }

        for(int i =3;i<dp.length;i++){
            dp[i] = (dp[i-2] + dp[i-1])%10007;
        }
        bw.write(dp[n] + "");
        bw.flush();

    }
}
