package Java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<cnt;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int res = -1;
        int lt = 0;
        int rt = cnt-1;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid] == target){
                res = mid;
                break;
            }
            else if(arr[mid]<target){
                lt= mid+1;
            }
            else if(arr[mid]>target){
                rt=mid-1;
            }
        }
        bw.write((res+1) +"");
        bw.flush();
    }
}
