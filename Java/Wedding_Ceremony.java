package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Wedding_Ceremony {
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Wedding_Ceremony w = new Wedding_Ceremony();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        w.solution(arr);
        bw.write(res +"");
        bw.flush();
    }
    public void solution(int[][] arr){
        ArrayList<Schedule> arrLst = new ArrayList<>();
        int min =Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            min = Math.min(min,arr[i][0]);
            max = Math.max(max, arr[i][1]);
            arrLst.add(new Schedule(arr[i][0],arr[i][1]));
        }

        for(int i=min;i<max;i++){
            int tmp = 0;
            for(int j=0;j<arrLst.size();j++){
                tmp+=arrLst.get(j).isIn(i);
            }
            res = Math.max(res,tmp);
        }
    }

}

class Schedule{
    int start;
    int end;
    public Schedule(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int isIn(int time){
        if(time>=start && time<end) return 1;
        return 0;
    }
}