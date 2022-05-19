using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// 콘솔 명령어를 이용한 큐 구현
namespace Req_1 {
    class Program {
        static void Main(string[] args) {
            Queue<string> que = new Queue<string>();
            string input;
            while((input = Console.ReadLine()) != "LGCNS") {
                string[] inp = input.Split(' ');
                if (inp[0].Equals("SEND")) {
                    que.Enqueue(inp[1]);
                }
                else if (inp[0].Equals("RECEIVE")) {
                    if(que.Count>0)
                    Console.WriteLine(que.Dequeue());
                }
            }

        }
    }
}
