package tools;
import java.util.Scanner;
/**
 * to efficiently compute a^k(mod n) for larger numbers
 * @author stan_ostrovskii
 */
public class Modulus {
	public static void main(String[] args) {
		System.out.println("Enter integers a, k, and n to compute a^k(mod n)");
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long k = in.nextLong();
		long n = in.nextLong();
		System.out.println(efficientModulus(a, k, n));
		in.close();
	}
	
	/**
	 * I thought this was very clever
	 * @param a number
	 * @param k the power to which a is raised
	 * @param n the modulus 
	 * @return a^k(mod n)
	 */
	public static long efficientModulus(long a, long k, long n)
	{
		long temp = 1;
		for(long i=0; i<k; i++)
		{
			temp = (temp*a)%n;
		}
		return temp;
	}
}
