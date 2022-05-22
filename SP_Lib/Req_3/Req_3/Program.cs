using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json.Linq;

namespace Req_3 {

    class Program {

        static void Main(string[] args) {
            HttpServer server = new HttpServer();
            server.Run();
        }
    }
    class HttpServer {
        HttpListener Listener;

        public static Dictionary<string, List<string>> dictQue = new Dictionary<string, List<string>>();
        public static Dictionary<string, int> dictSize = new Dictionary<string, int>();

        public static Dictionary<int, string> sendedQueName = new Dictionary<int, string>();
        public static Dictionary<int, string> sendedMsg = new Dictionary<int, string>();
        public static int MsgID = 0;
        public HttpServer() {
            Listener = new HttpListener();
            Listener.Prefixes.Add("http://127.0.0.1:8080/");
        }
        public void Run() {
            Listener.Start();
            while (true) {
                var ctx = Listener.GetContext();

                //Using Task
                Task.Factory.StartNew(() => {
                    Route.TaskRun(ctx);
                });


                // Using Thread
                //Thread th = new Thread(Route.TreadRun);
                //th.Start(ctx);
            }
        }
    }

    class Route {
        public Route() {

        }
        public static Task TaskRun(HttpListenerContext ctx) {
            Console.WriteLine("Using Task");
            if (ctx.Request.HttpMethod == "GET") {
                Console.WriteLine("GET REQ!");
                GET.execute(ctx);
            }
            else if (ctx.Request.HttpMethod == "POST") {
                Console.WriteLine("POST REQ!");
                POST.excute(ctx);
            }
            return Task.CompletedTask;
        }

        public static void TreadRun(object parameter) {
            Console.WriteLine("Using Thread");
            HttpListenerContext ctx = parameter as HttpListenerContext;

            if (ctx.Request.HttpMethod == "GET") {
                Console.WriteLine("GET REQ!");
                GET.execute(ctx);
            }

            else if (ctx.Request.HttpMethod == "POST") {
                Console.WriteLine("POST REQ!");
                POST.excute(ctx);
            }

        }
    }

    class GET {
        public static void execute(HttpListenerContext ctx) {
            string requestURL = ctx.Request.Url.ToString().Replace("http://127.0.0.1:8080/", "");
            string query = string.Empty;
            /*
            if (requestURL.Contains('?'))
            {
                requestURL = requestURL.Split('?')[0];
                query = requestURL.Split('?')[1];
            }
            */
            /////// Request에 따라 분기
            /// Example : http://localhost:8080/get -> get
            /// 아래처럼  static 함수 추가하고 if문으로 분기
            /// 
            if (requestURL.StartsWith("RECEIVE"))
                Receive(ctx);
        }
        public static void Receive(HttpListenerContext ctx) {
            Console.WriteLine("Receive");
            string requestURL = ctx.Request.Url.ToString().Replace("http://127.0.0.1:8080/", "");
            string queName = requestURL.Replace("RECEIVE/", "");



            JObject res = new JObject();
            if (HttpServer.dictQue[queName].Count > 0) {
                int currId = HttpServer.MsgID;
                HttpServer.MsgID += 1;
                String msg = HttpServer.dictQue[queName][0];
                HttpServer.dictQue[queName].RemoveAt(0);
                HttpServer.sendedQueName.Add(currId, queName);
                HttpServer.sendedMsg.Add(currId, msg);
                res.Add("Result", "Ok");
                res.Add("MessageID", currId);
                res.Add("Message", msg);
                Console.WriteLine("Result : Ok / Message ID : " + currId + " / Queue Name : " + queName + "/ Message : " + msg);
                if (HttpServer.dictQue[queName].Count > 0)
                    Console.WriteLine("Receive ::::: Queue " + queName + "'s first content : " + HttpServer.dictQue[queName][0]);
            }
            else {
                res.Add("Result", "No Message");
                Console.WriteLine("Result", "No Message");
            }
            try {
                byte[] data = Encoding.UTF8.GetBytes(res.ToString());
                ctx.Response.OutputStream.Write(data, 0, data.Length);
                ctx.Response.StatusCode = 200;
                ctx.Response.Close();
            }
            catch (Exception e) {
                Console.WriteLine(e);
            }

        }

        // Add GET Function
    }


    class POST {


