package Java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        int min = 0;
        for(int i =0;i<arr.length;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);
        min = 0;
        max+=1;
        while (min<max){
            int mid = (min+max)/2;
            int ex = arr[0];
            int curr = 1;
            for(int i=1;i<arr.length;i++){
                if(arr[i]-ex>=mid){
                    curr+=1;
                    ex = arr[i];
                }
            }
            if(curr<c){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        bw.write((min-1) + "");
        bw.flush();

    }
}
