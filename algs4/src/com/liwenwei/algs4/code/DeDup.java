/******************************************************************
 * 
 * 去重复（Deduplication），基于java.util.HashSet实现
 * 
 * @author liwenwei
 *
 ******************************************************************/
package com.liwenwei.algs4.code;

import java.util.HashSet;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DeDup {
	
	public static void main(String[] args) {
		HashSet<String> sets = new HashSet<String>();
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			if (!sets.contains(key)) {
				sets.add(key);
				StdOut.println(key);
			}
		}
	}
	
}
