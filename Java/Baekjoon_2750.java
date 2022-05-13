package Java;

import java.io.*;
import java.util.PriorityQueue;

public class Baekjoon_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i =0;i<n;i++){
            que.offer(Integer.parseInt(br.readLine()));
        }
        for(int i =0;i<n;i++){
            bw.write(que.poll() + "\n");
        }
        bw.flush();
    }

}
