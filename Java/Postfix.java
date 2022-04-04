package Java;

import java.io.*;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stk = new Stack<>();

        String input = br.readLine();

        for(int i =0;i<input.length();i++)
        {
            if(Character.isDigit(input.charAt(i)))
            {
                stk.push(input.charAt(i)-'0');
            }
            else
            {
                char tmp = input.charAt(i);
                int a = stk.pop();
                int b = stk.pop();

                if(tmp == '*') stk.push(a*b);
                else if(tmp == '/') stk.push(b/a);
                else if(tmp == '+') stk.push(a+b);
                else stk.push(b-a);
            }
        }
        int res = stk.pop();
        bw.write(res + "");
        bw.flush();
    }

}
