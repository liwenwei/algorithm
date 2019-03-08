/*****************************************************************
 * 一个优先队列的用例
 * 
 * 从命令行输入一个整数M以及一系列字符串，每一行代表一个事务。这段代码调用了MinPQ
 * 并会答应数字最大的M行。它用到了Transaction类，构造了一个用数字作为键的优先队列。
 * 
 * 当优先队列的大小超过M时就删除其中最小的元素。所有事务输入完毕之后程序会从优先队列
 * 中按递减顺序打印出最大的M个事务。
 * 
 * 这段代码相当于将所有事务放入一个栈，遍历栈以颠倒它们的顺序并按照递增序键将它们打印出来
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TopM {
	
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		MinPriorityQueue<Transaction> pq = new MinPriorityQueue<>(M + 1);
		while (StdIn.hasNextLine()) {
			pq.insert(new Transaction(StdIn.readLine()));
			if (pq.size() > M) {
				pq.delMin();
			}
		}
		
		Stack<Transaction> stack = new Stack<>();
		while (!pq.isEmpty()) stack.push(pq.delMin());
		for (Transaction transaction : stack) StdOut.println(transaction);
	}
	
}
