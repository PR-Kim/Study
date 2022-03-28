package Java;

import java.io.*;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Character> stk = new Stack<Character>();
        String res = "YES";
        for(int i = 0;i<input.length();i++)
        {
            if(input.charAt(i) == '(')
            {
                stk.push('(');
            }
            else
            {
                if(!stk.empty()) stk.pop();
                else
                {
                    res = "NO";
                    break;
                }
            }
        }
        if(!stk.empty()) res= "NO";
        bw.write(res);
        bw.flush();


    }

}
