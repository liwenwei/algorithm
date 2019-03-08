/*****************************************************************
 * 基于优先队列的多向归并。
 * 
 * 调用了IndexMinPQ的代码Multiway解决了多向归并问题：它将多个有序的输入流
 * 归并成一个有序的输出流
 * 
 * 许多应用中都会遇到这个问题。输入可能来自于多种科学仪器的输出（按时间排序），
 * 或是来自多个音乐或电影网站的信息列表（按名字或艺术家名字排序），或是商业交易
 * （按账号或时间排序）
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Multiway {
	
	public static void main(String[] args) {
		int N = args.length;
		In[] streams = new In[N];
		// 获取streams
		for (int i = 0; i < N; i++)
			streams[i] = new In(args[i]);
		merge(streams);
	}
	
	public static void merge(In[] streams) {
		int N = streams.length;
		IndexMinPriorityQueue<String> pq = new IndexMinPriorityQueue<>(N);
		
		for (int i = 0; i < N; i++)
			if (!streams[i].isEmpty()) {
				StdOut.println(streams[i].readString());
				pq.insert(i, streams[i].readString());
			}
		
		while (!pq.isEmpty()) {
			StdOut.println(pq.minKey());
			int i = pq.delMin();
			
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
			
		}
	}
	
}
