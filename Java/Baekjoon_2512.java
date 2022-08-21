package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_2512 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int min = 0;
        for(int i =0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        int m = Integer.parseInt(br.readLine());
        //max +=1;
        while (min<=max){
            int mid = (min+max)/2;
            int res = 0;
            for(int i =0;i<arr.length;i++){
                if(arr[i]-mid>=0){
                    res+=mid;
                }
                else {
                    res+=arr[i];
                }
            }
            if(res>m){
                max = mid-1;
            }
            else if(res<=m){
                min = mid+1;
            }
        }
        bw.write((min-1) + "");
        bw.flush();

    }
}
