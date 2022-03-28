using System;

namespace CustomDataType {

    // 구조체
    public struct myStruct {
        //const나 static 형태의 변수만 초기화 가능
        public const float PI = 3.14f;
        public static int t = 4;
        
        /*
         public int k = 3; 불가능

         */
        //아래와 같이 생성자를 사용한 초기화는 가능
        public int age;
        public myStruct(int age) {
            this.age = age;
        }

        //***구조체 안에 생성자는 매개변수 필수

       
    }

    public class myClass {
        public int age;
    }

    // 열거형
    enum day { Sun = 0,Mon = 1, Tue = 2};
    enum day2 { Sun,Mon,Tue};
    class Program {
        static void Main(string[] args) {
            //사용 가능
            Console.WriteLine(myStruct.PI);

            // myStruct.age = 2;  불가능
            myStruct st1 = new myStruct();
            //위처럼 생성하면 age에는 0이 들어감

            Console.WriteLine(st1.age);

            myStruct st2 = new myStruct(33);

            Console.WriteLine(st2.age);

            // 구조체 대입은 값 복사, 클래스 대입은 참조 복사//////
            //
            myStruct one = new myStruct(10);
            myStruct two = one;
            two.age = 20;
            Console.WriteLine(one.age + " ? " + two.age);
            myClass three = new myClass();
            three.age = 30;
            myClass four = three;
            four.age = 40;
            Console.WriteLine(three.age + " ? " + four.age);
        }

        // string 대입이나 class, 배열 대입은 참조형 + interface, delegate
    }
}
