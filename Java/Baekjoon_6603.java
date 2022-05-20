package Java;

import java.io.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Baekjoon_6603 b = new Baekjoon_6603();
        int j=0;
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0){
                //Do something
                break;
            }
            if(j!=0)System.out.println();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            b.dfs(arr,0,new ArrayList<>());
            j++;
        }


    }
    public void dfs(int[] arr,int idx, ArrayList<Integer> arrLst){
        if(arrLst.size()>=6){
            System.out.println(arrLst.toString().replace("[","").replace("]","").replace(",",""));
            return;
        }
        if(idx>=arr.length)return;
        arrLst.add(arr[idx]);
        dfs(arr,idx+1,arrLst);
        arrLst.remove(arrLst.size()-1);
        dfs(arr,idx+1,arrLst);
    }
}
