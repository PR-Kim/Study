package Java;

import java.io.*;

public class CurriculumSetting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] required = br.readLine().toCharArray();
        char[] selected = br.readLine().toCharArray();
        String res = "NO";
        int reqIdx = 0;
        //int selIdx = 0;
        for(int i=0;i<selected.length;i++)
        {
            if(required[reqIdx] == selected[i])
            {
                reqIdx+=1;
            }
            if(reqIdx==required.length){
                res = "YES";
                break;
            }
        }
        bw.write(res);
        bw.flush();

    }

}
