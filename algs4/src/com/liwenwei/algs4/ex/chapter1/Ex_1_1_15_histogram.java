package com.liwenwei.algs4.ex.chapter1;

public class Ex_1_1_15_histogram {

    private static int sum(int[] histogram) {
        int num = 0;
        for (int temp : histogram) {
            num += temp;
        }
        return num;
    }

    private static int counter(int[] a, int i) {
        int times = 0;
        for (int num : a) {
            if (num == i)
            	times++;
        }
        return times;
    }
    
    private static int[] histogram(int[] a, int M) {
        int[] res = new int[M];
        for (int i = 0; i < M; i++) {
            res[i] = counter(a, i);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = 50;
        }
        int M = 100;
        for (int temp : histogram(a, M)) {
            System.out.println(temp);
        }

        System.out.println(a.length == sum(histogram(a, M)) ? true : false);
    }
}
