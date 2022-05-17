package Java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bw.write(arr[0] + " ");
        for(int i =1;i<arr.length;i++){
            if(arr[i-1] != arr[i])
                bw.write(arr[i] + " ");
        }
        bw.flush();
    }
}
