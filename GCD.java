public class GCD {

	public static int naive(int a, int b) {

		for(int i = Math.min(a, b); i >= 1; i--) {

			if(a % i == 0 && b % i == 0)
				return i;
		}
		return 1;
	}

	public static void main(String[]args) {

		System.out.println(naive(20, 16));

	}
}