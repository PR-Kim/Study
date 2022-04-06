using System;

namespace Inheritance_ {
    //상속은 하나의 클래스만 받을 수 있음
    // 인터페이스는 여러개 가질 수 있음.
    class Program {
        //추상클래스 / 상속을 통해서만 사용가능
        // 추상 메소드를 가짐
        // 상속받는 클래스는 상위 클래스의 모든 추상메소드 구현해야함
        // new를 통해 생성 불가
        //맴버 변수 및 메소드 내용이 적힌 메소드를 포함할 수 있음
        abstract class C {
            protected int a = 3;
            protected abstract void PrintCC();
        }
        class D : C {
            protected override void PrintCC() {
                Console.WriteLine("PrintCC");
            }
        }
        //인터페이스
        //멤버변수 못가짐
        //메소드 선언만 가능 (내용은 못가짐)
        //접근한정자 적지말고 메소드 선언하기
        interface IinterfaceClass {
            void PrintAS();
        }
        class F : IinterfaceClass {
            public void PrintAS() {
                Console.WriteLine("Interface!!");
            }
        }
        class A  {
            public A() {
                Console.WriteLine("생성자 A");
            }
            public void PrintPublic() {
                Console.WriteLine("Public");
            }
            private void PrintPrivate() {
                Console.WriteLine("Private");
            }
            protected void PrintProtected() {
                Console.WriteLine("Protected");
            }

            public  A(int a) {
                Console.WriteLine("input : " + a);
            }
            protected string name;
            
            // 오버라이드할 메소드는 virtual 선언
            public virtual void Override() {
                Console.WriteLine("before Override");
            }
        }
        class B : A{
            public B() {
                Console.WriteLine("생성자 B");
            }
            public void Print() {
                PrintProtected();
                PrintPublic();
                //Private는 접근불가
                //PrintPrivate();
            }
            // A의 생성자를 그대로 쓸 때
            public B(int a):base(a) {

            }

            public string name;

            //같은 이름의 부모,자식 변수에 접근할 때 부모 변수는 base.붙여서 접근
            public void PrintName() {
                Console.WriteLine("A Name : " + base.name + "/ B name : " + name);
            }

            //override라고 명시 후 오버라이드
            public  override void Override() {
                Console.WriteLine("after Override!!!");
            }
        }
        static void Main(string[] args) {
            // 생성자 A도 불리고, B도 불림
            B Test = new B();
            Test.PrintPublic();
            Test.Print();
            //Private와 Protected 접근 불가
            //Test.PrintPrivate();
            //Test.PrintProtected();
        }
    }
}
