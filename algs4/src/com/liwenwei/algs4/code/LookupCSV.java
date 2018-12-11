/******************************************************************
 * 
 * LookupCSV根据命令行指定的文件中的数据构建了一组键值对，并会打印出有标准输入
 * 读取的键对应的值。
 * 
 * 命令行参数包括一个文件名和两个证书，分别来指定键和值所在的位置
 * 
 * @author liwenwei
 *
 ******************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookupCSV {
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		int keyField = Integer.valueOf(args[1]);
		int valField = Integer.valueOf(args[2]);
		ST<String, String> st = new ST<String, String>();
		while (in.hasNextLine()) {
			String line = in.readLine();
			String[] tokens = line.split(",");
			st.put(tokens[keyField], tokens[valField]);
		}
		// Query by key from input
		while (!StdIn.isEmpty()) {
			String query = StdIn.readString();
			if (st.contains(query))
				StdOut.println(st.get(query));
		}
	}
	
}
