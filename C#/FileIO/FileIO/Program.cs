using System;
using System.IO;

namespace FileIO {
    class Program {
        static void Main(string[] args) {
            //파일 생성 & 쓰기
            // case1
            FileStream fs = new FileStream("test.txt", FileMode.Create);
            StreamWriter sw = new StreamWriter(fs);
            int val1 = 1;
            string val2 = "sgerg";
            sw.WriteLine(val1);
            sw.Write(val2);
            sw.Close();

            // case2
            using (StreamWriter sw2 = new StreamWriter(new FileStream("test2.txt", FileMode.Create))) {
                sw2.Write(val2);
                sw2.Close();
            }

            // case3
            //쓰기만 가능
            StreamWriter sw3 = new StreamWriter("test3.txt");
            sw3.WriteLine(val1);
            sw3.Close();


            // 읽기
            //case 1
            FileStream fs2 = new FileStream("test.txt", FileMode.Open, FileAccess.Read);
            StreamReader sr = new StreamReader(fs2);

            int val3 = int.Parse(sr.ReadLine());
            string val4 = sr.ReadLine();
            sr.Close();

            //case2
            using (StreamReader sr2 = new StreamReader(new FileStream("test.txt", FileMode.Open))) {
                int val5 = int.Parse(sr2.ReadLine());
            }

            //case3
            //읽기만가능
            StreamReader sr3 = new StreamReader("test.txt");
            int val6 = int.Parse(sr3.ReadLine());
            sr3.Close();



            //String Split
            string str = "국어 : 90 영어: 100 수학:83";
            string[] str_Split = str.Split(new char[] { ' ' });
            string[] str_Split2 = str.Split(' ');

        }
    }
}
