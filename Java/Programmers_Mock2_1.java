package Java;

public class Programmers_Mock2_1 {
    public static void main(String[] args){
        Programmers_Mock2_1 p = new Programmers_Mock2_1();
        int[] number = new int[]{1,2,3,1,4};
        System.out.println(p.solution(number));
    }
    public int solution(int[] number){
        int answer = 0;
        for(int i =0;i<number.length-2;i++){
            for(int j =i+1;j<number.length-1;j++){
                for(int k=j+1;k<number.length;k++){
                    System.out.println("i : " + i + " / j : " + j + " / k : " + k);
                    if(number[i] + number[j] + number[k] == 0){
                        System.out.println("number[i] : " + number[i] + " / number[j] : " + number[j] + " / number[k] : " + number[k]);
                        answer+=1;
                    }
                }
            }
        }
        return answer;
    }

}
