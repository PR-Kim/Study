package Java;

import java.io.*;
import java.util.StringTokenizer;

public class EscapeMaze_2 {
    static int res = 0;
    static int[] ni = {1,0,-1,0};
    static int[] nj = {0,1,0,-1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [][] arr = new int[8][8];
        for(int i =1;i<arr.length;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j =1;
            while (st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                j+=1;
            }
        }
        /*
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

         */
        escape(1,1,0,arr);
        if(min == Integer.MAX_VALUE) min = -1;
        bw.write(min+"");
        bw.flush();
    }
    public static void escape(int i, int j,int cnt, int[][]maze){
        if(i>7 || j>7) return;
        if(i<1 || j<1) return;
        if(maze[i][j]==1) return;

        if(i==7 && j==7) {
            res+=1;
            min = Math.min(min,cnt);
            return;
        }
        cnt+=1;
        //n.check[i][j] = 1;
        for(int a=0;a<ni.length;a++){
            maze[i][j] = 1;
            escape(i+ni[a],j+nj[a],cnt,maze);
            maze[i][j] = 0;
        }

    }
}

