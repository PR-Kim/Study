using System;
using System.Threading;

namespace Thread_ {
    class Program {
        static void Main(string[] args) {
            // 1
            Thread th = new Thread(new ThreadStart(Func));
            // 2
            ThreadStart thstart = new ThreadStart(Func);
            Thread th1 = new Thread(thstart);


            int i = 5;
            Thread th2 = new Thread(new ParameterizedThreadStart(ParameterFunc));

            th.Start();
            th2.Start(i);
        }
        static void Func() {
            Console.WriteLine("Thread call!!");
        }

        static void ParameterFunc(object obj) {
            for (int i = 0; i < (int)obj; i++) {
                Console.WriteLine("Parameter Thread Call!! {0}", i);
            } 
        }
    }
}
