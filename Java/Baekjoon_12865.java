package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Backpack[] backpackArr = new Backpack[n];
        for(int i=0;i<backpackArr.length;i++){
            st = new StringTokenizer(br.readLine());
            backpackArr[i] = new Backpack(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Baekjoon_12865 b = new Baekjoon_12865();
        int res = b.solution(backpackArr,k);

        bw.write(res + "");
        bw.flush();
    }
    public int solution(Backpack[] b, int w){
        int answer = 0;
        int[] dp = new int[w+1];
        for(int i =0;i<b.length;i++){
            for(int j=w;j>-1;j--){
                if(j-b[i].w>-1){
                    dp[j] = Math.max(dp[j], dp[j-b[i].w]+b[i].v);
                }
                //System.out.println("dp[" + j + "] : "+dp[j]);
            }

        }

        answer = dp[w];
        return answer;
    }

}
class Backpack implements Comparable<Backpack>{
    int w;
    int v;
    public Backpack(int w, int v){
        this.w = w;
        this.v = v;
    }
    public int compareTo(Backpack b){
        if(this.v>b.v) return 1;
        else if(this.v<b.v) return -1;
        return 0;
    }

}
