package Java;

import java.io.*;
import java.net.Inet4Address;
import java.nio.Buffer;
import java.util.*;

public class LeastRecentlyUsed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cacheSize = Integer.parseInt(st.nextToken());
        int totalNum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr= new int[totalNum];

        for(int i = 0;i<totalNum;i++){
            arr[i]  = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> arrLst = new ArrayList<>();
        for(int i=0;i<totalNum;i++){
            if(arrLst.contains(arr[i])) arrLst.remove(arrLst.indexOf(arr[i]));
            arrLst.add(arr[i]);
            if(arrLst.size()>cacheSize)
                arrLst.remove(0);
        }
        for(int i=arrLst.size()-1;i>-1;i--){
            bw.write(arrLst.get(i) + " ");
        }
        bw.flush();



    }
}
