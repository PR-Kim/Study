using System;
using System.IO;
using System.Net.Sockets;
using System.Text;

namespace SocketClientSample {
    class Program {
        static void Main(string[] args) {
            Client.Echo();
        }
    }
    class Client {
        public static void Echo() {
            TcpClient client = new TcpClient("127.0.0.1", 9999);
            NetworkStream networksteam = client.GetStream();
            StreamReader streamReader = new StreamReader(networksteam, Encoding.UTF8);
            StreamWriter streamWriter = new StreamWriter(networksteam, Encoding.UTF8);

            try {
                string cmd = string.Empty;
                while((cmd = Console.ReadLine())!= null) {
                    streamWriter.WriteLine(cmd);
                    streamWriter.Flush();

                    string serverMsg = streamReader.ReadLine();
                    Console.WriteLine(serverMsg);
                }
            }
            catch(Exception e) {
                Console.WriteLine(e);
            }
            finally {
                client.Close();
                networksteam.Close();
                streamReader.Close();
                streamWriter.Close();
            }
        }
    }
}
