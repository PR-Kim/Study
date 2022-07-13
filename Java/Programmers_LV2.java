package Java;

import java.io.IOException;

public class Programmers_Basic2 {
    public static void main(String[] args)throws IOException{

    }
    public static String solution(int[] numbers, String hand){
        String answer = "";
        KeyPad leftHand = new KeyPad(3,0);
        KeyPad rightHand = new KeyPad(3,2);

        KeyPad[] pad = new KeyPad[10];
        pad[0] = new KeyPad(3,1);
        pad[1] = new KeyPad(0,0);
        pad[2] = new KeyPad(0,1);
        pad[3] = new KeyPad(0,2);
        pad[4] = new KeyPad(1,0);
        pad[5] = new KeyPad(1,1);
        pad[6] = new KeyPad(1,2);
        pad[7] = new KeyPad(2,0);
        pad[8] = new KeyPad(2,1);
        pad[9] = new KeyPad(2,2);
        for(int i =0;i<numbers.length;i++){
            int tmp = numbers[i];
            if(tmp == 1 || tmp == 4 || tmp == 7){
                leftHand.row = pad[tmp].row;
                leftHand.col = pad[tmp].col;
                answer+= 'L';
            }
            else if(tmp==3 || tmp == 6 || tmp == 9){
                rightHand.row = pad[tmp].row;
                rightHand.col = pad[tmp].col;
                answer+= 'R';
            }
            else{
                // 왼손이 가깝
               if(pad[tmp].distance(leftHand)<pad[tmp].distance(rightHand)){
                   leftHand.row = pad[tmp].row;
                   leftHand.col = pad[tmp].col;
                   answer+= 'L';
               }
               else if(pad[tmp].distance(leftHand)>pad[tmp].distance(rightHand)){
                   rightHand.row = pad[tmp].row;
                   rightHand.col = pad[tmp].col;
                   answer+='R';
               }
               else{
                   if(hand.equals("right")){
                       rightHand.row = pad[tmp].row;
                       rightHand.col = pad[tmp].col;
                       answer+='R';
                   }
                   else{
                       leftHand.row = pad[tmp].row;
                       leftHand.col = pad[tmp].col;
                       answer+= 'L';
                   }
               }
            }
        }

        return answer;
    }
}
class KeyPad{
    int row;
    int col;
    public KeyPad(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int distance(KeyPad other){
        return Math.abs(this.row- other.row) + Math.abs(this.col-other.col);
    }
}
