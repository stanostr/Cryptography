package ciphers;

/**
 * why do you torture us so?
 * @author stan_ostrovskii
 */
public class IcelandicConverter {

		/**
		 * @param x character from the icelandic alphabet
		 * @return it's numerical value
		 *  0-31
		 */
		public static int charToInt(char x)
		{
			if(x=='a')return 0;
			if(x=='\u00e1')return 1;
			if(x=='b')return 2;
			if(x=='d')return 3;
			if(x=='\u00f0')return 4;
			if(x=='e')return 5;
			if(x=='\u00e9')return 6;
			if(x=='f')return 7;
			if(x=='g')return 8;
			if(x=='h')return 9;
			if(x=='i')return 10;
			if(x=='\u00ED')return 11;
			if(x=='j')return 12;
			if(x=='k')return 13;
			if(x=='l')return 14;
			if(x=='m')return 15;
			if(x=='n')return 16;
			if(x=='o')return 17;
			if(x=='\u00F3')return 18;
			if(x=='p')return 19;
			if(x=='r')return 20;
			if(x=='s')return 21;
			if(x=='t')return 22;
			if(x=='u')return 23;
			if(x=='\u00FA')return 24;
			if(x=='v')return 25;
			if(x=='x')return 26;
			if(x=='y')return 27;
			if(x=='\u00FD')return 28;
			if(x=='\u00FE')return 29;
			if(x=='\u00E6')return 30;
			else return 31;
		}
		
		/**
		 * @param x integer 0-25
		 * @return it's icelandic ASCII or Unicode value
		 */
		public static char intToChar(int x) 
		{
			x = x%32;
			if(x==0)return 'a';
			if(x==1)return '\u00e1';
			if(x==2)return 'b';
			if(x==3)return 'd';
			if(x==4)return '\u00f0';
			if(x==5)return 'e';
			if(x==6)return '\u00e9';
			if(x==7)return 'f';
			if(x==8)return 'g';
			if(x==9)return 'h';
			if(x==10)return 'i';
			if(x==11)return '\u00ED';
			if(x==12)return 'j';
			if(x==13)return 'k';
			if(x==14)return 'l';
			if(x==15)return 'm';
			if(x==16)return 'n';
			if(x==17)return 'o';
			if(x==18)return '\u00F3';
			if(x==19)return 'p';
			if(x==20)return 'r';
			if(x==21)return 's';
			if(x==22)return 't';
			if(x==23)return 'u';
			if(x==24)return '\u00FA';
			if(x==25)return 'v';
			if(x==26)return 'x';
			if(x==27)return 'y';
			if(x==28)return '\u00FD';
			if(x==29)return '\u00FE';
			if(x==30)return '\u00E6';
			else return '\u00F6';
		}
}

