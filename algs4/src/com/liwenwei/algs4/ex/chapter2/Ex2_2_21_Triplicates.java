/*****************************************************************
 * <b>一式三份</b>
 * <p>给定三个列表，每个列表中包含N个名字，编写一个线性对数级别的算法来判定三份
 * 列表中是否含有公共的名字，如果有，返回第一个被找到的这种名字</p>
 * 
 * @author liwenwei
 * 
***************************************************************/

package com.liwenwei.algs4.ex.chapter2;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Ex2_2_21_Triplicates {

	public static void main(String[] args) {
		String[] li1 = {"Donald", "Trump", "Barack", "Obama", "Oprah", "Winfrey", "Brad"};
		String[] li2 = {"Bill", "Gates", "Obama", "Jordan", "Kobe", "Brayte", "Alen"};
		String[] li3 = {"james", "Ashton", "Kutcher", "Pitter", "Miller", "Obama", "Brad"};
		
		Ex2_2_21_Triplicates triplicates = new Ex2_2_21_Triplicates();
		System.out.println(triplicates.isTriplicates(li1, li2, li3));
		System.out.println(triplicates.isTriplicatesII(li1, li2, li3));
	}
	
	// 利用HashSet的结构
	// 时间复杂度为O(n)=n(2+2+2)=6n~=n，但需要的空间复杂度为O（n）=3n
	public String isTriplicates(String[] arr1, String[] arr2, String[] arr3) {
		if (arr1.length != arr2.length && arr2.length != arr3.length)
			throw new IllegalArgumentException("The length of arrays are not same");
		
		Set<String> set1 = new HashSet();
		Set<String> set2 = new HashSet();
		Set<String> set3 = new HashSet();
		for (int i = 0; i < arr1.length; i++) {
			if (set2.contains(arr1[i]) && set3.contains(arr1[i])) {
				return arr1[i];
			} else {
				set1.add(arr1[i]);
			}
			if (set1.contains(arr2[i]) && set3.contains(arr2[i])) {
				return arr2[i];
			} else {
				set2.add(arr2[i]);
			}
			if (set1.contains(arr3[i]) && set2.contains(arr3[i])) {
				return arr3[i];
			} else {
				set3.add(arr3[i]);
			}
		}
		return null;
	}
	
	/**
	 * 算法思想：将所有list合并为一个list，对list排序，然后顺序的找first triplicate。如果单个list中包含相同的元素，
	 * 在合并为一个list之前，移除该元素
	 * 
	 * {@code
	 *   combined = list1.concat(list2.concat(list3.concat(list4)))
	 *   last-key = ""
	 *   last-key-count = 0
	 *   for i = 0 to combined.length-1
	 *        if combined[i] == last-key
	 *            last-key-count++
	 *            if last-key-count == 3
	 *                exit done
	 *            else
	 *                last-key = combined[i]
	 *                last-key-count = 1
	 *    end for
	 *    // if you get here, no triplicate was found
	 * }
	 * 
	 * @param arr1
	 * @param arr2
	 * @param arr3
	 * @return
	 */
	public String isTriplicatesII(String[] arr1, String[] arr2, String[] arr3) {
		return null;
	}
	
	/**
	 * It's a standard k-way merge problem{@link https://en.wikipedia.org/wiki/K-Way_Merge_Algorithms#Ideal_Merge}, 
	 * after sorting the individual lists. If the individual lists can contain duplicates, 
	 * then you'll need to remove the duplicates during the sorting.
	 * 
	 * <code>
	 * Sort the individual lists, removing duplicates
	 * Create a priority queue (min-heap) of length 4
	 * Add the first item from each list to the heap
	 * last-key = ""
	 * last-key-count = 0
	 * while not done
	 *     remove the smallest item from the min-heap
	 *     add to the heap the next item from the list that contained the item you just removed.
	 *     if the item matches last-key
	 *         increment last-key-count
	 *         if last-key-count == 3 then
	 *             output last-key
	 *             exit done
	 *         else
	 *             last-key-count = 1
 	 *            last-key = item key
	 * end while
	 * // if you get here, there was no triplicate item
	 * </code>
	 * 
	 * @param arr1
	 * @param arr2
	 * @param arr3
	 * @return
	 */
	public String isTriplicatesIII(String[] arr1, String[] arr2, String[] arr3) {
		return null;
	}
}
