using System;
using System.IO;
using System.Collections;
using System.Collections.Generic;
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



            //파일 전체 읽어서 string List로 받아오기
            //List 사용위해서 
            //using System.Collections;
            //using System.Collections.Generic;
            //두가지 선언 필수
            List<string> contents = new List<string>();
            string filePath = "test.txt";
            using (StreamReader sr2 = new StreamReader(new FileStream(filePath, FileMode.Open))) {
                string line;
                while((line = sr2.ReadLine())!=null){
                     contents.Add(line);                
                }
            }

            //string List안에 들어있는 스트링 수 만큼 파일에 쓰기

            string filePath2 = "test.txt";
            List<string> writeData = new List<string>();
            writeData.Add("geasdfsdf");
            writeData.Add("dsefxczv");
             using (StreamWriter sw2 = new StreamWriter(new FileStream(filePath2, FileMode.Create))) {
                foreach(string str in writeData){
                    sw2.WriteLine(str);
                }
            }


             //특정 파일 찾기
             string target = "test.txt";
            // 현재 프로젝트 경로
             string Project_Path = Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName;
            // 타겟 파일 경로
            string targetPath = Project_Path;
            // 타겟 파일 경로에 있는 모든 파일 이름들을 갖고 온 후(경로 포함)
            string[] files = Directory.GetFiles(targetPath,"",SearchOption.AllDirectories);
            // 해당 파일들에 대해 타겟파일과 이름이 같은 파일 출력
            foreach(string str in files){
                string[] paths = str.Split("\\");
                if(target == paths[paths.Length-1]){
                    Console.WriteLine("Target Location : " + str);
                }
            }


            //String Split
            string str = "국어 : 90 영어: 100 수학:83";
            string[] str_Split = str.Split(new char[] { ' ' });
            string[] str_Split2 = str.Split(' ');



        }
    }
}
