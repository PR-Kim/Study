namespace Convert_{
    static void Main(string[] args)
    {
        // nullable 변수 선언
        int? var1 = 123;
        if(var1.HasValue)
        {   
            Console.WriteLine("var1 has value");
        }
        else
        {
            Console.WriteLine("var1 is null");
        }


        string var2 = var1?.ToString();

        float var3 = Convert.ToInt32(var2);

        

    }
}