package Java;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Overlap_Removing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String res = "U";
        ArrayList<Integer> arrLst = new ArrayList<>();
        while (st.hasMoreTokens())
        {
            int tmp = Integer.parseInt(st.nextToken());
            if(arrLst.indexOf(tmp) >-1){
                res = "D";
                break;
            }
            arrLst.add(tmp);
        }
        bw.write(res);
        bw.flush();
    }
}
