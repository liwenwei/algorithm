package com.liwenwei.algs4.ex.chapter1;

import com.liwenwei.algs4.code.Stack;

public class Ex_1_3_4_Parentheses {
	
	public static void main(String[] args) {
		System.out.println(isParenthese("[()]{}{[()()]()}"));
		System.out.println(isParenthese("[(])"));
	}
	
	public static boolean isParenthese(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char val = str.charAt(i);
			switch (val) {
			case '(':
			case '[':
			case '{':
				stack.push(val);
				break;
			case ')':
				if (stack.pop() == '(') {
					break;
				} else {
					return false;
				}
			case ']':
				if (stack.pop() == '[') {
					break;
				} else {
					return false;
				}
			case '}':
				if (stack.pop() == '{') {
					break;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
}
