package Java;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[1]== o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int cnt = 1;
        int preEndTime = arr[0][1];
        for(int i = 1 ;i<arr.length;i++){
            if(arr[i][0]>=preEndTime){
                cnt+=1;
                preEndTime = arr[i][1];
            }
        }
        bw.write(cnt + "");
        bw.flush();

    }
}
