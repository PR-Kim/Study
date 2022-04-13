package Java;

import java.io.*;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordi implements Comparable<Coordi>{
    int x;
    int y;
    public Coordi(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Coordi c){
        if(this.x<c.x){
            return -1;
        }
        else if(this.x > c.x)
        {
            return 1;
        }
        else if(this.x == c.x){
            if(this.y <c.y){
                return -1;
            }
            else if(this.y>c.y)
                return 1;
        }
        return 0;
    }
}
public class Coordinate_Sorting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        Coordi[] arrC = new Coordi[cnt];

        for(int i = 0;i<cnt;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Coordi c = new Coordi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arrC[i] = c;
        }
        Arrays.sort(arrC);

        for(int i =0;i<cnt;i++){
            String tmp = arrC[i].x +" " + arrC[i].y;
            bw.write(tmp + "\n");
        }
        bw.flush();
    }

}
