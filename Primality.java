import java.util.Arrays;

class Primality {

	public static boolean checkBasic(int n) {
		
		if(n <= 1)     return false;
		if(n == 2)     return true;
		if(n % 2 == 0) return false;

		for(int i = 2; i < n; i++) {
			if(n % i == 0)
				return false;
		}

		return true;
	}

	public static boolean checkComplex(int n) {

		if(n <= 1)     return false;
		if(n == 2)     return true;
		if(n % 2 == 0) return false;

		int m = (int)Math.sqrt(n);

		for(int i = 3; i < m; i+=2) { 

			if(n % i  == 0)
				return false;
		}

		return true;
	}

	public static boolean[] sieve(int n) {

		boolean [] prime = new boolean [n+1];
		Arrays.fill(prime, true);

		prime[0] = false;
		prime[1] = false;

		int m = (int)Math.sqrt(n);

		for(int i = 2; i <= m; i++)
		{
			if(prime[i])
			{
				for(int k = i*i; k <= n; k+=i)
					prime[k] = false;
			}
		}
		return prime;
	}

	public static void main(String[]args) {
		boolean [] result = sieve(20);

		for(int i = 0; i < result.length; i++) {
			if(result[i])
				System.out.println(i);
		}
	}
}







