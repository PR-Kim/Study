package Java;

import java.io.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][column];
        Queue<TomatoNode> que = new LinkedList<>();
        int res = 0;
        for(int i = 0;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<column;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    que.offer(new TomatoNode(j,i,0,0));
            }
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        while (!que.isEmpty()){
            TomatoNode tm = que.poll();

            for(int i=0;i<dx.length;i++)
            {
                int tmpx = tm.y+dx[i];
                int tmpy = tm.x+dy[i];
                if(tmpx<row && tmpx>-1 && tmpy<column && tmpy >-1 && arr[tmpx][tmpy] == 0){
                    TomatoNode tmp = new TomatoNode(tmpy,tmpx,(tm.cnt+1),1);
                    arr[tmpx][tmpy] = tm.cnt+1;
                    que.offer(tmp);
                    res = Math.max(tm.cnt+1, res);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                //System.out.print(arr[i][j] + " ");
                if(arr[i][j] == 0) {
                    res = -1;
                    break;
                }

            }
            //System.out.println();
        }
        bw.write(res + "");
        bw.flush();

    }

}
class TomatoNode{
    public int x,y;
    public int cnt;
    public int value;
    public TomatoNode(int x,int y,int cnt, int value){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.value = value;
    }
}
