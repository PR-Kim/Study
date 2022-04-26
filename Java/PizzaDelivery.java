package Java;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PizzaDelivery {
    static int length;
    static int cnt;
    static ArrayList<Point> homes;
    static ArrayList<Point> pizzas;
    static int[] combi;
    static int res;
    public static void main(String[] args) throws IOException {
        PizzaDelivery T = new PizzaDelivery();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer("");
        int[][] arr = new int[length][length];
        homes = new ArrayList<>();
        pizzas = new ArrayList<>();

        for(int i =0;i<length;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<length;j++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                Point tmpp = new Point(i,j);
                if(tmp==1) homes.add(tmpp);
                if(tmp==2) pizzas.add(tmpp);
            }
        }
        combi = new int[cnt];
        res = Integer.MAX_VALUE;

        T.Combination(0,0);
        bw.write(res + "");
        bw.flush();
    }

    public void Combination(int L, int s){
        if(L == cnt){
            //조합 하나가 완성됐을 때,
            int tmpRes = 0;
            for(int i =0;i<homes.size();i++){
                int tmpDis = Integer.MAX_VALUE;
                for(int j=0;j<combi.length;j++){
                    tmpDis = Math.min(tmpDis,homes.get(i).CalcDistance(pizzas.get(combi[j])));
                }
                tmpRes+= tmpDis;
            }
            res = Math.min(res,tmpRes);
        }else {
            //조합 완성되기 전
            for(int i=s;i<pizzas.size();i++){
                combi[L] = i;
                Combination(L+1,i+1);
            }
        }
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int CalcDistance(Point poi){
        return Math.abs(this.x-poi.x) + Math.abs(this.y-poi.y);
    }
}