        public static void excute(HttpListenerContext ctx) {
            string requestURL = ctx.Request.Url.ToString().Replace("http://127.0.0.1:8080/", "");
            /// Request URL에 따라 분기
            /// Example : http://localhst:8080/get -> get
            /// 아래함수처럼 static 함수 추가하고 if문으로 분기
            /// POST의 경우 context에 Request Content가 포함되어 있음
            if (requestURL.StartsWith("CREATE")) {
                Console.WriteLine("POST CREATE!");
                CreateQueue(ctx);
            }
            else if (requestURL.StartsWith("SEND")) {
                Console.WriteLine("POST SEND!");
                SendMsg(ctx);
            }
            else if (requestURL.StartsWith("ACK")) {
                Console.WriteLine("POST ACK!");
                Ack(ctx);
            }
            else if (requestURL.StartsWith("FAIL")) {
                Console.WriteLine("POST FAIL!");
                Fail(ctx);
            }
        }
        public static void CreateQueue(HttpListenerContext ctx) {
            Console.WriteLine("CreateQueue");

            string requestURL = ctx.Request.Url.ToString().Replace("http://127.0.0.1:8080/", "");
            string queName = requestURL.Replace("CREATE/", "");

            // Client에서 보낸 데이터로 Do something
            StreamReader sr = new StreamReader(ctx.Request.InputStream);
            string txt = sr.ReadToEnd();
            JObject json = JObject.Parse(txt);

            // Console.WriteLine(sr.ReadToEnd());
            JObject res = new JObject();
            if (HttpServer.dictQue.ContainsKey(queName)) {
                Console.WriteLine("Queue Exist");
                res.Add("Result", "Queue Exist");
            }
            else {
                HttpServer.dictQue.Add(queName, new List<string>());
                HttpServer.dictSize.Add(queName, int.Parse(json["QueueSize"].ToString()));
                res.Add("Result", "Ok");
            }


            byte[] data = Encoding.UTF8.GetBytes(res.ToString());
            ctx.Response.OutputStream.Write(data, 0, data.Length);
            ctx.Response.StatusCode = 200;
            ctx.Response.Close();
        }
        public static void SendMsg(HttpListenerContext ctx) {
            Console.WriteLine("SendMsg");
            string requestURL = ctx.Request.Url.ToString().Replace("http://127.0.0.1:8080/", "");
            string queName = requestURL.Replace("SEND/", "");

            // Client에서 보낸 데이터로 Do something
            StreamReader sr = new StreamReader(ctx.Request.InputStream);
            string txt = sr.ReadToEnd();
            JObject json = JObject.Parse(txt);

            JObject res = new JObject();
            if (HttpServer.dictQue[queName].Count >= HttpServer.dictSize[queName]) {
                Console.WriteLine("Queue Full");
                res.Add("Result", "Queue Full");
            }
            else {
                HttpServer.dictQue[queName].Add(json["Message"].ToString());
                res.Add("Result", "Ok");
                Console.WriteLine("SendMsg ::::: Queue " + queName + "'s first content : " + HttpServer.dictQue[queName][0]);
            }

            byte[] data = Encoding.UTF8.GetBytes(res.ToString());
            ctx.Response.OutputStream.Write(data, 0, data.Length);
            ctx.Response.StatusCode = 200;
            ctx.Response.Close();
        }

        public static void Ack(HttpListenerContext ctx) {
            Console.WriteLine("Ack");
            string requestURL = ctx.Request.Url.ToString().Replace("http://127.0.0.1:8080/", "");
            string queAndMsgId = requestURL.Replace("ACK/", "");
            string[] param = queAndMsgId.Split('/');
            HttpServer.sendedMsg.Remove(int.Parse(param[1]));
            HttpServer.sendedQueName.Remove(int.Parse(param[1]));

            JObject res = new JObject();

            Console.WriteLine("ACK ::::: Queue " + param[0] + "'s first content : " + HttpServer.dictQue[param[0]][0]);

            res.Add("Result", "Ok");


            byte[] data = Encoding.UTF8.GetBytes(res.ToString());
            ctx.Response.OutputStream.Write(data, 0, data.Length);
            ctx.Response.StatusCode = 200;
            ctx.Response.Close();
        }

        public static void Fail(HttpListenerContext ctx) {
            Console.WriteLine("Fail");
            string requestURL = ctx.Request.Url.ToString().Replace("http://127.0.0.1:8080/", "");
            string queAndMsgId = requestURL.Replace("FAIL/", "");
            string[] param = queAndMsgId.Split('/');

            HttpServer.dictQue[param[0]].Insert(0, HttpServer.sendedMsg[int.Parse(param[1])]);
            HttpServer.dictQue[param[0]].Sort((string b, string a) => { return int.Parse(a.Substring(a.Length - 1)).CompareTo(int.Parse(b.Substring(b.Length - 1))); });

            HttpServer.sendedMsg.Remove(int.Parse(param[1]));
            HttpServer.sendedQueName.Remove(int.Parse(param[1]));

            Console.WriteLine("FAIL ::::: Queue " + param[0] + "'s first content : " + HttpServer.dictQue[param[0]][0]);

            JObject res = new JObject();

            res.Add("Result", "Ok");

            byte[] data = Encoding.UTF8.GetBytes(res.ToString());
            ctx.Response.OutputStream.Write(data, 0, data.Length);
            ctx.Response.StatusCode = 200;
            ctx.Response.Close();
        }
        // Add POST Function
    }
}