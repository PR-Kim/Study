using System;

namespace Console_IO {
    class Program {
        static void Main(string[] args) {
            // 라인 입력
            string input = Console.ReadLine();

            Console.WriteLine(input);

            while (true) {
                ConsoleKeyInfo keyInfo;
                //true일 경우, 입력받은 키값 출력 안함 /  false일 경우, 입력받은 키값 출력
                keyInfo = Console.ReadKey(true);
                if (keyInfo.KeyChar == 'a')
                    Console.WriteLine("a가 입력됨");
                Console.Write(keyInfo.KeyChar);

                if (keyInfo.Key == ConsoleKey.Escape)
                    break;
            }
            

        }
    }
}
