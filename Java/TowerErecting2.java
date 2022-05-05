package Java;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TowerErecting2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Tower2[] towers = new Tower2[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            towers[i] = new Tower2(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        TowerErecting2 t= new TowerErecting2();
        int res = t.solution(towers);

        bw.write(res + "");
        bw.flush();
    }
    public int solution(Tower2[] towers){
        int answer = 0;
        int[] dp = new int[towers.length];
        Arrays.sort(towers, Collections.reverseOrder());
        dp[0] = towers[0].height;
        answer = Math.max(answer,dp[0]);
        for(int i=1;i<towers.length;i++){
            int tmp = towers[i].height;
            for(int j=i-1;j>-1;j--){
                if(towers[i].weight<towers[j].weight){
                    tmp = Math.max(tmp,dp[j]+towers[i].height);
                }
            }
            dp[i] = tmp;
            //System.out.println("dp[" + i + "] :" + dp[i]);
            answer = Math.max(answer,dp[i]);
        }

        return answer;
    }

}
class Tower2 implements Comparable<Tower2> {
    int area;
    int height;
    int weight;

    public Tower2(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    public int compareTo(Tower2 t) {
        if (this.area > t.area) return 1;
        else if (this.area < t.area) return -1;
        return 0;
    }
}
