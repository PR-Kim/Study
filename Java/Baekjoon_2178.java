package Java;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2178 {
    static int res=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][k];
        int[][] visit = new int[n][k];
        for(int i =0;i<n;i++){
            String tmp = br.readLine();
            for(int j = 0;j<k;j++){
                int a = tmp.charAt(j)-'0';
                //System.out.println(a);
                arr[i][j] = a;
            }
        }
        /*
        for(int i =0;i<n;i++){
            for(int j = 0;j<k;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("\n");
        }
        */

        Baekjoon_2178 b = new Baekjoon_2178();
        b.bfs(arr,visit,0,0,1);
        bw.write(res + "");
        bw.flush();
    }
    public void bfs(int[][]arr, int [][] visit, int i,int j, int cnt){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i,j,cnt});
        while (!que.isEmpty()){
            int[] tmp = que.poll();
            i = tmp[0];
            j = tmp[1];
            cnt = tmp[2];
            if(i<0) continue;
            if(j<0) continue;
            if(i>arr.length-1) continue;
            if(j>arr[i].length-1) continue;
            if(arr[i][j]==0) continue;
            if(visit[i][j]==1) continue;
            if(i==arr.length-1 && j == arr[i].length-1){
                res = Math.min(res,cnt);
                break;
            }
            visit[i][j]=1;
            que.offer(new int[]{i+1,j,cnt+1});
            que.offer(new int[]{i,j+1,cnt+1});
            que.offer(new int[]{i-1,j,cnt+1});
            que.offer(new int[]{i,j-1,cnt+1});

        }

    }
    public void dfs(int[][] arr, int[][] visit, int i, int j, int cnt){
        //int answer = cnt;
        //System.out.println("i :"+ i + " / j: " + j + " / cnt: " +cnt );
        if(i<0) return;
        if(j<0) return;
        if(i>arr.length-1) return;
        if(j>arr[i].length-1) return;
        if(arr[i][j]==0) return;
        if(visit[i][j]==1) return;
        if(i==arr.length-1 && j == arr[i].length-1){
            res = Math.min(res,cnt);
            return;
        }
        visit[i][j]=1;
        dfs(arr,visit ,i+1,j,cnt+1);
        dfs(arr,visit ,i,j+1,cnt+1);
        dfs(arr,visit,i-1,j,cnt+1);
        dfs(arr,visit,i,j-1,cnt+1);
        visit[i][j]=0;
      //  return answer;
    }

}

