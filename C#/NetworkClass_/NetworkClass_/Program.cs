using System;
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace NetworkClass_ {
    class Program {
        static void Main(string[] args) {
            string Address = Console.ReadLine();
            IPAddress IP = IPAddress.Parse(Address);


            //도메인 명에 다양한 IP 주소가 묶여 있을수 있으므로 도메인명으로 IP갖고 올때는
            IPAddress[] IPs = Dns.GetHostAddresses("www.naver.com");
            foreach (IPAddress a in IPs) {
                // Someting
            }


            // 도메인의 ip주소들과 호스트 이름 정보 저장
            IPHostEntry HostInfo = Dns.GetHostEntry("www.naver.com");
            foreach(IPAddress d in  HostInfo.AddressList) {
                // Do something
            }

            // ip정보와 포트 정보를 갖는 Endpoint 정보 생성
            IPAddress ip = IPAddress.Parse("127.0.0.1");
            int port = 8080;
            IPEndPoint endpointInfo = new IPEndPoint(ip, port);


            //Tcp Listener 생성
            TcpListener tcpListener = new TcpListener(ip,8080);
            //혹은 IP 생략 가능
           // TcpListener tcpListener = new TcpListener(8080);

            //Tcp Listener 시작
            tcpListener.Start();
            //대기상태 시작
            TcpClient tcpCli = tcpListener.AcceptTcpClient();

            NetworkStream ns = tcpCli.GetStream();
            byte[] ReceiveMsg = new byte[100];
            ns.Read(ReceiveMsg, 0, 100);
            string strMsg = Encoding.ASCII.GetString(ReceiveMsg);

            Console.WriteLine(strMsg);

            string EchoMsg = "Hi~~";
            byte[] sendMsg = Encoding.ASCII.GetBytes(EchoMsg);
            
            //쓰는 방법 1,.
            ns.Write(sendMsg, 0, sendMsg.Length);


            //쓰는 방법 2.
            using(StreamWriter sw = new StreamWriter(ns)) {
                sw.AutoFlush = true;

                sw.WriteLine("HI");
                sw.WriteLine(3.1334f);
                sw.WriteLine(false);

            }

            // 쓰는 방법 3.
            using(BinaryWriter bw = new BinaryWriter(ns)) {
                bool YesNo = false;
                int Num = 13;
                float Pi = 3.14f;
                string Msg = "Message";

                bw.Write(YesNo);
                bw.Write(Num);
                bw.Write(Pi);
                bw.Write(Msg);
            }
            ns.Close();

            tcpCli.Close();
            // 클라이언트가 붙으면 stop이 호출됨 클라이언트 붙기 전에는 호출 X
            tcpListener.Stop();











            //클라이언트 파트
            TcpClient tcpCli2 = new TcpClient("192.168.0.9", 7);
            if (tcpCli2.Connected) {
                Console.WriteLine("클라이언트 접속 성공");
                NetworkStream ns2 = tcpCli2.GetStream();
                string msg = "Hello Server";
                byte[] sendMsg2 = Encoding.ASCII.GetBytes(msg);
                ns.Write(sendMsg2, 0, sendMsg2.Length);

                
                byte[] recieveByteMsg = new byte[100];
                //읽는 방법 1.
                ns.Read(recieveByteMsg, 0, 100);

                //읽는 방법 2.
                using(StreamReader sr = new StreamReader(ns)) {
                    String str = sr.ReadLine();

                    sr.ReadLine();

                }

                // 읽는 방법 3.
                using(BinaryReader br = new BinaryReader(ns)) {
                    bool Yesno = br.ReadBoolean();
                    int num = br.ReadInt32();
                    float pi = br.ReadSingle();
                    string mmsg = br.ReadString();

                }

                string recieveM = Encoding.ASCII.GetString(recieveByteMsg);
                Console.WriteLine(recieveM);
                ns.Close();
            }
            else {

            }
            tcpCli2.Close();

        }
    }
}
