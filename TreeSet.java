import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[] arr = new int[cnt];

        Integer[] currNum = new Integer[3];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i =0;i<arr.length;i++)
        {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        TreeSet<Integer> tree = new TreeSet<Integer>(Collections.reverseOrder());
        for(int i =0;i<cnt;i++)
        {
            for(int j =i+1;j<cnt;j++)
            {
                for(int k = j+1;k<cnt;k++)
                {
                    //System.out.println("i : "+ i + " j : "+ j + " k : " + k +" / "+ (arr[i]+arr[j]+arr[k]));
                    tree.add((arr[i]+arr[j]+arr[k]));
                }
            }
        }
        int answer = -1;
        int t = 0;
        for(int i : tree)
        {
            //System.out.println(i);
            if(t==length-1)
                answer = i;
            t++;
        }
        bw.write(answer+"");
        bw.flush();
    }
}