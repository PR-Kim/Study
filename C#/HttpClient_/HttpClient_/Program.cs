using System;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;

namespace HttpClient_ {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine("Http Client!");
            Client cli = new Client();
            for(int i = 0; i < 10; i++) {
                if (i < 5) {
                    // Using Task
                    Task.Factory.StartNew(() => {
                        cli.TaskGet();
                    });
                }
                else {
                    // Using Thread
                    Thread thread = new Thread(cli.ThreadPost);
                    thread.IsBackground = true;
                    thread.Start();
                }


            }
            Console.ReadLine();
        }
    }
    class Client {
        // GET Request with Task
        public Task TaskGet() {
            Console.WriteLine("Task start!");
            string responseString = string.Empty;
            using (HttpClient httpClient = new HttpClient()) {
                try {
                    Task<HttpResponseMessage> httpResponse = httpClient.GetAsync("http://localhost:8080/get");
                    HttpResponseMessage msg = httpResponse.Result;
                    responseString = msg.Content.ReadAsStringAsync().Result;
                }
                catch (Exception e) {
                    Console.WriteLine(e);
                }
            }
            Console.WriteLine("Task end!");
            Console.WriteLine(responseString);
            return Task.CompletedTask;
        }

        // POST Request with Thread 
        public void ThreadPost(object state) {
            Console.WriteLine("Thead Start");
            string responseString = string.Empty;
            // Post로 보낸 Content
            var stringContent = new StringContent("Client Send String Data");

            using (HttpClient httpClient = new HttpClient()) {
                try {
                    Task<HttpResponseMessage> httpResponse = httpClient.PostAsync("http://localhost:8080/post", stringContent);
                    HttpResponseMessage msg = httpResponse.Result;

                    responseString = msg.Content.ReadAsStringAsync().Result;
                }
                catch (Exception e) {
                    Console.WriteLine(e);
                }
            }
            Console.WriteLine("Thread end!");
            Console.WriteLine(responseString);
        }
    }
}
