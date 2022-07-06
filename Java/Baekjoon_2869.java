package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());
        Long v = Long.parseLong(st.nextToken());

        Long res = 0l;
        if(v-a<=0){
            bw.write("1");
            bw.flush();
            return;
        }
       Long day = (v-b)%(a-b) != 0? ((v-b)/(a-b))+1 : (v-b)/(a-b);
        bw.write( day +"");
        bw.flush();
    }
}
