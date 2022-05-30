package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_1978 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[1001];
        arr[1] = 1;

        calcPrime();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        for(int i =0;i<n;i++){
            if(arr[Integer.parseInt(st.nextToken())] == 0)
                res+=1;
        }
        bw.write(res +"");
        bw.flush();
    }
    public static void calcPrime(){
        for(int i =2;i<500;i++){
            for(int j=2;j<500;j++){
                if(i*j<1001)
                    arr[i*j] = 1;
                else
                    break;
            }
        }
    }
}
