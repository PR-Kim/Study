package Java;

import java.io.*;
import java.util.*;

public class EmergencyRoom {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> arrLst = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputCount = Integer.parseInt(st.nextToken());
        int targetIdx = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int target=0;
        for(int i=0;i<inputCount;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(i==targetIdx)
                target = tmp;
            que.add(tmp);
            arrLst.add(tmp);
        }
        Collections.sort(arrLst,Collections.reverseOrder());

        boolean continue_ = true;
        int cnt = 1;
        int currIdx = 0;
        while (continue_)
        {
           int tmp = que.poll();
           System.out.println("currIdx : " + currIdx + " / targetIdx" +targetIdx + "/ tmp : " + tmp + " / arrLst.indexOf(tmp) : " + arrLst.indexOf(tmp));
            if(currIdx == targetIdx) {
                if(0==arrLst.indexOf(target))
                    continue_=false;
                else{
                    que.add(target);
                    targetIdx = targetIdx + que.size()-1;

                }
            }
            else{
                if(0==arrLst.indexOf(tmp)){
                    arrLst.remove(arrLst.indexOf(tmp));
                    cnt++;
                }
                else
                {
                    que.add(tmp);
                }
            }
            currIdx++;


        }
        bw.write(cnt+"");
        bw.flush();
    }
}
