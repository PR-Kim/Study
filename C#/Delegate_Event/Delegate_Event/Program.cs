using System;

namespace Delegate_Event {
    delegate void DelegateType();
    delegate void DelegateType2(String Message );
    class A {
        public void PrintA() {
            Console.WriteLine("PrintA");
        }
        public void PrintB() {
            Console.WriteLine("PrintB");
        }
    }

    class B {
        public event DelegateType2 eventHandler_;
        public void Func(string Msg) {
            eventHandler_(Msg);
        }
    }

    class C {
        public void PrintC(string msg) {
            Console.WriteLine("PrintC" +msg);
        }
        public void PrintD(string msg) {
            Console.WriteLine("PrintD" + msg);
        }
    }
    
    class Program {
        static void Main(string[] args) {
            // Delegate는 메소드 참조형
            // 복수 또는 단일 메소드를 호출 (같은 형식이어야 한다.)
            A Test = new A();
           
            DelegateType delFunc = Test.PrintA;
            delFunc += Test.PrintB;
            delFunc();


            //Event
            // 델리게이트 기반
            // 이벤트는 메소드 안에서만 사용가능
            B Test2 = new B();
            C Test3 = new C();
            Test2.eventHandler_ += new DelegateType2(Test3.PrintC);
            Test2.eventHandler_ += new DelegateType2(Test3.PrintD);
            Test2.Func("Good");

        }
    }
}
