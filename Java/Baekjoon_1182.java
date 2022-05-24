package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_1182 {
    public static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Baekjoon_1182 b = new Baekjoon_1182();

        b.dfs(arr,0,s,0);
        bw.write(res + "");
        bw.flush();
    }
    public void dfs(int[] arr, int idx, int target, int curr){
        if(idx > arr.length-1) return;
        curr += arr[idx];
        if(curr==target) res+=1;
        dfs(arr,idx+1,target,curr);

        curr-=arr[idx];
        dfs(arr,idx+1,target,curr);

    }
}
