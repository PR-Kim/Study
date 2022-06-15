package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] visit = new int[n][n];
        for(int i =0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        Baekjoon_2667 b = new Baekjoon_2667();
        ArrayList<Integer> arrLst = b.solution(arr,visit);
        //System.out.println(arrLst.toString());
        bw.write(arrLst.size() + "\n");
        Collections.sort(arrLst);
        for(int i =0;i<arrLst.size();i++) {

            bw.write(arrLst.get(i) + "");
            if(i<arrLst.size()-1)
                bw.newLine();
        }
        bw.flush();

    }
    public ArrayList<Integer> solution(int[][] arr, int[][] visit){
        ArrayList<Integer> arrLst = new ArrayList<>();

        for(int i =0;i<arr.length;i++){
            for(int j =0;j<arr.length;j++){
                //System.out.println(arr[i][j]);
                if(arr[i][j] == 1 && visit[i][j] == 0){
                    //System.out.println("i : " + i + " / j : " + j);
                    int tmp = dfs(arr,visit,i,j,1);
                    arrLst.add(tmp);
                }
            }
        }

        return arrLst;
    }
    public int dfs(int[][] arr, int[][] visit, int i, int j,int cnt){
        if(i>=arr.length || j>=arr.length) return 0;
        if(i<0 || j<0) return 0;
        if(visit[i][j] ==1) return 0;
        visit[i][j] = 1;
        //cnt+=1;
        if(i-1>-1){
            if(arr[i-1][j]==1 && visit[i-1][j] == 0)
                cnt= dfs(arr,visit,i-1,j,cnt+=1);
        }
        if(j-1>-1){
            if(arr[i][j-1]==1 && visit[i][j-1] == 0)
                cnt= dfs(arr,visit,i,j-1,cnt+=1);
        }
        if(i+1<arr.length){
            if(arr[i+1][j]==1 && visit[i+1][j] == 0)
                cnt= dfs(arr,visit,i+1,j,cnt+=1);
        }
        if(j+1<arr.length){
            if(arr[i][j+1]==1 && visit[i][j+1] == 0)
                cnt= dfs(arr,visit,i,j+1,cnt+=1);
        }


        return cnt;
    }
}
