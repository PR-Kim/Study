package Java;

import java.io.*;
import java.util.Arrays;

public class Baekjoon_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int curr = 1;
        for(int i =n-1;i>-1;i--){
            max = Math.max(max, arr[i]*curr);
            curr+=1;
        }
        bw.write(max + "");
        bw.flush();
    }
}
