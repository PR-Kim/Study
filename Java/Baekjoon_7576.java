package Java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][col];
        Queue<TomatoNode_> que = new LinkedList<>();
        for(int i =0;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<col; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) que.offer(new TomatoNode_(i,j,0));
            }
        }
        int[] ni = new int[]{+1,0,-1,0};
        int[] nj = new int[]{0,1,0,-1};
        int res = 0;
        while (!que.isEmpty()){
            TomatoNode_ tmp = que.poll();
            for (int i=0;i<4;i++){
                if(tmp.i+ni[i]>-1 && tmp.i+ni[i]<arr.length && tmp.j+nj[i]<arr[0].length && tmp.j+nj[i]>-1){
                    if(arr[tmp.i+ni[i]][tmp.j+nj[i]] ==0){
                        que.offer(new TomatoNode_(tmp.i+ni[i],tmp.j+nj[i],tmp.cnt+1));
                        arr[tmp.i+ni[i]][tmp.j+nj[i]] = 1;
                        res = Math.max(tmp.cnt+1, res);
                    }
                }
            }
        }
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==0){
                    res = -1;
                    break;
                }
            }
        }
        bw.write(res + "");
        bw.flush();

    }
}

class TomatoNode_ {
    public int i;
    public int j;
    public int cnt;
    public TomatoNode_(int i, int j, int cnt) {
        this.i = i;
        this.j = j;
        this.cnt = cnt;
    }
}