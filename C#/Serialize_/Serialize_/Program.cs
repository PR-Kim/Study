using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace Serialize_ {
    [Serializable]
    struct Data {
        public int var1;
        public float var2;
       
        public string str1;
        //NonSerialized 붙어있는 변수는 시리얼라이즈해서 저장할 경우 포함이 안됨
        [NonSerialized]
        public string str2;
    }
    class Program {
        static void Main(string[] args) {
            Data[] Data = new Data[2];
            Data[0].var1 = 1;
            Data[0].var2 = 0.5f;
            Data[0].str1 = "Test1";
            Data[0].str2 = "NonTest1";
            Data[1].var1 = 2;
            Data[1].var2 = 1.5f;
            Data[1].str1 = "Test2";
            Data[1].str2 = "NonTest2";

            //직렬화해서 Binary형식으로 데이터 저장
            using (FileStream fs1 = new FileStream("test.dat", FileMode.Create)){
                BinaryFormatter bf = new BinaryFormatter();
                bf.Serialize(fs1, Data);
            }
            //직렬화된 데이터 Binary형식으로 읽어와서 Deserialize한 뒤 Data[] 형식에 대입
            Data[] ResultData;
            using(FileStream fs2 = new FileStream("test.dat", FileMode.Open)) {
                BinaryFormatter bf2 = new BinaryFormatter();
                ResultData = (Data[])bf2.Deserialize(fs2);
            }

            //using System.Collections.Generic;
            List<int> aa = new List<int>();
            ArrayList bb = new ArrayList();

        }
    }
}
