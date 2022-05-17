package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_10816 {
    public static void main(String[] args) throws IOException {
        Baekjoon_10816 b = new Baekjoon_10816();
        b.solution();

    }
    public void solution() throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[Integer.parseInt(st.nextToken()) + 10000000] +=1;
        }

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            bw.write(arr[Integer.parseInt(st.nextToken()) + 10000000] + " ");
        }
        bw.flush();
    }
}
