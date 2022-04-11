package Java;

import java.io.*;
import java.util.StringTokenizer;

public class Selection_Sort {
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


        for(int i =0;i<arr.length;i++){
            int minIdx = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[minIdx]>arr[j])
                    minIdx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }

        for(int i=0;i<arr.length;i++){
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }
}
