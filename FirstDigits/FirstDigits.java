/* ***************************************************
 * Brandon Rogers
 * 12/16/2020
 * FirstDigits.java
 *
 * A simple program that scrapes a text file, line by line, 
	then computes the amount of times each number (0-9) 
		appears as a first digit
 *************************************************** */

import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.nio.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

class FirstDigits {
	public static Scanner sc;
	public static int number;
	public static int firstDigit;
	public static int size;
	public static File fileName;
	public static double onePerc;
	public static int j = 0;

	//public static String firstDigits;

	public static void main(String[] args) {
		FirstDigits fd = new FirstDigits();
		fd.readFile();
		}			

	public static void readFile() {
		try {
			int i = 0;
			// ask user for file
			System.out.print("Enter the file name with extension: ");
			// scan file
			Scanner input = new Scanner(System.in);
			// create new file from scanner
			File fileName = new File(input.nextLine());
			// scan each line of file
			input = new Scanner(fileName);

			// get size of file
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (i == 0) {
					int size = line.length();
				}
				i++;
			}
			size += i;
			// send the file and file size to method
			firstDigit(fileName, size);
			input.close();
		}
		catch (Exception e) {
		}
	}

	public static void firstDigit(File file2, int size2) {
		String firstDigits = "";
		try{
			sc = new Scanner(file2);
			// get first digit of each integer in file
			for (int i = 0; i <= size2; i++) {
				// go through each integer and get first digit
				number = sc.nextInt();
				firstDigit = number;
				while (firstDigit >= 10) {
					firstDigit = (firstDigit/10);
				}
				// add the first digits to a string
				firstDigits += firstDigit;
				// send the first digits and file size to method
				calcProb(firstDigits, size2);
			}			
		}
		catch (Exception e){}
	}

	public static void calcProb(String firstDigits2, int size3) {
		// scan the string of first digits, then count the amount of each first digit
		long zero = firstDigits2.chars().filter(ch -> ch == '0').count();
		long one = firstDigits2.chars().filter(ch -> ch == '1').count();
		long two = firstDigits2.chars().filter(ch -> ch == '2').count();
		long three = firstDigits2.chars().filter(ch -> ch == '3').count();
		long four = firstDigits2.chars().filter(ch -> ch == '4').count();
		long five = firstDigits2.chars().filter(ch -> ch == '5').count();
		long six = firstDigits2.chars().filter(ch -> ch == '6').count();
		long seven = firstDigits2.chars().filter(ch -> ch == '7').count();
		long eight = firstDigits2.chars().filter(ch -> ch == '8').count();
		long nine = firstDigits2.chars().filter(ch -> ch == '9').count();

		// below, the 'long' amount of first digits are being converted to 'double' percentages

		// zero percent
		double zeroProb = (double) zero/size3;
		double zeroPerc = zeroProb * 100;
		zeroPerc = Math.round(zeroPerc * 100)/100;

		// one percent
		double oneProb = (double) one/size3;
		double onePerc = oneProb * 100;
		onePerc = Math.round(onePerc * 100)/100;

		// two percent
		double twoProb = (double) two/size3;
		double twoPerc = twoProb * 100;
		twoPerc = Math.round(twoPerc * 100)/100;

		// three percent
		double threeProb = (double) three/size3;
		double threePerc = threeProb * 100;
		threePerc = Math.round(threePerc * 100)/100;

		// four percent
		double fourProb = (double) four/size3;
		double fourPerc = fourProb * 100;
		fourPerc = Math.round(fourPerc * 100)/100;

		// five percent
		double fiveProb = (double) five/size3;
		double fivePerc = fiveProb * 100;
		fivePerc = Math.round(fivePerc * 100)/100;

		// six percent
		double sixProb = (double) six/size3;
		double sixPerc = sixProb * 100;
		sixPerc = Math.round(sixPerc * 100)/100;

		// seven percent
		double sevenProb = (double) seven/size3;
		double sevenPerc = sevenProb * 100;
		sevenPerc = Math.round(sevenPerc * 100)/100;

		// eight percent
		double eightProb = (double) eight/size3;
		double eightPerc = eightProb * 100;
		eightPerc = Math.round(eightPerc * 100)/100;

		// nine percent
		double nineProb = (double) nine/size3;
		double ninePerc = nineProb * 100;
		ninePerc = Math.round(ninePerc * 100)/100;	

		j++;
		if (j == size3) {
			// add the percentages of each first digit to a list of doubles
			List<Double> firstNumz = Arrays.asList(zeroPerc, onePerc, twoPerc, threePerc,
				fourPerc, fivePerc, sixPerc, sevenPerc, eightPerc, ninePerc);
			// add the amount of each first digit to a list of longs
			List<Long> firstInt = Arrays.asList(zero, one, two, three,
				four, five, six, seven, eight, nine);
			// send the list of percentages, list of amount of first digits, 
			//and file size to another method
			printOutput(firstNumz, firstInt, size3);
		}
	}

	public static void printOutput (List<Double> fNumz, List<Long> fInt, int fSize) {
		// start printing output
		System.out.println("--------------------------------");
		System.out.println("Leading Digit   Count          %");
		// take each double and long out of the lists and print them, making sure to
		//format the percentages to all be lined up on the decimal						
		System.out.printf("0	   	"+fInt.get(0)+"	"+"%7.2f", fNumz.get(0));
		System.out.print("%");
		System.out.printf("\n1	   	"+fInt.get(1)+"	"+"%7.2f", fNumz.get(1));
		System.out.print("%");
		System.out.printf("\n2	   	"+fInt.get(2)+"	"+"%7.2f", fNumz.get(2));
		System.out.print("%");
		System.out.printf("\n3	   	"+fInt.get(3)+"	"+"%7.2f", fNumz.get(3));
		System.out.print("%");
		System.out.printf("\n4	   	"+fInt.get(4)+"	"+"%7.2f", fNumz.get(4));
		System.out.print("%");
		System.out.printf("\n5	   	"+fInt.get(5)+"	"+"%7.2f", fNumz.get(5));
		System.out.print("%");
		System.out.printf("\n6	   	"+fInt.get(6)+"	"+"%7.2f", fNumz.get(6));
		System.out.print("%");
		System.out.printf("\n7	   	"+fInt.get(7)+"	"+"%7.2f", fNumz.get(7));
		System.out.print("%");
		System.out.printf("\n8	   	"+fInt.get(8)+"	"+"%7.2f", fNumz.get(8));
		System.out.print("%");
		System.out.printf("\n9	   	"+fInt.get(9)+"	"+"%7.2f", fNumz.get(9));
		System.out.print("%");
		System.out.print("\n--------------------------------");
		// print the size of the file (amount of lines in the file)
		// if/else statements to make sure the 100.00% is lined up corectly
		if (fSize >= 0 && fSize<= 99) {
			System.out.println("\nTotal		"+fSize+"       100.00%");
		}
		else {
			if (fSize >= 100 && fSize <= 999) {
				System.out.println("\nTotal		"+fSize+"      100.00%");
		}
		else {
			if (fSize >= 1000 && fSize <= 9999) {
				System.out.println("\nTotal		"+fSize+"     100.00%");		
				}
		else {
			System.out.println("\nTotal		"+fSize+"    100.00%");
				}
			}	
		}
		System.out.print("--------------------------------");
	}
}




