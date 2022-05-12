package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<k;i++){

            if(Arrays.binarySearch(arr,Integer.parseInt(st.nextToken()))>=0)
                bw.write("1\n");
            else
                bw.write("0\n");
        }
        bw.flush();

    }
}
