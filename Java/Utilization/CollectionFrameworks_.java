package Java;

import java.util.*;

public class CollectionFrameworks_ {
    public static void main(String[] args){
        ArrayList<Integer> arrayL = new ArrayList<>();
        arrayL.add(1);
        //특정 인덱스에 값 추가
        arrayL.add(1,10);
        // null 추가 가능
        arrayL.add(null);

        //삭제
        arrayL.remove(1);
        //모두 삭제
        arrayL.clear();

        //크기
        arrayL.size();
        //값 검색
        //case1.
        arrayL.contains(3);
        //case2
        //있으면 해당 인덱스 없으면 -1 반환
        arrayL.indexOf(3);
 ///////////////////////////////////////////////////////////////////////////////////////////

        //LinkedList

        LinkedList<Integer> linkedL = new LinkedList<>();
        linkedL.add(1);
        linkedL.add(2);
        //특정 인덱스에 값추가
        linkedL.add(3,10);
        //가장 앞에 값추가
        linkedL.addFirst(1);
        //가장 마지막에 값추가
        linkedL.addLast(5);

        //값 삭제
        linkedL.remove(1);
        //가장 앞에 값 삭제
        linkedL.removeFirst();
        //가장 뒤에 값 삭제
        linkedL.removeLast();

        //모두 삭제
        linkedL.clear();

        //사이즈
        linkedL.size();

        //검색
        //case1.
        linkedL.contains(1);

        //case2.
        linkedL.indexOf(1);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Set구조
        //Hash Set
        //중복없는 데이터 저장
        HashSet<Integer> hashS = new HashSet<>();
        hashS.add(1);
        hashS.add(2);
        //값 1 제거
        // 인덱스가 아님 주의
        hashS.remove(1);
        //모두 삭제
        hashS.clear();

        //크기
        hashS.size();

        //값 출력
        // List와 달리 직접 접근하는 방법 없음, iterator 사용해서 접근
        Iterator iter = hashS.iterator();
        while (iter.hasNext()){
            iter.next();
        }

        //검색
        hashS.contains(1);

 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Tree Set
        //이진 탐색 트리 구조로 이루어짐
        //검색에 높은 성능을 보임
        TreeSet<Integer> treeS = new TreeSet<>();
        treeS.add(1);
        treeS.add(2);
        treeS.add(3);

        //삭제
        //인덱스를 삭제하는게 아니라 해당 값을 삭제하는것임 주의
        treeS.remove(1);

        //모두 삭제
        //trees.clear();

        //사이즈
        treeS.size();

        //값출력
        //Iterator에 의한 접근이나, first(최소값), last(최대값), x보다 큰 값, x보다 작은값으로 접근 가능
        int aa = treeS.first();

        int bb = treeS.last();
        //1보다 큰 값중 가장 작읍 값, 없으면 null
        treeS.higher(1);
        //3보다 작은 값중 가장 큰 값, 없으면 null
        treeS.lower(3);

        Iterator iter2 = treeS.iterator();
        while (iter2.hasNext()){
            iter2.next();
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Map
        //키벨류 구조
        //Hash Map
        HashMap<String,Integer> hashM = new HashMap<>();
        //입력
        hashM.put("a",1);
        hashM.put("b",2);

        //삭제
        //키를 참고하여 값 삭제
        hashM.remove("a");

        //출력
        //키를 바탕으로 값 검색
        hashM.get("b");



    }


}
