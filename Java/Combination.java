package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Combination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int res = combi(n,r);
        bw.write(res+"");
        bw.flush();
    }

    public static int combi(int n, int r){
        if(n==r || r==0) return 1;
        return combi(n-1,r-1) + combi(n-1,r);
    }
}
