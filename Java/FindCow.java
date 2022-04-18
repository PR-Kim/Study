package Java;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        int cow = Integer.parseInt(st.nextToken());
        int[] move = {1,-1,5};
        int[] check = new int[10001];

        Queue<Integer> que = new LinkedList<>();
        que.offer(me);
        int L=0;
        while(!que.isEmpty()){
            int tmp = que.size();
            for(int i =0;i<tmp;i++){
                int a = que.poll();
                for(int j=0;j<move.length;j++){
                    if(a+move[j]>-1 && a+move[j]<10001 && check[a+move[j]] != 1) {
                        que.offer(a + move[j]);
                        check[a+move[j]] =1;
                    }
                }
            }
            L+=1;
            if(check[cow] == 1) break;
        }


        bw.write(L + "");
        bw.flush();

    }
}
