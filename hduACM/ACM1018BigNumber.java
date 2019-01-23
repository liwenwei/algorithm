import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		int[] nums = new int[len];
		double d = 1;
		for (int i = 0; i < len; i++) {
			int digit = scanner.nextInt();
			if(digit >= 2) {
				d = Math.log10(2 * Math.PI * digit) / 2 + digit * Math.log10(digit / Math.E) + 1;
			}
			nums[i] = (int)d;
		}
		
		for(int i = 0 ; i < len; i++) {
			System.out.println(nums[i]);
		}
	}
 
}