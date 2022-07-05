package Java;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Baekjoon_1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        Long n = Long.parseLong(st.nextToken());

        Long[] arr = new Long[k];
        Long max = 0l;
        Long min = 0l;
        for(int i =0;i<arr.length;i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max,arr[i]);
        }
        max+=1;
        Long mid = 0l;
        while (min<max){
            mid = (min+max)/2;
            Long sum = 0l;
            //System.out.println("Max : " + max + " / Min : " + min + " / Mid : " + mid);
            for(int i =0;i<arr.length;i++){

                if(arr[i]/mid>0){
                    sum+=arr[i]/mid;
                }
            }
            //System.out.println("Sum : " + sum);
            if(sum<n){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        bw.write(min-1 + "");
        bw.flush();
    }
}
