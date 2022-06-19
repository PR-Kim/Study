package Java.Java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stream_Sample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("poo");
        names.add("foo");
        names.add("toby");

        // Stream은 데이터를 담고 있는 저장소는 아니다.
        // 여러 작업들을 병렬적으로 처리하기 위해 활용
        // 0개 또는 여러개의 중계 오퍼레이션과 종료 오퍼레이션으로 구성됨


        // 이건 stringStream이라는 새로운 변수를 선언하고 names를 담은거라 name 자체에는 영향이 없음
        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        // names를 찍어봐도 여전히 소문자로 출력됨
        System.out.println(names.toString());

        // 중계 오퍼레이터 vs 종료 오퍼레이터
        // 마지막에 종료형 오퍼레이터가 와야 앞에 있는 중계형 오퍼레이터들이 실행된다.
        // 중계 오퍼레이터
        // Stream을 리턴한다.
        // Lazy하다
        // filter, map, limit, skip, sorted....

        // 종료 오퍼레이터
        // Stream을 리턴하지 않는다.
        // collect, allMatch, count, forEach, min, max....



        //Stream API들
        List<Classes> springClasses = new ArrayList<>();
        springClasses.add(new Classes(1,"spring abc", false));
        springClasses.add(new Classes(2, "spring bdd",false));
        springClasses.add(new Classes(3,"spring mvc", false));
        springClasses.add(new Classes(4, "spring core", false));
        springClasses.add(new Classes(5, "rest api development",false));

        List<Classes> javaClasses = new ArrayList<>();
        javaClasses.add(new Classes(6,"The Java Test",true));
        javaClasses.add(new Classes(7,"The Java, Code manipulation", true));
        javaClasses.add(new Classes(8,"The Java 8 to 11",false));

        List<List<Classes>> pooEvents = new ArrayList<>();

        pooEvents.add(springClasses);
        pooEvents.add(javaClasses);


        System.out.println("spring으로 시작하는 수업들");
        springClasses.stream().filter(cs -> cs.title.startsWith("spring")).forEach(oc->System.out.println(oc.id));



        System.out.println("closed 안된 수업");
        //아래 두개 같은 의미
        springClasses.stream().filter(oc->!oc.closed).forEach(oc->System.out.println(oc.id));
        springClasses.stream().filter(Predicate.not(Classes::isClosed)).forEach(oc->System.out.println(oc.id));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(oc->oc.title).forEach(str -> System.out.println(str));

        System.out.println("두 수업에 들어있는 모든 수업 아이디 출력");
        pooEvents.stream().flatMap(Collection::stream).forEach(oc->System.out.println(oc.id));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개까지만 출력");
        //아래까지만 작성하면 iterate는 중계형 오퍼레이터라 아무런 결과 발생 x
        //Stream.iterate(10,i->i+1);
        Stream.iterate(10,i->i+1).skip(10).limit(10).forEach(System.out::println);
    }
}

class Classes{
    int id;
    String title;
    boolean closed;
    public Classes(int id, String title, boolean closed){
        this.id = id;
        this.title = title;
        closed = closed;
    }
    public boolean isClosed(){
        return this.closed;
    }
}
