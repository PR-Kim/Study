package Java;

import java.io.*;

public class Baekjoon_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] space = new int[n-1];
        int ex=0;
        for(int i =0;i<n;i++){
            if(i==0){
                ex = Integer.parseInt(br.readLine());
            }
            else
            {
                int tmp = Integer.parseInt(br.readLine());
                space[i-1] = tmp-ex;
                ex = tmp;
            }
            arr[i] = ex;
        }
        Baekjoon_2485 b = new Baekjoon_2485();
        int gcd = b.gcd(space,2, b.gcd(space[0],space[1]));
        //System.out.println("gcd : " + gcd);
        int tmp = arr[n-1]-arr[0];
        //System.out.println("tmp : " + tmp);
        int res = (tmp/gcd) +1-n;
        bw.write(res +"");
        bw.flush();

    }
    public int gcd(int[] arr, int idx, int gcd){
        if(idx>arr.length-1) return gcd;
        return gcd(arr,idx+1,gcd(gcd,arr[idx]));
    }
    public int gcd(int a, int b){
        int tmp, n;
        if(a<b){
            tmp = a;
            a=b;
            b =tmp;
        }
        while (b!=0){
            n = a%b;
            a=b;
            b=n;
        }
        return a;
    }

    public int lcm(int a,int b){
        return (a*b)/ gcd(a,b);
    }
}
