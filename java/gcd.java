
public class gcd {

	private static int gcd(int q, int p) {
		if (p == 0)
			return q;
		int r = q % p;
		return gcd(p, r);
	}

	public static void main(String[] args) {
		System.out.println(gcd(2, 4));
		System.out.println(gcd(24, 60));
	}
	
}
