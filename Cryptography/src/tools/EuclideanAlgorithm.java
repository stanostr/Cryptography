package tools;

public class EuclideanAlgorithm {
	
	/**
	 * basic recursive Euclidean algorithm for finding the gcd of a and b
	 * @return gcd
	 */
	public static long gcd_euclid(long a, long b)
	{
		if(a<0) a = -a;
		if(b<0) b = -b;
		
		if(a==0) return b; 
		else if (b==0) return a;
		
		if(a<b)
		{
			return gcd_euclid(b, a);
		}
		
		long c = (a%b);
		if(c==0)
			return b;
		else if(c==1)
			return 1;
		
		return gcd_euclid(b, c);
	}
	
	/**
	 * solves the extended euclidean algorithm
	 * ax+by=gcd(a,b) for x and y
	 * @param a, b
	 * @return array where first element is x and the second is y
	 */
	public static long[] extendedEuclideanRoots(long a, long b)
	{
		
		long XIminus1 = 0, XIminus2 = 1, YIminus1 = 1, YIminus2 = 0;
		long temp; //to hold the value of the last x or y while performing calculation
	    while (b != 0)
	    {
	    	long quotient = a / b;
	    	long remainder = a % b;
	    	
	    	a = b;
	    	b = remainder; 
	    	
	    	temp = XIminus1;
	    	XIminus1 = -quotient*XIminus1 + XIminus2;
	        XIminus2 = temp;
	 
	        temp = YIminus1;
	        YIminus1 = -quotient*YIminus1 + YIminus2;
	        YIminus2 = temp;            
	   }
	   System.out.println("The roots are x: " + XIminus2 + " y: " + YIminus2);
	   long[] roots = {XIminus2, YIminus2}; //the last quotient isn't used
	   return roots;
	}
	
	/**
	 * @param a the number of which you want to find the inverse
	 * @param n the modulus
	 * @return the inverse
	 */
	public static long multiplicativeInverse (long a, long n)
	{
		long[] roots = extendedEuclideanRoots(a, n);
		return roots[0];
	}
}
