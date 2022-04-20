package Java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CoinChange {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coins = new int[cnt];
        for(int i =0;i<cnt;i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Queue<Coin> que = new LinkedList<>();
        Coin c = new Coin(target,0);
        que.offer(c);
        boolean flag = true;
        while (flag){

            Coin tmp = que.poll();
            tmp.Level+=1;
            for(int i =0;i<coins.length;i++){

                int tmpp = tmp.currCoin-coins[i];
                if(tmpp==0) {
                    res = Math.min(res, tmp.Level);
                    flag = !flag;
                    break;
                }
                if(tmpp>0) que.offer(new Coin(tmpp,tmp.Level));
            }
        }
        bw.write(res + "");
        bw.flush();

    }

}
class Coin{
    int currCoin;
    int Level;
    public Coin(int currCoin,int Level){
        this.currCoin = currCoin;
        this.Level = Level;
    }
}
