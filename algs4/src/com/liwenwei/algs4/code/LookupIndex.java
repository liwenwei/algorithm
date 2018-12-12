/******************************************************************
 * 
 * - 索引
 * - 反向索引
 * 
 * @author liwenwei
 *
 ******************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookupIndex {

	public static void main(String[] args) {
		In in = new In(args[0]); // 索引数据库
		String regex = args[1]; // 分隔符
		ST<String, Queue<String>> st = new ST<String, Queue<String>>(); // 索引
		ST<String, Queue<String>> ts = new ST<String, Queue<String>>(); // 反向索引
		while (in.hasNextLine()) {
			String[] tokens = in.readLine().split(regex);
			String key = tokens[0];
			for (int i = 1; i < tokens.length; i++) {
				String val = tokens[i];
				if (!st.contains(key))
					st.put(key, new Queue<String>());
				if (!ts.contains(val))
					ts.put(val, new Queue<String>());
				st.get(key).enqueue(val);
				ts.get(val).enqueue(key);
			}
		}
		// Query
		while (!StdIn.isEmpty()) {
			String query = StdIn.readLine();
			if (st.contains(query)) {
				for (String s : st.get(query))
					StdOut.println(" " + s);
			}
			if (ts.contains(query)) {
				for (String s : ts.get(query))
					StdOut.println(" " + s);
			}
		}
	}
	
}
