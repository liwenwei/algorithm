package com.liwenwei.algs4.ex.chapter1;


import com.liwenwei.algs4.ex.chapter1.Rational;

public class Ex_1_2_16_Rational {
	
	public static void main(String[] args) {
		try {
			Rational rational1 = new Rational(2, 4);
			Rational rational2 = new Rational(3, 36);
			Rational rational3 = new Rational(4, 8);
			System.out.println("rational: " + rational1.toString());
			System.out.println("rationa2: " + rational2.toString());
			
			System.out.println("rational1 + rationa2: " + rational1.plus(rational2).toString());
			System.out.println("rational1 - rationa2: " + rational1.minus(rational2).toString());
			System.out.println("rational1 * rationa2: " + rational1.times(rational2).toString());
			System.out.println("rational1 / rationa2: " + rational1.divides(rational2).toString());
			
			System.out.println("rational1 equals rationa2: " + rational1.equals(rational2));
			System.out.println("rational1 equals rationa3: " + rational1.equals(rational3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
