package com.sort.app;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mergen
 *
 */
public class App {
	private ISort algorithm;

	public App() { // for use in GUI mode.
	}

	private App(int args) { // for use in console mode.

		Scanner input = new Scanner(System.in);
		boolean isRunning = true;

		while (isRunning) { // to keep the application running until user inputs
							// 0

			String array;
			do {
				System.out
						.print("Enter integer array separated by ,[comma] for example 3,2,1: ");
				array = input.nextLine();
				if (!validateInput(array)) {
					System.out.println("Invalid input!");
				}
			} while (!validateInput(array));

			int[] arrayToSort = stringToIntArray(array);

			System.out
					.print("1 - Bubble sorting\n"
							+ "2 - Quick sorting\n"
							+ "3 - Merge sorting\n"
							+ "4 - Selection sorting\n"
							+ "5 - Insertion sorting\n"
							+ "Enter the corresponding integer of sorting algorithm or 0 to terminate: ");

			String array2;
			boolean isValid = false;
			while (isValid == false) {
				algorithm = null;
				do {
					array2 = input.nextLine();
					if (!validateInputForSwitch(array2)) {
						System.out.println("Invalid input! Try again:");
					}
				} while (!validateInput(array2));

				int value = stringToInt(array2);

				switch (value) {
				case 0:
					isValid = true;
					isRunning = false;
					break;
				case 1:
					algorithm = new Bubble();
					isValid = true;
					break;
				case 2:
					algorithm = new Quick();
					isValid = true;
					break;
				case 3:
					algorithm = new Merge();
					isValid = true;
					break;
				case 4:
					algorithm = new Selection();
					isValid = true;
					break;
				case 5:
					algorithm = new Insertion();
					isValid = true;
					break;
				default:
					System.out
							.println("Please enter an integer between 1 and 5");
				}
			}
			if (algorithm != null) {
				final long startTime = System.currentTimeMillis();

				System.out.print(algorithm.toString() + " Sorted: "
						+ Arrays.toString(algorithm.sort(arrayToSort)) + "\n");

				final long endTime = System.currentTimeMillis();
				System.out.println("Finished in " + (endTime - startTime)
						+ "ms.\n");
			}
		}

		input.close();
	}

	public static void main(String[] args) {
		new App(0);
	}

	// to validate the integer array input from user
	public static boolean validateInput(String input) {
		Pattern pattern = Pattern
				.compile("(\\s)*(\\d+(\\s)*,(\\s)*)*(\\s)*\\d+(\\s)*");
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	// to split by commas, trim the spaces and change from String[] to int[]
	public static int[] stringToIntArray(String commaSeparatedString) {
		String[] stringArray = commaSeparatedString.split(",");
		int[] result = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			result[i] = Integer.valueOf(stringArray[i].trim());
		}
		return result;
	}

	// to validate input from user for use in switch statement
	public static boolean validateInputForSwitch(String input) {
		Pattern pattern = Pattern.compile("(\\s)*(\\d)(\\s)*");
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	// to trim the spaces and change from String to int
	public static int stringToInt(String string) {
		int result = Integer.valueOf(string.trim());
		return result;
	}

	public ISort getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(ISort algorithm) {
		this.algorithm = algorithm;
	}
}
