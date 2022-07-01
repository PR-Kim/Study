package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        List<Integer> lst = new ArrayList<>();
        for(int i =0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());

            lst.add(tmp);
        }

        int[] dpp = new int[k+1];
        dpp[0] = 1;
        for(int i = 0;i<n;i++){
            for(int j=1;j<=k;j++){
                if(j-lst.get(i)>-1){
                    dpp[j] += dpp[j-lst.get(i)];
                }
            }
        }
        int res = dpp[k];
        bw.write(res + "");
        bw.flush();
    }
}
