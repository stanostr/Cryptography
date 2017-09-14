package ciphers;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class IcelandicLetterFrequency {

	//for debugging only
	public static void main(String[] args) throws FileNotFoundException
	{
		String inputFile = args[0];
		String outFile = args[1];
		printFrequency(frequencyArray(input(inputFile)), outFile);
	}
	
	public static char[] input(String inputFileName) throws FileNotFoundException
	{
		char[] cipherArray;
		
		//open or create files, read in ciphertext and convert to char array
		File inputFile = new File(inputFileName);
		Scanner infile = new Scanner(inputFile);	
		String cipher = "";
		while(infile.hasNextLine())
		{
			cipher = cipher + infile.nextLine();
		}
		cipherArray = cipher.toCharArray();
		infile.close();
		System.out.println(new String(cipherArray));
		return cipherArray;
	}
	
	/**
	 * @param cipherArray char array representing the text to be analyzed
	 * @return an array of frequencies. 
	 * [0] corresponds to 'a', [31] corresponds to '\u00F6'
	 */
	public static int[] frequencyArray(char[] cipherArray)
	{
		int [] freqArr = new int [32];
		for(char c: cipherArray)
		{
			int val = IcelandicConverter.charToInt(c);
			freqArr[val]++;
		}
		return freqArr;
	}
	
	public static void printNumber(int[] frequencyArray, String outputFileName) 
			throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter(outputFileName);

		//print # occurences of each letter
		for(int i=0; i<32; i++)
		{
			out.print("# of " + IcelandicConverter.intToChar(i) + ": ");
			out.println(frequencyArray[i]);
		}
		out.close();
	}

	public static void printFrequency(int[] frequencyArray, String outputFileName) 
			throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter(outputFileName);
		// to round percentages to 4 decimal places
		DecimalFormat df = new DecimalFormat("####0.0000");
		
		/*compute length i.e. how many total letters there were
		 * this is to compute the percent of each
		 */
		double length = 0;
		for(int i=0; i<32; i++)
		{
			length = length + frequencyArray[i];
		}

		out.println("Frequencies of each Icelandic letter:");
		//print percent of total for each letter
		for(int i=0; i<32; i++)
		{
			out.print(IcelandicConverter.intToChar(i) + ": ");
			out.println(" " + df.format((frequencyArray[i]/length)*100) + "% of total text");
		}
		out.close();
	}
}