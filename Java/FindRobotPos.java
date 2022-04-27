package Java;

import java.io.*;
import java.util.Arrays;

public class FindRobotPos {
    public static void main(String[] args) throws IOException {
        FindRobotPos f = new FindRobotPos();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String commands = br.readLine();
        int[] ret = f.solution(commands);

        bw.write(Arrays.toString(ret));
        bw.flush();
    }
    public int[] solution(String commands){
        int[] answer = {0,0};
        for(int i=0;i<commands.length();i++){
            if(commands.charAt(i) == 'U'){
                answer[1] = answer[1]+1;
            }
            else if(commands.charAt(i) == 'D'){
                answer[1] = answer[1]-1;
            }
            else if(commands.charAt(i) == 'R'){
                answer[0] = answer[0]+1;
            }
            else if(commands.charAt(i) == 'L'){
                answer[0] = answer[0]-1;
            }
        }

        return answer;
    }

}
