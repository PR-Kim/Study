package Java;

import java.util.Stack;

public class ProgrammersExam_2 {
    public static void main(String[] args){
        ProgrammersExam_2 p = new ProgrammersExam_2();
        System.out.println(p.solution(new int[]{5,4,3,2,1}));
    }
    public int solution(int[] order){
        int answer = 0;
        if(order.length==1) return 1;
        int[] tmp = new int[order.length];
        for(int i =0;i<order.length;i++){
            tmp[order[i]-1] = i+1;
        }
        Stack<Integer> mainCon = new Stack<>();
        Stack<Integer> subCon = new Stack<>();
        for(int i =tmp.length-1;i>-1;i--){
            mainCon.push(tmp[i]);
        }
        int s = -1;
        int findIdx = 1;
        while (!mainCon.isEmpty() || !subCon.isEmpty()){
            if(!mainCon.isEmpty() &&mainCon.peek()!= findIdx && (subCon.isEmpty() ||subCon.peek()!= findIdx)  ){
                subCon.push(mainCon.pop());
                //if(!subCon.isEmpty())
                    //System.out.println("subConPeek : " + subCon.peek());
            }
            else if(!mainCon.isEmpty() && mainCon.peek()== findIdx){
                mainCon.pop();
                //if(!mainCon.isEmpty())
                //System.out.println("mainCon : " + mainCon.peek());
                findIdx+=1;
                answer+=1;
            }
            else if(!subCon.isEmpty()&& subCon.peek() == findIdx){
                subCon.pop();
                //if(!subCon.isEmpty())
               //System.out.println("subCon : " + subCon.peek());
                findIdx+=1;
                answer+=1;
            }
            else{
                break;
            }

        }
        return answer;
    }
}
