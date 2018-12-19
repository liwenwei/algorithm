import java.util.Arrays;

/***********************************************************************
 * 
 * 月份循环，打印从当前月开始的过去12个月的月份
 * 例如： 当前月份为9，过去十二个月的月份为：  10，11，12，1，2，3，4，5，6，7，8，9
 * 
 ***********************************************************************/

public class CycleMonth {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(cycleMonth(9)));
	}
	
	/**
	 * 数组的最后一个元素是当前月份，然后向前依次递减
	 * 
	 * @param month Current month
	 * @return the last 12 months array
	 */
	public static int[] cycleMonth(int month) {
		int[] months = new int[12];
		months[11] = month; // The last element is current month
		for (int i = 10; i >= 0; i--) {
			if (months[i + 1] > 1) {
				months[i] = months[i + 1] - 1;
			} else if (months[i + 1] == 1) {
				months[i] = 12;
			}
		}
		return months;
	}
	
	/**
	 * More implements
	 */
}
