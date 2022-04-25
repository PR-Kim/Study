package Java;

import java.io.*;
import java.util.*;

public class Island {
    static int[][] arr= new int[20][20];
    static int[][] visit = new int[20][20];
    static int n;
    static int[] dx ={-1,0,1,0,1,1,-1,-1};
    static int[] dy = {0,-1,0,1,1,-1,1,-1};
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        res = 0;
        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1 && visit[i][j] != 1){
                    res+=1;
                    dfs(i,j);
                }
            }
        }

        bw.write(res + "");
        bw.flush();
    }

    public static void dfs(int i, int j){
        if(i>n-1 || j>n-1 || i<0 || j<0) return;
        if(visit[i][j] == 1) return;
        visit[i][j] = 1;
        if(arr[i][j]==1){
            for(int k=0;k<dx.length;k++){
                dfs(i+dx[k],j+dy[k]);
            }
        }


    }
}

