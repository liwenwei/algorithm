package com.liwenwei.algs4.ex.chapter1;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.liwenwei.algs4.code.Stack;

/**
 * 
 * 将算数表达式由中序表达式转为后序表达式
 * 
 * 前序遍历： 根左右（Pre-Order Traversal）
 * 中序遍历：左根右（In-Order Traversal）
 * 后序遍历：左右根（Post-Order Traversal）
 * 
 * 中序表达式：a+(b-c)*d
 *       +
 *     /   \
 *    a     *
 *         / \
 *        -   d
 *       / \
 *      b   c
 * 后序表达式：a+(b-c)*d -> a,b,c,-,d,*,+
 */
public class Ex_1_3_10_InfixToPostfix {

	public static void main(String[] args) {
		System.out.println(infixToPostfix("A * B + C * D"));
		System.out.println(infixToPostfix("( A + B ) * C - ( D - E ) * ( F + G )"));
	}
	
	/**
	 * General Infix-to-Postfix conversion
	 * 1. Assume the infix expression is a string of tokens delimited by spaces. 
	 * 2. The operator tokens are *,/,+ and -,
	 * 3. along with the left and right parentheses. 
	 * 4. The operand tokens are the single-character identifier A, B, C and so on
	 * 
	 * The following steps will produce a string of tokens in postfix order:
	 * 1. Create an empty stack called opstack
	 * 2. Convert the input infix string to a list by using the string method split
	 * 3. Scan the token list from left and right
	 *   - if the token is an operand, append it to the end of the output list
	 *   - if the token is left parenthesis, push it on the opstack
	 *   - if the token is right parenthesis, pop the opstack untill the corresponding left parenthesis is
	 *     removed. Append each operator to the end of the output list
	 *   - if the token is an operator, *, /, +, or -, push it on the opstack. However, first remove any
	 *     operators already on the opstack that higher or equal precedence and append them to the output list
	 * 
	 * 
	 * @param infixexpr infix expression
	 * @return postfix expression
	 */
	public static String infixToPostfix(String infixexpr) {
		Hashtable<String, Integer> prec = new Hashtable<String, Integer>();
		prec.put("*", 3);
		prec.put("/", 3);
		prec.put("+", 2);
		prec.put("-", 2);
		prec.put("(", 1);
		
		Stack<String> opStack = new Stack<String>();
		List<String> postfixList = new ArrayList<String>();
		String[] tokenList = infixexpr.split(" ");
		
		for (String token : tokenList) {
			if (Character.isLetter(token.charAt(0)) || Character.isDigit(token.charAt(0))) {
				postfixList.add(token);
			} else if (token.equals("(")) {
				opStack.push(token);
			} else if (token.equals(")")) {
				String topToken = opStack.pop();
				while (!topToken.equals("(")) {
					postfixList.add(topToken);
					topToken = !opStack.isEmpty() ? opStack.pop() : "";
				}
			} else {
				while (!opStack.isEmpty() && prec.get(opStack.peek()) >= prec.get(token)) {
					postfixList.add(opStack.pop());
				}
				opStack.push(token);
			}
		}
		
		while (!opStack.isEmpty()) {
			postfixList.add(opStack.pop());
		}
		
		String postfixexpr = "";
		for (String str : postfixList) {
			postfixexpr += str + " ";
		}
		
		return postfixexpr;
	}
	
}
