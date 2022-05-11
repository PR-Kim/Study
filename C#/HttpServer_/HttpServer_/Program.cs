using System;
using System.IO;
using System.Net;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace HttpServer_ {
    class Program {
        static void Main(string[] args) {
            HttpServer server = new HttpServer();
            server.Run();
        }
    }
    class HttpServer {
        HttpListener Listener;

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
            if(ctx.Request.HttpMethod == "GET") {
                GET.execute(ctx);
            }
            else if(ctx.Request.HttpMethod == "POST") {
                POST.excute(ctx);
            }
            return Task.CompletedTask;
        }

        public static void TreadRun(object parameter) {
            Console.WriteLine("Using Thread");
            HttpListenerContext ctx = parameter as HttpListenerContext;

            if (ctx.Request.HttpMethod == "GET")
                GET.execute(ctx);
            else if (ctx.Request.HttpMethod == "POST")
                POST.excute(ctx);
        }
    }

    class GET {
        public static void execute(HttpListenerContext ctx) {
            string requestURL = ctx.Request.Url.ToString().Replace("http://localhost:8080/", "");
            string query = string.Empty;
            if (requestURL.Contains('?')) {
                requestURL = requestURL.Split('?')[0];
                query = requestURL.Split('?')[1];
            }

            /////// Request에 따라 분기
            /// Example : http://localhost:8080/get -> get
            /// 아래처럼  static 함수 추가하고 if문으로 분기
            /// 
            if (requestURL == "get")
                SampleGet(ctx, query);
        }
        public static void SampleGet(HttpListenerContext ctx, string query) {
            Console.WriteLine("Sample Get");
            byte[] data = Encoding.UTF8.GetBytes("Sample Get");
            ctx.Response.OutputStream.Write(data);
            ctx.Response.StatusCode = 200;
            ctx.Response.Close();
        }

        // Add GET Function
    }


    class POST {
        public static void excute(HttpListenerContext ctx) {
            string requestURL = ctx.Request.Url.ToString().Replace("http://localhost:8080/", "");
            /// Request URL에 따라 분기
            /// Example : http://localhst:8080/get -> get
            /// 아래함수처럼 static 함수 추가하고 if문으로 분기
            /// POST의 경우 context에 Request Content가 포함되어 있음
            if (requestURL == "post")
                SamplePost(ctx);
        }
        public static void SamplePost(HttpListenerContext ctx) {
            Console.WriteLine("Sample Post!");

            // Client에서 보낸 데이터로 Do something
            StreamReader sr = new StreamReader(ctx.Request.InputStream);
            Console.WriteLine(sr.ReadToEnd());

            byte[] data = Encoding.UTF8.GetBytes("Sample Post");
            ctx.Response.OutputStream.Write(data);
            ctx.Response.StatusCode = 200;
            ctx.Response.Close();
        }

        // Add POST Function
    }

}
