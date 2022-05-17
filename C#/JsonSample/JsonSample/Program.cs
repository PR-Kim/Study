using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace JsonSample {
    class Program {
        static void Main(string[] args) {
            string json = "" +
                "{ " +
                "  'squadName': 'Super hero squad', " +
                "  'homeTown': 'Metro City', " +
                "  'active': true, " +
                "  'members': [ " +
                "               { 'name': 'Molecule Man', " +
                "                 'age': 29, " +
                "                 'powers': [ " +
                "                             'Radiation resistance', " +
                "                             'Turning tiny', " +
                "                           ] " +
                "               }, " +
                "               { " +
                "                 'name': 'Madame Uppercut', " +
                "                 'age': 39, " +
                "                 'powers': [ " +
                "                             'Million tonne punch', " +
                "                           ] " +
                "               }, " +
                "               { " +
                "                 'name': 'Eternal Flame', " +
                "                 'age': 1000000, " +
                "                 'powers': [ " +
                "                             'Immortality', " +
                "                             'Heat Immunity', " +
                "                           ] " +
                "               } " +
                "             ] " +
                "}";

            JObject jObject = JObject.Parse(json);

            Console.WriteLine(jObject.ToString());

            //Json데이터의 특정 데이터 출력
            Console.WriteLine(jObject["members"][0]["powers"][0]);

            // Json 하위 객체인 members 배열의 name값들을출력
            JToken jToken = jObject["members"];
            foreach(JToken members in jToken) {
                Console.WriteLine(members["name"]);
            }



            // 역직렬화
            // json 데이터를 클래스에 파싱
            Root rootObj = JsonConvert.DeserializeObject<Root>(json);
            Console.WriteLine(rootObj.members[0].powers[0]);

            foreach(Members member in rootObj.members) {
                Console.WriteLine(member.name);
            }


            //직렬화
            //클래스를 JSON 형식 스트링으로 직렬화
            string serializeResult = JsonConvert.SerializeObject(rootObj);

            Console.WriteLine(serializeResult);



            // json 데이터 새로 생성
            var json_ = new JObject();
            json_.Add("id", "Luna");
            json_.Add("name", "Silver");
            json_.Add("age", "29");

            // 키를 이용해 삭제
            //json_.Remove("name");

            Console.WriteLine(json_.ToString());


            // 다른 클래스 object로 부터 바로 생성
            var json3 = JObject.FromObject(rootObj);
            Console.WriteLine(json3.ToString());


            // 무명 형식으로 생성
            var json4 = JObject.FromObject(new { id = "J01", name = "June", age = 23 });

            Console.WriteLine(json4.ToString());
            /*
               {
                "id": "J01",
                "name": "June",
                "age": 23
                }   
             */

        }
    }
    public class Root {
        public string squadName;
        public string homeTown;
        public string active;
        public List<Members> members;
    }
    public class Members {
        public string name;
        public string age;
        public List<string> powers;
    }
}
