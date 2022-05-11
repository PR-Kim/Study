package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        for(int i = 0 ;i<arr.length;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Baekjoon_1655 b = new Baekjoon_1655();
        b.solution(arr);
    }
    public void solution(int[] arr){
        PriorityQueue<Integer> minQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<arr.length;i++){
            if(maxQ.size() == minQ.size()){
                minQ.offer(arr[i]);
            }
            else
            {
                maxQ.offer(arr[i]);
            }
            if(minQ.size()!=0 && maxQ.size()!=0){
                if(minQ.peek() > maxQ.peek()){
                    int tmp = minQ.poll();
                    int tmpp = maxQ.poll();
                    minQ.offer(tmpp);
                    maxQ.offer(tmp);
                }
            }
            sb.append(minQ.peek() + "\n");
        }

        System.out.println(sb);
    }
}
