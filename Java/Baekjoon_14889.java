package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_14889 {
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] selected = new int[n];
        Baekjoon_14889 b = new Baekjoon_14889();
        b.dfs(arr,selected,0,0);
        bw.write(min + "");
        bw.flush();
    }
    public void dfs(int[][] arr, int[] selected,int idx, int curr){
        if(curr==arr.length/2){
            //do Something
            compare(arr,selected);
            return;
        }
        if(idx >arr.length-1){
            return;
        }
        selected[idx] = 1;
        idx+=1;
        curr+=1;
        dfs(arr,selected,idx,curr);
        idx-=1;
        selected[idx]=0;
        idx+=1;
        curr-=1;
        dfs(arr,selected,idx,curr);
    }
    public void compare(int[][] arr, int[] selected){
        int teamA = 0;
        int teamB = 0;
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(selected[i] == selected[j]){
                    if(selected[i]==0){
                        teamA += arr[i][j];
                    }
                    else{
                        teamB += arr[i][j];
                    }
                }
            }
        }
        min = Math.min(min,Math.abs(teamA-teamB));
    }
}
