using System;
using System.Collections;
using System.Collections.Generic;

using System.Linq;
namespace ListwithSort {
    class Program {
        static void Main(string[] args) {
            List<User> UserList = new List<User>();
            UserList.Add(new User("김", 13, 60.0));
            UserList.Add(new User("김", 23, 80.0));
            UserList.Add(new User("김", 23, 70.0));
            UserList.Add(new User("이", 17, 60.0));
            UserList.Add(new User("이", 37, 70.0));
            UserList.Add(new User("이", 27, 80.0));
            UserList.Add(new User("박", 34, 60.0));
            UserList.Add(new User("박", 64, 70.0));
            UserList.Add(new User("박", 54, 80.0));

            Console.WriteLine(Environment.NewLine + " === 이름순 정렬 ===");
            // OrderBy 정렬을 위해서는
            // using System.Linq;
            // 필수
            List<User> SortedByName = UserList.OrderBy(x => x.name).ToList();
            PrintUserList(SortedByName);


            Console.WriteLine(Environment.NewLine + " === 나이순 정렬 ===");
            List<User> SortedByAge = UserList.OrderBy(x => x.age).ToList();
            PrintUserList(SortedByAge);


            Console.WriteLine(Environment.NewLine + " === 몸무게순 정렬 ===");
            List<User> SortedByWeight = UserList.OrderBy(x => x.weight).ToList();
            PrintUserList(SortedByWeight);

            Console.WriteLine(Environment.NewLine + " === 이름순 정렬 후 -> 나이순 정렬 ( 2 key ) ===");
            List<User> SortedByNameAge = UserList.OrderBy(x => x.name).ThenBy(x => x.age).ToList();
            PrintUserList(SortedByNameAge);

            Console.WriteLine(Environment.NewLine + " === 이름순 정렬 후 -> 나이순 정렬 후 -> 몸무게순 정렬 ( 3 key ) ===");
            List<User> SortedByNameAgeWeight = UserList.OrderBy(x => x.name).ThenBy(x => x.age).ThenBy(x => x.weight).ToList();
            PrintUserList(SortedByNameAgeWeight);

        }
        static void PrintUserList(List<User> list) {
            foreach (User data in list) {
                Console.WriteLine(data);
            }
        }
    }
   
    class User {
        public string name;
        public int age;
        public double weight;

        public User(string name, int age, double weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
        public override string ToString() {
            return $"이름 : {name} / 나이 : {age} / 몸무게 {weight}";
        }
    }
}
