package Java;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumIncreasingSequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        MaximumIncreasingSequence m = new MaximumIncreasingSequence();
        int res = m.solution(arr);

        bw.write(res +"");
        bw.flush();
    }

    public int solution(int[] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for(int i=1;i<arr.length;i++){
            int tmp = 1;
            for(int j=i-1;j>-1;j--){
                if(arr[j]<arr[i] && dp[j]>=tmp) tmp = dp[j]+1;
            }
            //System.out.println("i : " + i + " / tmp : " + tmp);
            dp[i] = tmp;
            max = Math.max(max, dp[i]);
        }
        answer = max;
        return answer;
    }

}
