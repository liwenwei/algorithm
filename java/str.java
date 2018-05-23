public class str {

	private static String reverse(String palindrome) {
		char[] temp = palindrome.toCharArray();
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[temp.length - 1 - i];
		}
		return String.valueOf(temp);
	}
	
	private static String reverse1(String palindrome) {
		char[] temp = palindrome.toCharArray();
		for (int i = 0; i < temp.length/2; i++) {
			char t = temp[i];
			temp[i] = temp[temp.length - 1 - i];
			temp[temp.length - 1 - i] = t;
		}
		return String.valueOf(temp);
	}
	
	private static void stringBufferDemo () {
		StringBuffer stringBuffer = new StringBuffer("Hello World");
		System.out.println(stringBuffer.capacity());
	}
	
	private static void stringBuilderDemo () {
		StringBuilder sb = new StringBuilder();
		sb.append("Geetings");
	}
	
	public static void main(String[] args) {
		stringBufferDemo();
		stringBuilderDemo();
		
		String palindrome = "Dot saw I was Tod";
		String reversePalindrome = reverse(palindrome);
		System.out.println(reversePalindrome);
		String reversePalindrome1 = reverse1(palindrome);
		System.out.println(reversePalindrome1);
	}

}