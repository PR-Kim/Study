package Java;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class DFS_2 {
    static int totalW = 0;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        totalW = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int[] arr = new int[cnt];
        for(int i=0;i<cnt;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dfs(0,0,arr);
        bw.write(res + "");
        bw.flush();
    }
    public static void dfs(int idx, int currW,int[] arr){
        if(currW>totalW) return;
        if(idx>=arr.length) {
            res = Math.max(res, currW);
            return;
        }
        res = Math.max(res, currW);
        dfs(idx+1, currW+arr[idx],arr);
        dfs(idx+1,currW,arr);
    }

}
