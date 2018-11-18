
public class cha1 {

	// 1.1.9
	private static String toBinaryString(int N) {
		String s = "";
		for (int i = N; i > 0; i /= 2) {
			s = (i % 2) + s;
		}
		return s;
	}

	// 1.1.11
	// 打印出一个二维布尔数组的内容。 其中， 使用 * 表示真， 空格表示假。 打印出行号和列号
	private static void printBooleanArray(boolean[][] arr) {
		System.out.print(" ");
		for (int i = 0; i < arr[0].length; i++) {
			System.out.print((i + 1) + " "); // column line
		}
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + 1); // row line
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j]) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	private static int[][] transpose(int[][] arr) {
		
	}

	public static void main(String[] args) {
		System.out.println(toBinaryString(4));

		boolean[][] boolarr = { { true, false }, { false, true } };
		printBooleanArray(boolarr);

	}

}