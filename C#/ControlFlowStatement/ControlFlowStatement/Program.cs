using System;
using System.Collections;

namespace ControlFlowStatement {
    class Program {
        static void Main(string[] args) {
            int[] Array = { 1, 2, 3, 4, 5, 6 };
            //foreach는 읽기 전용 foreach(데이터타입 변수 in 배열명이나컬렉션명)
            foreach(int i in Array) {
                Console.WriteLine(i);
            }

            ArrayList lst = new ArrayList();
            lst.Add(1);
            lst.Add(2);

        }
    }
}
