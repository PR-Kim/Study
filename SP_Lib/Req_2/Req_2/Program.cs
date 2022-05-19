using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// 콘솔 입력을 통해 큐 생성 및 큐에 메세지 삽입
namespace Req_2 {
    class Program {
        static void Main(string[] args) {
            Dictionary<string, Queue<string>> dictQue = new Dictionary<string, Queue<string>>();
            Dictionary<string, int> dictSize = new Dictionary<string, int>();

            string input;
            while((input = Console.ReadLine()) != "") {
                string[] inp = input.Split(' ');
                if (inp[0].Equals("CREATE")) {
                    if (dictQue.ContainsKey(inp[1])) {
                        Console.WriteLine("Queue Exist");
                    }
                    else {
                        dictQue.Add(inp[1], new Queue<string>());
                        dictSize.Add(inp[1], int.Parse(inp[2]));
                    }
                }
                else if (inp[0].Equals("SEND")) {
                    if (dictQue[inp[1]].Count >= dictSize[inp[1]]) {
                        Console.WriteLine("Queue Full");
                    }
                    else {
                        dictQue[inp[1]].Enqueue(inp[2]);
                    }
                }
                else if (inp[0].Equals("RECEIVE")) {
                    if (dictQue[inp[1]].Count > 0) {
                        Console.WriteLine(dictQue[inp[1]].Dequeue());
                    }
                }
            }


        }
    }
}
