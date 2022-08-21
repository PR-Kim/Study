package Java;

import java.io.*;

public class Baekjoon_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        if(n==1){
            System.out.println(1);
            return;
        }
        if(n==2){
            System.out.println(3);
            return;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        for(int i =3;i<dp.length;i++){
            dp[i] = (dp[i-1] + (dp[i-2]*2))%10007;
        }
        bw.write(dp[n] + "");
        bw.flush();
    }
}
