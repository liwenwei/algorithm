package com.liwenwei.algs4.code;

import java.util.Date;

public class Transaction implements Comparable<Transaction> {
	private final String who;    // customer
	private final Date when;     // date
	private final double amount; // amount

	public Transaction(String who, Date when, double amount) {
		if (Double.isNaN(amount) || Double.isInfinite(amount))
			throw new IllegalArgumentException("Amount cannot be NaN or infinite");
		this.who = who;
		this.when = when;
		this.amount = amount;
	}

	/**
	 * Initializes a new transaction by parsing a string of the form NAME DATE
	 * AMOUNT.
	 * 
	 * @param transaction string
	 * 
	 */
	public Transaction(String transaction) {
		String[] a = transaction.split("\\s+");
		who = a[0];
		when = new Date(a[1]);
		amount = Double.parseDouble(a[2]);
		if (Double.isNaN(amount) || Double.isInfinite(amount))
			throw new IllegalArgumentException("Amount cannot be NaN or infinite");
	}

	public String who() {
		return who;
	}

	public Date when() {
		return when;
	}

	public double amount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10s %8.2f", who, when, amount);
	}

	@Override
	public int compareTo(Transaction o) {
		return Double.compare(this.amount, o.amount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		hash = prime * hash + (int) (temp ^ (temp >>> 32));
		hash = prime * hash + ((when == null) ? 0 : when.hashCode());
		hash = prime * hash + ((who == null) ? 0 : who.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (when == null) {
			if (other.when != null)
				return false;
		} else if (!when.equals(other.when))
			return false;
		if (who == null) {
			if (other.who != null)
				return false;
		} else if (!who.equals(other.who))
			return false;
		return true;
	}
	
	
}
