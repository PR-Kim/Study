package Java;

import java.io.*;

public class Baekjoon_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i =0;i<arr.length;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Baekjoon_2579 b = new Baekjoon_2579();
        int res = b.solution(arr);
        bw.write(res+"");
        bw.flush();
    }
    public int solution(int[] arr){
        int answer = 0;
        int[][] dp = new int[arr.length][3];
        if(arr.length==1){
            return arr[0];
        }
        if(arr.length==2){
            return arr[0]+arr[1];
        }
        // 0 내가 포함 안되고, 앞에 두개만
        // 1 내가 포함되고, 앞앞에거만
        // 2 내가 포함되고, 앞에거만
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        dp[0][2] = arr[0];
        dp[1][0] = arr[0];
        dp[1][1] = arr[1];
        dp[1][2] = arr[0] + arr[1];
        for(int i =2;i<arr.length;i++){
            dp[i][0] = dp[i-1][2];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-2][1])+ arr[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-2][0])+ arr[i];;
        }
        answer = Math.max(dp[arr.length-1][1],dp[arr.length-1][2]);
        return answer;
    }
}
