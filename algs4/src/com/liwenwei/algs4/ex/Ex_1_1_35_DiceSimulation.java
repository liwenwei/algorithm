package com.liwenwei.algs4.ex;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// 模拟掷骰子
// 这个实验的结果证实，数据量的多少，对两个骰子之和的准确概率分布数据影响不是很大
public class Ex_1_1_35_DiceSimulation {

	public static void main(String[] args) {
		double[] distExact = diceSimulation();
		double[] distExperiment = diceExperiment(510000);

		StdOut.println("Exact:");
		for (int i = 2; i < distExact.length; i++) {
			StdOut.printf("%5.3f ", distExact[i]);
		}

		StdOut.println();

		StdOut.println("Experiment:");
		for (int i = 2; i < distExperiment.length; i++) {
			StdOut.printf("%5.3f ", distExperiment[i]);
		}
	}

	// exact data
	private static double[] diceSimulation() {
		int SIDES = 6;
		double[] dist = new double[2 * SIDES + 1];
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				dist[i + j] += 1.0; // time counter
			}
		}

		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
		}

		return dist;
	}

	// experiment data
	private static double[] diceExperiment(int N) {
		int SIDES = 6;
		double[] distExperiment = new double[2 * SIDES + 1];

		int diceOne = 0;
		int diceTwo = 0;
		int sum = 0;

		for (int i = 1; i <= N; i++) {
			diceOne = StdRandom.uniform(1, 7);
			diceTwo = StdRandom.uniform(1, 7);
			sum = diceOne + diceTwo;
			distExperiment[sum] += 1.0;
		}

		for (int k = 2; k <= 2 * SIDES; k++) {
			distExperiment[k] /= N;
		}

		return distExperiment;
	}

}
