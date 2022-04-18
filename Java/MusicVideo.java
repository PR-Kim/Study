package Java;

import java.io.*;
import java.util.StringTokenizer;

public class MusicVideo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        int total = 0;
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        int min = (int)Math.ceil(total/m);
        //System.out.println("Min : " + min);
        boolean done = false;
        while(!done){
            int tmp = 0;
            int curr =0;
            for(int i =0;i<n;i++){
                tmp += arr[i];
                //System.out.println("tmp : " + tmp + " / i : " + i + "  / curr : " + curr);
                if(tmp<=min){
                    if(i==n-1&& curr<m){
                        done = true;
                        break;
                    }
                }
                else
                {
                    curr+=1;
                    if(i==n-1 && curr<m){
                        done = true;
                        break;
                    }
                    tmp = arr[i];
                }
                if(i==n-1)
                    min+=1;
            }
        }
        bw.write(min + "");
        bw.flush();

    }
}
