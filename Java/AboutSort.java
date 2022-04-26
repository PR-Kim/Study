package Java;

import java.util.Arrays;
import java.util.Collections;

public class AboutSort {
    public static void main(String[] args){

        int[] a = {2,3,4,1,7,5,8,9,6};

        //오름차순 정렬
        Arrays.sort(a);

        //내림차순 정렬
        //래퍼클래스로 선언함 주목
        //기본 클래스 배열은 래퍼 클래스로 선언해야지 역순 정렬 사용 가능
        Integer b[] = {2,3,4,1,5,8,7,6};

        Arrays.sort(b, Collections.reverseOrder());

        //String배열
        //String은 기본 클래스 아님
        String[] c = {"apple","banana","orange"};
        Arrays.sort(c,Collections.reverseOrder());

        //일부분만 정렬
        //0에서 5까지 정렬
        Arrays.sort(a,0,5);

        //객체배열 정렬
        People[] peopleArr = {
                new People("a",14),
                new People("b",13),
                new People("c",15),
                new People("d",18)
        };

        Arrays.sort(peopleArr);
        //역순
        Arrays.sort(peopleArr,Collections.reverseOrder());

    }
}
class People implements Comparable<People> {

    private String name;
    private int age;

    public People(String name, int age){
        this.name = name;
        this.age= age;
    }

    public String print(){
        return name+"("+age+")";
    }

    @Override
    public int compareTo(People people) {
        // TODO Auto-generated method stub
        if (this.age < people.age) {
            return -1;
        } else if (this.age == people.age) {
            return 0;
        } else {
            return 1;
        }
    }
}