package tools;
import java.util.*;
/**
 * Baby step giant step approach to DLP
 * @author stan_ostrovskii
 */
public class BabyStepGiantStep {
	public static void main(String[] args) {
		//testing the numbers in 4c
		System.out.println("Solving 2^x=184655036034450 (mod 184655036034450)");
		System.out.println("X=" + solve(2, 184655036034450L, 184655036034450L));
	}
	
	/**
	 * solves an equation of the form a^x = b (mod p) for x
	 * @param a the a in a^x = b (mod p)
	 * @param b the b in a^x = b (mod p)
	 * @param n the n in a^x = b (mod p)
	 * @return solution for x
	 */
	public static long solve(long a, long b, long p)
	{
		int N = (int)(Math.sqrt(p-1) +1);
		long[] firstList = new long[N];
		long[] secondList = new long[N];
		HashSet<Long> set1 =  new HashSet<Long>();
		HashSet<Long> set2 =  new HashSet<Long>();
		//the j and k in the text are the same length
		for(int j=0; j<N; j++)
		{
			firstList[j] = Modulus.efficientModulus(a, j, p);
			set1.add(Modulus.efficientModulus(a, j, p));
			long power = -N*j; //could be done in one step
			long atopower = Modulus.efficientModulus(a, power, p);
			secondList[j] = (b*atopower)%p;
			set2.add((b*atopower)%p);
		}
		
		for(int j=0; j<N; j++)
		{
			for(int k=0; k<N; k++)
			{
				if(firstList[j] == secondList[k])
					return j+N*k;
			}
		}
		
		return -1; //fail case
	}

}
