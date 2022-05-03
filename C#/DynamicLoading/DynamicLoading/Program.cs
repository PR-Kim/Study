using System;
using System.Reflection; // Dynamic Loading

using System.IO; // Directory

namespace DynamicLoading {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine(Environment.NewLine + "=================================================");
            Console.WriteLine("================ Dynamic Loading ================");
            Console.WriteLine("=================================================");

            Assembly asm = Assembly.LoadFrom(@"I:\Java_Study\Study\C#\DynamicLoading\DynamicLoading\Reference-dll.dll"); // 방법 1

            string Project_Path = Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName; // 프로젝트 경로
            Console.WriteLine(Project_Path);
            // Assembly asm = Assembly.LoadFrom(Project_Path + @"\Reference-dll"); // 방법 2

            Type[] types = asm.GetExportedTypes();
            string classFullName = string.Empty;
            foreach(Type type in types) {
                Console.WriteLine("type : " + type.FullName);
                classFullName = type.FullName;
            }
            dynamic obj = Activator.CreateInstance(types[0]);

            obj.Sample();

        }
    }
}
