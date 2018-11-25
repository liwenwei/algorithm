package com.liwenwei.algs4.code;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {

	/**
	 * Dijkstra's two-stack algorithm
	 * 
	 * Dijkstra 在20世纪60年代发明了一个非常简单的算法，用两个栈（一个用于保存运算符，一个用于保存操作符） 完成了这个任务
	 * 
	 * 表达式有括号、运算符和操作符（数字）组成，我们根据4中情况从左到右依次逐个将实体送去栈中处理 1. 将操作数压入操作数栈 2. 将运算符压入运算符栈 3.
	 * 忽略左括号 4. 在遇到右括号时，弹出运算符和所需数量的操作符，并将运算符和操作符的运算结果压入操作数栈
	 * 
	 * 忽略空格
	 * 
	 * @param expression expression
	 * @return result
	 */
	public static double dijkstraTwoStack(String[] expression) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		for (int i = 0; i < expression.length; i++) {
			String s = expression[i];
			switch (s) {
			case "+":
			case "-":
			case "*":
			case "/":
				ops.push(s);
				break;
			case "(":
				break;
			case ")":
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) v = vals.pop() + v;
				else if (op.equals("-")) v = vals.pop() - v;
				else if (op.equals("*")) v = vals.pop() * v;
				else if (op.equals("/")) v = vals.pop() / v;
				vals.push(v);
				break;
			default:
				vals.push(Double.parseDouble(s));
			}
		}
		return vals.pop();
	}

	// Reverse Polish Notation
	// 如果当前字符为变量或者为数字，则压栈，如果是运算符，则将栈顶两个元素弹出作相应运算，结果再入栈，最后当表达式扫描完后，栈里的就是结果。
	// a+(b-c)*d ---> a,b,c,-,d,*,+
	
	public static void main(String[] args) {
		List<String> expression = new ArrayList<String>();
		while (!StdIn.isEmpty()) {
			expression.add(StdIn.readString());
		}
		
		String[] arr = new String[expression.size()];
		arr = expression.toArray(arr);
		StdOut.print(dijkstraTwoStack(arr));
	}

}
