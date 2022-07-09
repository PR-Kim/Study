package Java;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)>Math.abs(o2))return 1;
                else if(Math.abs(o1)<Math.abs(o2))return -1;
                else{
                    if(o1>o2) return 1;
                    else if(o1<o2) return -1;
                    return 0;
                }
            }
        });

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
/*
PriorityQueue<Integer> pQue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)>Math.abs(o2)){
                    return 1;
                }
                else if(Math.abs(o1)<Math.abs(o2)){
                    return -1;
                }
                else{

                }
                return 0;
            }
        });
 */
