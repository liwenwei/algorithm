package com.liwenwei.algs4.ex.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_11_EvaluatePostfix {
	
	public static void main(String[] args) {
		String infixexpr = "";
		while (!StdIn.isEmpty()) {
			infixexpr += StdIn.readString() + " ";
		}
		
		String postfixexpr = Ex_1_3_10_InfixToPostfix.infixToPostfix(infixexpr);
		StdOut.println(postfixexpr);
	}
	
}
