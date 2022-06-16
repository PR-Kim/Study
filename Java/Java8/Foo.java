package Java.Java8;


import java.util.Arrays;
import java.util.Comparator;

public class Foo implements Interf {
    public String name;
    @Override
    public String printName() {
        return name;
    }

    //함수형 인터페이스는 아래와 같이 선언하여 사용할 수 있다.
    Oper_IF intf = (a,b) -> a+b;

    int a= intf.add(1,2);



    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5,6};
        Arrays.sort(arr,(a,b)->{
            if(a<b) return 1;
            else if(a>b) return -1;
            else return 0;
        });
        Arrays.sort(arr,Comparator.reverseOrder());
    }
}
