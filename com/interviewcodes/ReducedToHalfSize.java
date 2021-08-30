package com.interviewcodes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducedToHalfSize {

	static Integer minimumSet(int arr[]) {

		// Grouping the data based on key
		Map<Integer, Long> frequencyMap = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// Reverse ordering based on frequencies
		Stream<Map.Entry<Integer, Long>> sorted = frequencyMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));

		int halfSize = arr.length / 2;

		int count = 0;
		for (Iterator<Map.Entry<Integer, Long>> it = sorted.iterator(); it.hasNext();) {

			if (halfSize <= 0) {
				break;
			}
			halfSize -= it.next().getValue();
			count++;
		}

		return count;
	}
	public static void main(String[] args) {

		int arr[] = { 1, 2, 4, 4, 4, 3, 3, 3, 3, 2, 2, 1 };


		System.out.println(minimumSet(arr));

	}
}
