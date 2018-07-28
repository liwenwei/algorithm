
public class palindrome {

	public static boolean isPalindrome(String str) {
		if (str == null && str.isEmpty()) {
			return false;
		}

		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			while (((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
					|| (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) == false 
					&& i < str.length()) {
				i++;
			}
			while (((str.charAt(j) >= 'A' && str.charAt(j) <= 'Z')
					|| (str.charAt(j) >= 'a' && str.charAt(j) <= 'z')) == false 
					&& j > 0) {
				j--;
			}
			if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("abcba"));
		System.out.println(isPalindrome("liwenwei"));
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome("A man, a plan, a canal: panama"));
	}
}
