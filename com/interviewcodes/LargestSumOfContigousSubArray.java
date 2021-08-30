package com.interviewcodes;

public class LargestSumOfContigousSubArray {

	static int largestSum(int arr[]) {

		int currentMaximum = arr[0];
		int maxSoFar = arr[0];

		for (int i = 1; i < arr.length; i++) {

			currentMaximum = Math.max(arr[i], currentMaximum + arr[i]);
			maxSoFar = Math.max(maxSoFar, currentMaximum);
		}

		return maxSoFar;
	}

	public static void main(String[] args) {

		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

		System.out.println(largestSum(a));

		System.out.println(2 ^ 1);

		System.out.println(Double.valueOf(3) / 2);

	}
}
