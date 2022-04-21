package Java;

import java.io.*;
import java.util.StringTokenizer;

public class EscapeMaze {
    static int res = 0;
    static int[] ni = {1,0,-1,0};
    static int[] nj = {0,1,0,-1};

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
        Node n = new Node();
        n.curri = 1;
        n.currj = 1;
        escape(1,1,n,arr);
        bw.write(res+"");
        bw.flush();
    }
    public static void escape(int i, int j, Node n, int[][]maze){
        if(i>7 || j>7) return;
        if(i<1 || j<1) return;
        if(maze[i][j]==1) return;
        if(n.check[i][j] ==1) return;
        if(i==7 && j==7) {
            res+=1;
            /*
            System.out.println("");
            for(int q=0;q<n.check.length;q++){
                for(int w=0;w<n.check.length;w++){
                    System.out.print(n.check[q][w] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            */
            return;
        }

        //n.check[i][j] = 1;
        for(int a=0;a<ni.length;a++){
            maze[i][j] = 1;
            escape(i+ni[a],j+nj[a],n,maze);
            maze[i][j] = 0;
        }
    /*
        for(int a=0;a<ni.length;a++){
            Node node = new Node();
            node = n;
            escape(i+ni[a],j+nj[a],node,maze);
        }

     */
        /*
        escape(i, j+1, node,maze);

        escape(i+1, j, node,maze);

        escape(i-1, j, node,maze);

        escape(i, j-1, node,maze);
        */

        /*
        if(n.check[n.curri][n.currj+1] != 1){
            n.currj +=1;
            escape(n,maze);
        }
        if(n.check[n.curri-1][n.currj] != 1){
            n.curri-=1;
            escape(n,maze);
        }
        if(n.check[n.curri][n.currj-1] != 1){
            n.currj-=1;
            escape(n,maze);
        }
        */

    }
}
class Node{
    public int[][] check = new int[8][8];
    public int curri = 0;
    public int currj = 0;

}
