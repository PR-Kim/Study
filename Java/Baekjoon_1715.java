package Java;

import java.io.*;
import java.util.PriorityQueue;

public class Baekjoon_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        for(int i =0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());
            pQue.offer(tmp);
        }

        if(n==1){
            bw.write("0");
            bw.flush();
            return;
        }
        if(n==2){
            bw.write((pQue.poll()+pQue.poll()) + "");
            bw.flush();
            return;
        }
        int res = pQue.poll()+pQue.poll();
        pQue.offer(res);
        //int ex = res;
        while (!pQue.isEmpty()){
            int a = pQue.poll();
            if(pQue.isEmpty()){
                break;
            }
            int b = pQue.poll();
            int tmp = a+b;
            res += tmp;
            pQue.offer(tmp);
        }
        bw.write(res + "");
        bw.flush();
    }
}
