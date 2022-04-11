package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Bubble_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[cnt];
        for(int i =0;i<cnt;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        do{
            flag = false;
            for(int i =1;i<cnt;i++){
                if(arr[i-1]>arr[i]){
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    flag = true;
                }
            }
        }while(flag);
        for(int i =0;i<cnt;i++){
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }
}
