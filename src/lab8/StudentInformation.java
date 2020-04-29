package lab8;

import java.io.NotActiveException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInformation {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean information = true;

		while (information) {
			String[] serialKillerName = new String[10];

			serialKillerName[0] = "Paul John Knowles";
			serialKillerName[1] = "Twiggy Ramirez";
			serialKillerName[2] = "Patrick Kearney";
			serialKillerName[3] = "Earle Nelson";
			serialKillerName[4] = "Ronald Dominique";
			serialKillerName[5] = "Charles Manson";
			serialKillerName[6] = "John Wayne Gacy";
			serialKillerName[7] = "Ted Bundy";
			serialKillerName[8] = "Gary Ridgway";
			serialKillerName[9] = "Samuel Little";

			int userInt = getSerialKiller(scnr, serialKillerName);
			scnr.nextLine();

			printDetails(scnr, serialKillerName, userInt);

			System.out.println("Would you like to continue? (enter \"yes\" or \"no\")");
			String answer = scnr.nextLine().toLowerCase();

			if (!answer.equals("yes")) {
				information = false;
				System.out.println("Thanks for learning about serial killers! Goodbye!");
			}
		}
	}

	private static int getSerialKiller(Scanner scnr, String[] name) {
		System.out.print("Welcome to our Java class. " + "Which serial killer would you like to learn"
				+ " more about? (enter a number 1-10)");

		int userInt = 0;

		System.out.println();

		boolean correctInt = false;

		while (!correctInt) {

			try {
				userInt = scnr.nextInt();
				System.out.println(name[userInt] + ", is serial killer number " + userInt + ".");
				correctInt = true;
			} catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
				scnr.nextLine();
				System.out.println("That serial killer does not exist. Please try again. (enter a number 1-10)");
			}
		}
		return userInt;
	}

	private static void printDetails(Scanner scnr, String[] name, int userInt) {
		System.out.println("Would you like know where " + name[userInt]
				+ " was born or how many victims he had? (enter hometown or victims)");

		String userString = "";

		boolean correctString = false;
		String[] hometown = new String[10];
		int[] numVictims = new int[10];

		hometown[0] = "Orlando, FL";
		hometown[1] = "El Paso, TX";
		hometown[2] = "Los Angeles, CA";
		hometown[3] = "San Francisco, CA";
		hometown[4] = "Houma, LA";
		hometown[5] = "Cincinnati, OH";
		hometown[6] = "Chicago, IL";
		hometown[7] = "Burlington, VT";
		hometown[8] = "Salt Lake City, UT";
		hometown[9] = "Reynolds, GA";

		numVictims[0] = 35;
		numVictims[1] = 14;
		numVictims[2] = 43;
		numVictims[3] = 22;
		numVictims[4] = 23;
		numVictims[5] = 9;
		numVictims[6] = 33;
		numVictims[7] = 30;
		numVictims[8] = 71;
		numVictims[9] = 93;

		while (!correctString) {
			userString = scnr.nextLine().toLowerCase();
			if (userString.equals("hometown")) {
				System.out.println(name[userInt] + " was born in " + hometown[userInt] + ".");
				correctString = true;
			} else if (userString.equals("victims")) {
				System.out.println(name[userInt] + " took a reported " + numVictims[userInt] + " lives.");
				correctString = true;
			} else {
				System.out.println("That data does not exist. Please try again. (enter \"hometown\" or \"victims\")");
			}
		}
	}
}
