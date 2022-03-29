package Java;

import java.io.*;
import java.util.Stack;

public class Bracket_2 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Stack<Character> stk = new Stack<>();
        String res = "";
        for(int i =0;i<input.length();i++)
        {
            if(input.charAt(i) == '(')
            {
                stk.push(input.charAt(i));
            }
            else if(input.charAt(i) == ')'){
                stk.pop();
            }
            else
            {
                if(stk.empty())
                {
                    res += input.charAt(i);
                }
            }
        }
        bw.write(res);
        bw.flush();
    }
}
