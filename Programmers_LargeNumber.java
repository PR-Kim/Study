public class Programmers_LargeNumber {
    public static void main(String[] args){
        Programmers_LargeNumber p =new Programmers_LargeNumber();
        String str = "1924";
        int k = 2;
        System.out.println(p.solution(str,k));
    }
    public String solution(String str, int k){
        String answer = "";
        int len = str.length()-k;
        int startIdx = 0;
        while (answer.length()<len){
            int maxIdx = startIdx;
            for(int i = startIdx;i<(k+answer.length()+1);i++){
                if(str.charAt(i)-'0'>str.charAt(maxIdx)-'0'){
                    maxIdx = i;
                    if(str.charAt(i)-'0' == 9)break;


                }
            }
            answer += str.charAt(maxIdx);
            startIdx = maxIdx+1;
        }
        return answer;
    }
}
