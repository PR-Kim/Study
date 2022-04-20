package Java;

import java.io.*;
import java.util.StringTokenizer;

public class DFS_3 {
    static int time = 0;
    static int cnt = 0;
    static int total =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        Problem[] problems = new Problem[cnt];
        for(int i =0;i<cnt;i++){
            st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        dfs(0,0,0,problems);
        bw.write(total + "");
        bw.flush();
    }

    public static void dfs(int currTime, int currTotal,int idx, Problem[] pros){


        if(currTime>time) return;
        total = Math.max(total, currTotal);
        if(idx>pros.length-1) return;
        //System.out.println("currTotal : " + currTotal + " / currTime : " + currTime + " / idx : " + idx);


        dfs(currTime,currTotal,idx+1,pros);
        dfs(currTime+pros[idx].t,currTotal+pros[idx].point,idx+1,pros);


    }

}
class Problem{
    int t;
    int point;
    public Problem(int point,int t){
        this.t = t;
        this.point = point;
    }
}
