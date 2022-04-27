package Java;

import java.io.*;

public class TheChange {
    public static void main(String[] args) throws IOException {
        TheChange t = new TheChange();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int money = Integer.parseInt(br.readLine());
        int ret = t.solution(money);
        bw.write(ret + "");
        bw.flush();

    }
    public int solution(int money){
        int coin[] = {10,50,100,500,1000,5000,10000,50000};
        int counter = 0;
        int idx = coin.length-1;
        while (money>0){
            counter +=  money/coin[idx];
            money %= coin[idx];
            idx -= 1;
        }
        return counter;
    }

}
