package tools;

import java.util.Scanner;

/**
 * brute force approach to DLP
 * @author stan_ostrovskii
 */
public class BruteForceDLP {

	/**
	 * for testing/debugging
	 */
	public static void main(String[] args) {
		System.out.println("Enter a, b, n to solve a^x = b (mod n)");
		System.out.println("Returns -1 if no solutions");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		System.out.println(bruteForceDLP(a, b, n));
	}
	
	/**
	 * solves an equation of the form a^x = b (mod n) for x
	 * @param a the a in a^x = b (mod n)
	 * @param b the b in a^x = b (mod n)
	 * @param n the n in a^x = b (mod n)
	 */
	public static long bruteForceDLP(long a, long b, long n)
	{
		//only needs to check up to n-1 in worst case, 
		//we can check x=0 but any number to 0 power is 1 so case ignored
		for(long x=1; x<n; x++)
		{
			if(Modulus.efficientModulus(a, x, n) == b)
				return x;
		}
		return -1; //fail case
	}
}
