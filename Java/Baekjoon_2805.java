package Java;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        //System.out.println(Arrays.toString(arr));
        int max = arr[0];
        int min = 0;
        int mid=0;
        while (min<max){
            //System.out.println("Max : " + max + " / Min : " + min );
            mid = (max+min)/2;
            long sum = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]-mid>0)
                    sum += arr[i]-mid;
            }
            if(sum<m){
                max = mid;
            }
            else if(sum>m){
                min = mid+1;
            }
            else{
                bw.write(mid + "");
                bw.flush();
                return;
            }

        }
        bw.write((min-1) + "");
        bw.flush();
    }
}
