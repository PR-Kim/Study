using System;

namespace Dataformat1 {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine("Hello World!");

            int? var1 = 123;
            if (var1.HasValue) {
                Console.WriteLine("var1 has value");
            }
            else {
                Console.WriteLine("var1 is null");
            }


            string var2 = var1?.ToString();

            float var3 = Convert.ToInt32(var2);


        }
    }
}
