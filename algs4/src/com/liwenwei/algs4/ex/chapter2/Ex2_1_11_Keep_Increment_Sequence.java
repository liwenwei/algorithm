/****************************************************************************
 * 2.1.10 将希尔排序中实时计算递增序列改为预先计算并存储在一个数组中
 * - 递增序列
 * - 预先计算
 * 
 * @author liwenwei
 *
 ***************************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;

import com.liwenwei.algs4.code.Shell;

public class Ex2_1_11_Keep_Increment_Sequence {
	
	private static void shellsort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        int maxIncrement = 1;
        int numberOfIncrements = 1;

        while((maxIncrement * 3) + 1 < array.length) {
            maxIncrement = maxIncrement * 3;
            maxIncrement++;

            numberOfIncrements++;
        }

        int[] incrementSequence = new int[numberOfIncrements];

        int index = 0;
        while(maxIncrement > 0) {
            incrementSequence[index] = maxIncrement;

            maxIncrement--;
            maxIncrement = maxIncrement / 3;
            index++;
        }

        //Shellsort
        for(int i = 0; i < incrementSequence.length; i++) {

            int increment = incrementSequence[i];

            //h-sort the array
            for(int j = increment; j < array.length; j++) {
                int currentIndex = j;

                while(currentIndex >= increment && array[currentIndex] < array[currentIndex - increment]) {
                    int temp = array[currentIndex];
                    array[currentIndex] = array[currentIndex - increment];
                    array[currentIndex - increment] = temp;

                    currentIndex = currentIndex - increment;
                }
            }
        }
    }
	
	public static void main(String[] args) {
		int[] a = { 6, 4, 10, 9, 7, 7, 8, 10, 8, 9, 10 };
		shellsort(a);
		System.out.println(Arrays.toString(a));
	}
	
}
