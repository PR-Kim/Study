using System;


using System.Diagnostics; // External Program

namespace ExternalProgramExecute {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine(Environment.NewLine + "=================================================");
            Console.WriteLine("=============== External Program ================");
            Console.WriteLine("=================================================");

            ExternalProcess externalProcess = new ExternalProcess();
            externalProcess.SetExternalProcess("cmd.exe");

            string res1 = externalProcess.Execute("/c ipconfig /all");
            Console.WriteLine(res1);

            ExternalProcess externalProcess2 = new ExternalProcess();
            externalProcess2.SetExternalProcess("표준입력 받는 외부 프로그램");
            string res2 = externalProcess2.Execute();
            Console.WriteLine(res2);
        }
    }
    public class ExternalProcess {
        ProcessStartInfo ProcessInfo;
        public void SetExternalProcess(string ProcessName) {
            ProcessInfo = new ProcessStartInfo();
            ProcessInfo.FileName = ProcessName;
            ProcessInfo.CreateNoWindow = true;
            ProcessInfo.UseShellExecute = false;
            ProcessInfo.RedirectStandardInput = true;
            ProcessInfo.RedirectStandardOutput = true;
            ProcessInfo.RedirectStandardError = true;
        }
        public string Execute(string arguments) {
            string result = string.Empty;
            try {
                using (Process process = new Process()) {
                    ProcessInfo.Arguments = arguments;
                    process.StartInfo = ProcessInfo;
                    process.Start();

                    result = process.StandardOutput.ReadToEnd();
                    process.WaitForExit();
                }
            }
            catch (Exception e) {
                Console.WriteLine(e.Message);
            }

            return result;
        }

        public string Execute() {
            string result = string.Empty;
            try {
                using (Process process = new Process()) {
                    process.StartInfo = ProcessInfo;
                    process.Start();

                    process.StandardInput.WriteLine("StandardInput");
                    process.StandardInput.Flush();
                    process.Close();
                }
            }
            catch (Exception e) {
                Console.WriteLine(e.Message);
            }

            return result;
        }
    }
}
