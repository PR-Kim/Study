package Java;

import java.util.HashMap;

public class ProgrammersExam_3 {
    public static void main(String[] args) {
        ProgrammersExam_3 p = new ProgrammersExam_3();

       String[] want = new String[]{"banana","apple","rice","pork","pot"};
        //String[] want = new String[]{"apple"};
        int[] number = new int[]{3,2,2,2,1};
        //int[] number = new int[]{10};
        String[] discount = new String[]{"chicken","apple","apple","banana","rice","apple","pork","banana","pork","rice","pot","banana","apple","banana"};
        //String[] discount = new String[]{"banana","banana","banana","banana","banana","banana","banana","banana","banana","banana","banana","banana"};
        System.out.println(p.solution(want,number,discount));
    }
    public int solution(String[] want, int[] number, String[] discount){
        int answer = 0;
        int startIdx =0;
        int lastIdx =0;
        int spendTime = 0;
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i =0;i<want.length;i++){
            hash.put(want[i],number[i]);
        }
        while (lastIdx<discount.length){
            spendTime+=1;
            //System.out.println(discount[lastIdx] + "spendTime : " + spendTime);
            if(hash.containsKey(discount[lastIdx])){
                if(hash.get(discount[lastIdx])>1){
                    hash.put(discount[lastIdx],hash.get(discount[lastIdx])-1);
                    //spendTime+=1;
                }
                else{
                    hash.remove(discount[lastIdx]);
                }
                lastIdx+=1;

            }
            else{
                //if(spendTime==9){
                 ////   hash.put(discount[startIdx],1);
                 //   startIdx +=1;
               // }
               // else {
                    for(int i =0;i<want.length;i++){
                        hash.put(want[i],number[i]);
                    }
                    spendTime=0;
                    startIdx +=1;
                    lastIdx = startIdx;
               // }

            }
            if(hash.isEmpty())
            {
                answer += 1;
                for(int i =0;i<want.length;i++){
                    hash.put(want[i],number[i]);
                }
                startIdx +=1;
                lastIdx = startIdx;
                //break;
            }
        }
        return answer;
    }
}
