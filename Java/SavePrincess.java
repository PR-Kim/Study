package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SavePrincess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> arrLst = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i =1;i<=total;i++)
        {
            arrLst.add(i);
        }
        //System.out.println(arrLst.size());
        int currK = 1;
        int currIdx = 0;
        while (arrLst.size() != 1){
            //System.out.println("currK : " + currK + " / currIDX : " + currIdx);
            if(currK++ == k)
            {
                arrLst.remove(currIdx--);
                //System.out.println(arrLst.toString());
            }
            currIdx++;
            if(currIdx >= arrLst.size()) currIdx=0;
            if(currK>k) currK=1;
        }
        bw.write(arrLst.get(0) + "");
        bw.flush();
    }
}
