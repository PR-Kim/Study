package Java;

import java.io.*;
import java.util.Stack;

public class PipeCutting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Character> stk = new Stack<>();
        int pipeNum = 0;
        int res = 0;
        char exChar = '-';
        for(int i =0;i<input.length();i++)
        {
            if(input.charAt(i) == '(')
            {
                if(input.charAt(i+1) != ')')
                {
                    pipeNum +=1;
                    res +=1;
                }
                stk.push(input.charAt(i));
                exChar=input.charAt(i);
            }
            else
            {
                stk.pop();
                if(exChar=='(') // 레이저
                {
                    res += pipeNum;
                }
                else // 파이프 끝
                {
                    pipeNum -=1;
                }
                exChar = input.charAt(i);
            }
        }
        bw.write(res + "");
        bw.flush();
    }
}
