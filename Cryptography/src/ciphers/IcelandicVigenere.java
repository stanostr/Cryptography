package ciphers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Entirely the same as the regular one only file and class names changed
 * @author stan_ostrovskii
 */
public class IcelandicVigenere {
	public static void main(String[] args) throws FileNotFoundException
	{	
		String inputFileName = args[0];
		char[] cipher = input(inputFileName);
		System.out.println(cipher.length);
		for(int k=3; k<=12; k++)
		{
			for(int rem = 0; rem<k; rem++)
			{
				vignereCipher(cipher, k, rem);
			}
		}
	}
	
	public static char[] input(String inputFileName)
			throws FileNotFoundException
	{
		//open or create files, read in ciphertext and convert to char array
		File inputFile = new File(inputFileName);
		Scanner infile = new Scanner(inputFile);	
		String cipher = "";
		while(infile.hasNextLine())
		{
			cipher = cipher + infile.nextLine();
		}
		infile.close();
		char[] cipherArray = cipher.toCharArray();
		return cipherArray;
	}
	
 /**
  * 
  * @param charArray the full cipher text in char array form
  * @param k the suggested key word length
 * @throws FileNotFoundException 
  */
	public static void vignereCipher(char[] charArray, int k, int rem) throws FileNotFoundException
	{
		String outputFileName = "icekeylength" + k  + "rem" + rem + ".txt";
		
		//creates a character array to represent just the characters 1(mod k)
		//from the ciphertext
		char[] keyLengthK;
		
		if(charArray.length%k<=rem)
			keyLengthK = new char[charArray.length/k];
		else keyLengthK = new char[charArray.length/k+1];
		
		
		int keyArrCounter=0;
		for(int i = 0; i<charArray.length; i++) {
			if(i%k==rem) {
				keyLengthK[keyArrCounter++] = charArray[i];
			}
		}
		PrintWriter out = new PrintWriter(outputFileName);
		out.println(new String(keyLengthK));
		out.close();
		//getting a bit too verbose here with method/class names! can't help it
		IcelandicLetterFrequency.printFrequency
			(IcelandicLetterFrequency.frequencyArray(keyLengthK), outputFileName);
	}	
}
