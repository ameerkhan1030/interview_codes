package com.interviewcodes.pattern;

import java.util.Scanner;

public class Pattern {

	static void pyramid(int number) {

		System.out.println("Pyramid");
		for (int i = 1; i <= number; i++) {

			for (int k = 1; k <= number - i; k++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {

				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void rightTriangle(int number) {

		System.out.println("Right Triangle");
		for (int i = 0; i < number; i++) {

			for (int j = 0; j <= i; j++) {

				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void leftTriangle(int number) {

		System.out.println("Left Triangle");
		for (int i = 1; i <= number; i++) {

			for (int k = 1; k <= (number - i) * 2; k++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {

				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void diamond(int number) {

		System.out.println("Diamond");

		int middle = number / 2;

		int numberOfStars = 0;

		boolean upperPart = true;
		for (int i = 1; i <= number; i++) {

			for (int j = 1; j <= middle; j++) {
				System.out.print(" ");
			}

			if (upperPart) {
				numberOfStars = 2 * i - 1;
			} else {
				numberOfStars = 1 + (2 * (number - i));
			}

			for (int j = 1; j <= numberOfStars; j++) {
				System.out.print("*");
			}

			if (middle == 0 || upperPart == false) {
				middle++;
				upperPart = false;
			} else {
				middle--;
			}
			System.out.println();
		}

	}

	static void xPattern(int n) {

		System.out.println("X Pattern");
		int left = 1, right = n;

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {

				if (left == j || right == j) {
					System.out.print(j);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			left++;
			right--;

		}

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Number : ");
		int number = scanner.nextInt();
		pyramid(number);
		rightTriangle(number);
		leftTriangle(number);
		diamond(number);
		xPattern(number);
		scanner.close();
	}
}
