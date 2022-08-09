package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Pack[] packArr = new Pack[n];
        for(int i =0;i<packArr.length;i++){
            st = new StringTokenizer(br.readLine());
            packArr[i] = new Pack(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Baekjoon_Knapsack b = new Baekjoon_Knapsack();
        System.out.println(b.solution(packArr,k));
    }
    public int solution(Pack[] packArr, int k){
        int answer = 0;
        int[] dp = new int[k+1];
        for(int i = 0; i<packArr.length;i++){
            for(int j =k;j>-1;j--){
                if(j-packArr[i].w>-1){
                    dp[j] = Math.max(dp[j],packArr[i].v+dp[j-packArr[i].w]);
                }
            }
        }
        answer = dp[k];
        return answer;
    }
}
class Pack{
    int w;
    int v;
    public Pack(int w, int v){
        this.w = w;
        this.v = v;
    }

}
