package Java;

import java.io.*;
import java.util.PriorityQueue;

public class Baekjoon_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        for(int i =0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp ==0){
                if(!pQue.isEmpty()){
                    bw.write(pQue.poll() + "");
                }else{
                    bw.write(0 + "");
                }
                bw.newLine();
            }
            else{
                pQue.offer(tmp);
            }
        }
        bw.flush();
    }
}
