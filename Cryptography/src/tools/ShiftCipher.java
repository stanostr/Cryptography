package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShiftCipher {
	private static Scanner infile;
	private static PrintWriter outfile;

	public static void affineCipher(String inputFileName, String outputFileName)
	{
		try {
			//open or create files, read in ciphertext and convert to char array
			File inputFile = new File(inputFileName);
			infile = new Scanner(inputFile);
			outfile = new  PrintWriter(outputFileName);
			String cipher = "";
			while(infile.hasNextLine())
			{
				cipher = cipher + infile.nextLine();
			}
			char[] cipherArray = cipher.toCharArray();

			//Algorithm starts here!
			//for every possible shift k=1-25 
		
			
			infile.close();
			outfile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File error");
		}
	}
	
	public static void shiftCipher(String inputFileName, String outputFileName)
	{
		try {
			//open or create files, read in ciphertext and convert to char array
			File inputFile = new File(inputFileName);
			infile = new Scanner(inputFile);
			outfile = new  PrintWriter(outputFileName);
			String cipher = "";
			while(infile.hasNextLine())
			{
				cipher = cipher + infile.nextLine();
			}
			char[] cipherArray = cipher.toCharArray();

			//Algorithm starts here!
			//for every possible shift k=1-25 
			for(int k = 0; k<26; k++)
			{	
				char[] key = cipherArray.clone();
				for(int i = 0; i<cipherArray.length; i++)
				{					
					key[i] = numToChar(((charValue(cipherArray[i]))+k)%26);
				}
				
				//convert back to string
				String result = new String(key);
				outfile.print("k=" + k + " ");
				outfile.println(result);
				outfile.println();
				
			}
			infile.close();
			outfile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File error");
		}
	}
	
	/**
	 * ugly and inefficient probably
	 * @param x character a-z
	 * @return it's numerical value 0-25
	 */
	private static int charValue(char x)
	{
		if(x=='a')return 0;
		if(x=='b')return 1;
		if(x=='c')return 2;
		if(x=='d')return 3;
		if(x=='e')return 4;
		if(x=='f')return 5;
		if(x=='g')return 6;
		if(x=='h')return 7;
		if(x=='i')return 8;
		if(x=='j')return 9;
		if(x=='k')return 10;
		if(x=='l')return 11;
		if(x=='m')return 12;
		if(x=='n')return 13;
		if(x=='o')return 14;
		if(x=='p')return 15;
		if(x=='q')return 16;
		if(x=='r')return 17;
		if(x=='s')return 18;
		if(x=='t')return 19;
		if(x=='u')return 20;
		if(x=='v')return 21;
		if(x=='w')return 22;
		if(x=='x')return 23;
		if(x=='y')return 24;
		else return 25;
	}
	
	/**
	 * more ugliness
	 * @param x integer 0-25
	 * @return it's letter value a-z
	 */
	private static char numToChar(int x) 
	{
		if(x==0)return 'a';
		if(x==1)return 'b';
		if(x==2)return 'c';
		if(x==3)return 'd';
		if(x==4)return 'e';
		if(x==5)return 'f';
		if(x==6)return 'g';
		if(x==7)return 'h';
		if(x==8)return 'i';
		if(x==9)return 'j';
		if(x==10)return 'k';
		if(x==11)return 'l';
		if(x==12)return 'm';
		if(x==13)return 'n';
		if(x==14)return 'o';
		if(x==15)return 'p';
		if(x==16)return 'q';
		if(x==17)return 'r';
		if(x==18)return 's';
		if(x==19)return 't';
		if(x==20)return 'u';
		if(x==21)return 'v';
		if(x==22)return 'w';
		if(x==23)return 'x';
		if(x==24)return 'y';
		else return 'z';
	}
}
