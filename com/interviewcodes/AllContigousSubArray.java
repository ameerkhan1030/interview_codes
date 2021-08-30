package com.interviewcodes;

import java.util.ArrayList;
import java.util.List;

public class AllContigousSubArray {

	static void allSubSet(int arr[]) {

		int n = arr.length;

		List<List<Integer>> allSubArrays = new ArrayList<List<Integer>>();
		// Run a loop for printing all 2^n
		// subsets one by one
		for (int i = 0; i < (1 << n); i++) {

			List<Integer> subArray = new ArrayList<Integer>();
			// Print current subset
			for (int j = 0; j < n; j++) {

				// (1<<j) is a number with jth bit 1
				// so when we 'and' them with the
				// subset number we get which numbers
				// are present in the subset and which
				// are not
				if ((i & (1 << j)) > 0)
					subArray.add(arr[j]);

			}
			allSubArrays.add(subArray);

		}

		for (List<Integer> list : allSubArrays) {

			System.out.println(list);
		}
	}

	static void allContigousSubArray(int arr[]) {

		List<List<Integer>> allSubArrays = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; j++) {

				List<Integer> subArray = new ArrayList<Integer>();
				for (int k = i; k <= j; k++) {

					// System.out.print(arr[k]);
					subArray.add(arr[k]);
				}
				allSubArrays.add(subArray);
				// System.out.println();
			}
		}

		int maxSize = 0;
		for (List<Integer> list : allSubArrays) {

			maxSize = Math.max(maxSize, list.size());
			System.out.println(list);
		}

		System.out.println("Maximum Size subArray " + maxSize);
	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4 };

		allContigousSubArray(a);

		allSubSet(a);

	}
}
