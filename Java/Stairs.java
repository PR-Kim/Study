package Java;

import java.io.*;

public class Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stairs s = new Stairs();

        int res = s.solution(n);

        bw.write(res+"");
        bw.flush();
    }

    public int solution(int target){
        int answer = 0;

        int[] dp = new int[36];
        dp[1] = 1;
        dp[2] = 2;
        dp = dpp(dp);
        answer = dp[target];
        return answer;
    }
    public int[] dpp(int[] arr){
        for(int i=3;i<36;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr;
    }
}
