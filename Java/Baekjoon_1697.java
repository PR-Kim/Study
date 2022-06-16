package Java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1697 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        Queue<Node1697> que = new LinkedList<>();
        int[] visit = new int[100001];
        Node1697 node = new Node1697(n,0);
        //visit[n] =1;
        que.offer(node);
        int res = 0;
        while (!que.isEmpty()){
            Node1697 tmp = que.poll();
            if(visit[tmp.x]==1) continue;
            visit[tmp.x]=1;
            if(tmp.x != k)
            {
                if(k>tmp.x){
                    if(tmp.x-1>-1) {
                        que.offer(new Node1697(tmp.x-1,tmp.idx+1));
                    }
                    if(tmp.x+1<100001) que.offer(new Node1697(tmp.x+1,tmp.idx+1));
                    if(tmp.x*2<100001) que.offer(new Node1697(tmp.x*2,tmp.idx+1));
                }
                else{
                    if(tmp.x-1>-1) que.offer(new Node1697(tmp.x-1,tmp.idx+1));
                }

            }
            else
            {
                res = tmp.idx;
                break;
            }

        }
        bw.write(res + "");
        bw.flush();
    }
}
class Node1697{
    public int x;
    public int idx;
    public Node1697(int x , int idx){
        this.x = x;
        this.idx = idx;
    }
}
