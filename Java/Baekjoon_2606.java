package Java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        for(int i =0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            arr[row][col] = 1;
            arr[col][row] = 1;
        }
        int[] virus = new int[n+1];
        virus[1] = 1;
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);

        while (!que.isEmpty()){
            int next = que.poll();
            //System.out.println("next : " + next);
            for(int i=0;i<n+1;i++){
                if(arr[next][i]==1 && virus[i]==0){
                    que.offer(i);
                    virus[i] = 1;
                }
            }
        }
        int res = 0;
        for(int i =2;i<virus.length;i++){
            if(virus[i]==1) res +=1;
        }
        bw.write((res) + "");
        bw.flush();

    }
}
