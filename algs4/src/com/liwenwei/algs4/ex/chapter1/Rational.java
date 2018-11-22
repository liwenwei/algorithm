package com.liwenwei.algs4.ex.chapter1;

/**
 * Rational number(有理数)
 * @author v-wenwli
 *
 */
public class Rational {
	
	private int numerator;
	private int denominator;
	
	public int getNumerator( ) {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	// a/b + c/d = (ad + bc) / bd
	public Rational plus(Rational b) {
		int numerator = this.getNumerator() * b.getDenominator() + this.getDenominator() * b.getNumerator();
		int denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	
	// a/b - c/d = (ad - bc) / bd
	public Rational minus(Rational b) {
		int numerator = this.getNumerator() * b.getDenominator() - this.getDenominator() * b.getNumerator();
		int denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	
	// a/b * c/d = ac/bd
	public Rational times(Rational b) {
		int numerator = this.numerator * b.getNumerator();
		int denominator = this.denominator * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	
	// (a/b) / (c/d) = ad/bc
    public Rational divides(Rational b) {
    	int numerator = this.numerator * b.getDenominator();
		int denominator = this.denominator * b.getNumerator();
		return new Rational(numerator, denominator);
	}
    
    // a/b = c/d if and only if ad = bc
    public boolean equals(Rational that) {
    	return this.getNumerator() * that.getDenominator() == this.getDenominator() * that.getNumerator();
    }
    
    public String toString() {
    	return String.format("%d / %d", this.numerator, this.denominator);
    }
	
}
