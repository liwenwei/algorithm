package com.liwenwei.algs4.ex.chapter1;

public class Ex_1_3_14_ResizingArrayQueueOfStrings {

	public class ResizingArrayQueueOfStrings {

		private String[] items;
		private int n;
		private int first;
		private int last;

		public ResizingArrayQueueOfStrings(int capacity) {
			items = new String[capacity];
		}

		public boolean isEmpty() {
			return n == 0;
		}

		public int size() {
			return n;
		}

		public void resize(int capacity) {
			String[] temp = new String[capacity];

			for (int i = 0; i < n; i++) {
				temp[i] = items[(first + i) % items.length];
			}

			items = temp;
			first = 0;
			last = n;
		}

		public void enqueue(String item) {

			if (n == items.length) {
				resize(items.length * 2);
			}

			if (last == items.length) {
				last = 0; // Wrap around
			}

			items[last++] = item;
			n++;
		}

		public String dequeue() {
			if (isEmpty()) {
				throw new RuntimeException("Queue underflow");
			} else {
				String item = items[first];
				items[first] = null; // To avoid loitering
				first++;

				if (first == items.length) {
					first = 0; // Wrap around
				}
				n--;
				
				if (n > 0 && n == items.length/4) {
					resize(items.length / 2);
				}
				
				return item;
			}
		}
	}
}
