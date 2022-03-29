package Java;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 인형뽑기 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[cnt][cnt];
        int[] n = new int[cnt];

        for(int i =0;i<cnt;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j =0;j<cnt;j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0 && n[j] ==0)
                    n[j] = i;
            }
        }
        /*
        for(int i =0;i<cnt;i++)
        {
            System.out.println(arr[i][0]+"," +arr[i][1]+"," +arr[i][2]+"," +arr[i][3]+"," +arr[i][4]  );
        }
        */
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for(int i=0;i<k;i++)
        {

            int idx = Integer.parseInt(st2.nextToken());
            //System.out.println(idx);
            if(n[idx-1] > cnt-1 ) continue;
            int next = arr[n[idx-1]][idx-1];
            //if(!stk.empty())
            //System.out.println("peek : " + stk.peek() + "/ next : " + next + " / n[idx-1] : " + n[idx-1]);
            if(!stk.empty() && stk.peek() == next)
            {
                //두개가 같은 수 터트린다.
                stk.pop();
                res += 2;
                //System.out.println("여기안들어오나");
            }
            else
            {
                stk.push(next);
            }
            n[idx-1]++;
           // System.out.println(stk.toString());
        }
        bw.write(res + "");
        bw.flush();
    }

}
