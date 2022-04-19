package Java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS_ {
    static int total = 0;
    static String res = "NO";
    static int n = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        if(total%2!=0){
            bw.write(res);
            bw.flush();
            return;
        }
        DFS(0,0,arr);
        bw.write(res);
        bw.flush();
    }

    public static void DFS(int L, int sum, int[] arr){
        if(L>n-1) return;
        if(sum>total/2) return;
        if(sum == total/2){
            res = "YES";
            return;
        }
        DFS(L+1,sum+arr[L],arr);
        DFS(L+1,sum,arr);
    }

}
