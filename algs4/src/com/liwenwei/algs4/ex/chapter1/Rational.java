package com.liwenwei.algs4.ex.chapter1;

/**
 * Rational number(有理数)
 * 
 * @author liwenwei
 *
 */
public class Rational {

	private long numerator;
	private long denominator;

	public int getNumerator() {
		return (int) numerator;
	}

	public int getDenominator() {
		return (int) denominator;
	}

	public Rational(int numerator, int denominator) throws Exception {
		if (numerator > Integer.MAX_VALUE || numerator < Integer.MIN_VALUE || denominator > Integer.MAX_VALUE
				|| denominator < Integer.MIN_VALUE) {
			throw new Exception("the integer value out of range");
		}

		int gcd = euclid(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}

	// a/b + c/d = (ad + bc) / bd
	public Rational plus(Rational b) throws Exception {
		int numerator = this.getNumerator() * b.getDenominator() + this.getDenominator() * b.getNumerator();
		int denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}

	// a/b - c/d = (ad - bc) / bd
	public Rational minus(Rational b) throws Exception {
		int numerator = this.getNumerator() * b.getDenominator() - this.getDenominator() * b.getNumerator();
		int denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}

	// a/b * c/d = ac/bd
	public Rational times(Rational b) throws Exception {
		int numerator = (int) this.numerator * b.getNumerator();
		int denominator = (int) this.denominator * b.getDenominator();
		return new Rational(numerator, denominator);
	}

	// (a/b) / (c/d) = ad/bc
	public Rational divides(Rational b) throws Exception {
		int numerator = (int) this.numerator * b.getDenominator();
		int denominator = (int) this.denominator * b.getNumerator();
		return new Rational(numerator, denominator);
	}

	private static int euclid(int p, int q) {
		if (q == 0)
			return p;
		int r = p % q;
		return euclid(q, r);
	}

	// a/b = c/d if and only if ad = bc
	public boolean equals(Rational that) {
		if (that == null) {
			return false;
		}

		if (this == that) {
			return true;
		}

		if (this.getClass() != that.getClass()) {
			return false;
		}

		return this.getNumerator() * that.getDenominator() == this.getDenominator() * that.getNumerator();
	}

	public String toString() {
		return String.format("%d / %d", this.numerator, this.denominator);
	}

}
