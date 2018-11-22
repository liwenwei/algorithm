package com.liwenwei.algs4.ex.chapter1;

/**
 * A string s is a circular rotation(回环变位) of a string t if it matches when the characters are 
 * circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of TGACGAC.
 * 
 * 判定这个条件在基因组序列的研究中是很重要的
 * @author liwenwei
 *
 */
public class Ex_1_2_6_CircularRotation {

	public static void main(String[] args) {
		System.out.println(isCircularRotation(null, null));
		System.out.println(isCircularRotation("", ""));
		System.out.println(isCircularRotation("ACTGACG", "TGACGAC"));
		System.out.println(isCircularRotation("Hello World", " WorldHello"));

		System.out.println(isCircularRotation(null, null));
		System.out.println(isCircularRotation1("", ""));
		System.out.println(isCircularRotation1("ACTGACG", "TGACGAC"));
		System.out.println(isCircularRotation1("Hello World", " WorldHello"));
	}

	private static boolean isCircularRotation(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		
		if (s.equals(t)) {
			return true;
		}

		for (int i = 0; i < s.length(); i++) {
			s = s.substring(1) + s.substring(0, 1);
			if (s.equals(t)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isCircularRotation1(String s, String t) {
		return (s + s).indexOf(t) >= 0;
	}

}
