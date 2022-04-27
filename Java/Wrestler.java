package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Wrestler {
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        WrestlerInfo[] wArr = new WrestlerInfo[n];
        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            wArr[i] = new WrestlerInfo(h,w);
        }

        for(int i=0;i<wArr.length;i++){
            WrestlerInfo a = wArr[i];
            boolean candi = true;
            for(int j=0;j<wArr.length;j++){
                if(i==j) continue;
                WrestlerInfo b = wArr[j];
                if(a.compareTo(b)==-1) {
                    candi = false;
                    break;
                }
            }
            if(candi) res+=1;
        }
        bw.write(res +"");
        bw.flush();
    }


}

class WrestlerInfo implements Comparable<WrestlerInfo>{
    int height;
    int weight;
    public WrestlerInfo(int height,int weight){
        this.height = height;
        this.weight = weight;
    }
    public int compareTo(WrestlerInfo w){
        if(w.height>this.height && w.weight>this.weight){
            return -1;
        }
        else if(w.height<this.height && w.weight<this.weight) return 1;

        return 0;
    }
}
