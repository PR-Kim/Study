package Java;

import java.io.*;

public class Baekjoon_9663 {
    public static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Baekjoon_9663 b = new Baekjoon_9663();
        b.dfs(arr,0);
        bw.write(res + "");
        bw.flush();
    }
    public void dfs(int[] arr, int idx){
        if(idx>= arr.length){
            //System.out.println("res  =  " + res);
            res+=1;
            return;
        }

        for(int i =0;i<arr.length;i++){
            arr[idx] = i;
            boolean flag = true;
            if(idx!=0){
                for(int j=idx-1;j>-1;j--){
                    //System.out.println(j +" / arr[j] : " + arr[j] + " / "+ idx +  "arr[idx] : " + arr[idx]);
                    if(arr[j] == arr[idx])
                    {
                        flag = false;
                        break;
                    }
                    if((arr[j] - (j)) == (arr[idx]-idx)){
                        flag = false;
                        break;
                    }
                    if((arr[j] + (j) == (arr[idx]+idx))){
                        flag = false;
                        break;
                    }
                }

            }
            if(!flag)continue;
           // System.out.print("idx : " + idx+ " ");
           // for(int k=0;k<arr.length;k++){
           //     System.out.print(arr[k] + " ");
            //}
           // System.out.println();
            dfs(arr,idx+1);
        }
    }

}
