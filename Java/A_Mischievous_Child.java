package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//장난꾸러기
public class A_Mischievous_Child {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int cnt = Integer.parseInt(br.readLine());
       StringTokenizer st = new StringTokenizer(br.readLine());

      int[] orignArr = new int[cnt];
      int[] targetArr = new int[cnt];
      for(int i = 0;i<cnt;i++){
          int tmp = Integer.parseInt(st.nextToken());
          targetArr[i] = tmp;
          orignArr[i] = tmp;
      }
       Arrays.sort(targetArr);
      String res = "";
      for(int i=0;i<cnt;i++){
          if(orignArr[i] != targetArr[i])
              res += ((i+1) + " ");
      }

       bw.write(res);
       bw.flush();

   }

}
