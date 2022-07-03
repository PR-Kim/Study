package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int i =n-1;i>-1;i--){
            if(k/arr[i]>0){
                cnt += k/arr[i];
                k=k%arr[i];
            }
            if(k==0) break;
        }
        bw.write(cnt + "");
        bw.flush();
    }
}
