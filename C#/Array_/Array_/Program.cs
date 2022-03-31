using System;

namespace Array_ {

    class A {
        public int num;
    }
    class Program {
        static void Main(string[] args) {
            // 배열 생성 방법
            //case 1 
            int[] arr1;
            arr1 = new int[3] { 1, 2, 3 };

            //case2
            int[] arr2 = new int[] { 1, 2, 3 };

            //case3
            int[] arr3 = { 1, 2, 3 };

            //case4
            int[] arr4 = new int[3];
            Array.Fill(arr4, 0);


            //다차원 배열
            //2행3열
            int[,] arr5 = new int[2, 3];
            //생성과 함께 초기화
            int[,] arr7 = new int[,] { { 1, 2 },{ 3, 4 } };


            //3차원 이상
            int[,,] arr6 = new int[2, 3, 2];

            //생성과 함께 초기화
            int[,,] arr8 = new int[,,]
                {
                    {{1,2 },{3,4 } },
                    {{ 4,5},{ 6,7} }
                };


            //가변배열
            int[][] array = new int[2][];
            array[0] = new int[4];
            array[1] = new int[3];



            array[0] = new int[] { 1, 2, 3, 4 };
            array[1] = new int[] { 5, 6, 7 };


            //생성과 동시에 값 할당
            int[][] array2 = new int[][]
                {
                    new int[3] {1,2,3},
                    new int[4] {3,4,5,6}
                };

            //혹은
            int[][] array3 = new int[][]
                {
                    new int[]{1,2,3},
                    new int[]{5,6,7,8}
                };



            //클래스 배열
            A[] testA = new A[3];
            testA[0] = new A();
            testA[1] = new A();
            testA[2] = new A();

        }
    }
}
