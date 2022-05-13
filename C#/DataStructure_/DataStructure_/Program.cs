using System;
using System.Collections;
using System.Collections.Generic;

namespace DataStructure_ {
    class Program {
        static void Main(string[] args) {
            // 큐
            Queue<int> que = new Queue<int>();

            que.Enqueue(120);
            que.Enqueue(10);

            int next = que.Dequeue();
            que.Peek();
            int cnt =  que.Count;

            que.Clear();

			//우선순위 큐
			// C#은 우선순위 큐에 대한 라이브러리가 없음, 클래스로 만들어 사용
			// 큐에 삽입할 때 우선순위와 값을 함께 삽입
			// 숫자의 경우 같은 수를 입력하면 크기 순으로 정렬
			PriorityQueue priQue = new PriorityQueue();
			priQue.Enqueue(1, 1);
			priQue.Enqueue(3, 3);
			priQue.Enqueue(5, 5);
			priQue.Enqueue(2, 2);

			int nextt = priQue.Dequeue().Value;
			nextt = priQue.Dequeue().Value;


			//스택
			Stack<int> stk = new Stack<int>();
			stk.Push(1);
			stk.Push(2);
			stk.Push(3);

			int val = stk.Pop();
			stk.Peek();
			cnt = stk.Count;
			Console.WriteLine("Stack Count : " + cnt);
			stk.Clear();

			// 해쉬 셋
			// 중복과 순서가 없는 집합
			HashSet<int> hashSet = new HashSet<int>();
			hashSet.Add(1);
			hashSet.Add(1);
			hashSet.Add(2);
			cnt = hashSet.Count;
			Console.WriteLine("hashSet Count : " + cnt);
			hashSet.Remove(2);
			hashSet.Clear();


			//해쉬 맵
			// 키 벨류 쌍
			// C#에서는 HashTable 과 Dictionary 형태로 존재함
			
			// 해쉬테이블의 경우, 존재하는 키를 add 할 경우 에러 발생

			Hashtable hashTable = new Hashtable();
			hashTable.Add("one", "하나");
			hashTable.Add("two", "둘");
			hashTable.Remove("two");
			hashTable.Contains("two");

			Dictionary<string, int> dict = new Dictionary<string, int>();
			dict.Add("One", 1);
			dict.Add("Two", 2);
			cnt = dict.Count;
			dict.ContainsKey("One");
			dict.ContainsValue(1);
			foreach(string key in dict.Keys) {
				Console.WriteLine(key);
            }
			dict.Clear();


			// List
			List<int> lst = new List<int>();
			lst.Add(1);
			lst.Add(2);
			lst.Add(3);
			// 배열처럼 접근
			int a = lst[1];
			cnt = lst.Count;
			// 정렬
			lst.Sort();
			// 역순으로 정렬
			lst.Reverse();
			int[] arrLst = lst.ToArray();
			// 특정위치에 값 추가
			lst.Insert(0, 2);

			lst.Contains(1);
			// 특정값의 인덱스
			lst.IndexOf(1);


			// 정렬된 리스트
			//자동 정렬된 리스트
			SortedList<int, int> sortedLst = new SortedList<int, int>();
			sortedLst.Add(1, 1);
			sortedLst.Add(4, 4);
			sortedLst.Add(2, 2);
			sortedLst.IndexOfValue(4);

			
		}
    }
	class Item {
		public int Value { get; set; }
		public int Priority { get; set; }
	}

	class PriorityQueue {
		private List<Item> _heap = new List<Item>();

		public void Enqueue(int priority, int value) {
			_heap.Add(new Item() { Priority = priority, Value = value });

			int now = _heap.Count - 1;

			while (now > 0) {
				int next = (now - 1) / 2;

				if (_heap[now].Priority < _heap[next].Priority)
					break;

				Item temp = _heap[now];
				_heap[now] = _heap[next];
				_heap[next] = temp;
				now = next;
			}
		}

		public Item Dequeue() {
			Item ret = _heap[0];
			int lastIdx = _heap.Count - 1;

			_heap[0] = _heap[lastIdx];
			_heap.RemoveAt(lastIdx);
			lastIdx--;

			int now = 0;
			while (true) {
				int left = 2 * now + 1;
				int right = 2 * now + 2;

				int next = now;

				if (left <= lastIdx && _heap[next].Priority < _heap[left].Priority)
					next = left;
				if (right <= lastIdx && _heap[next].Priority < _heap[right].Priority)
					next = right;

				if (now == next)
					break;

				Item temp = _heap[now];
				_heap[now] = _heap[next];
				_heap[next] = temp;
				now = next;
			}

			return ret;
		}

		public void ShowItems() {
			Console.WriteLine("====================");
			Console.WriteLine("Priority Queue Items");
			for (int i = 0; i < _heap.Count; i++)
				Console.WriteLine($"Priority : {_heap[i].Priority} Value : {_heap[i].Value}");
			Console.WriteLine("====================");
		}
	}
}
