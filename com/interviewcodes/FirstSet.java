import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FirstSet {

	static void pyramid(int number) {

		if (number == 0) {
			return;
		}

		// no of rows
		int count = number;

		for (int i = 1; i <= number; i++) {

			// for spaces
			for (int j = 1; j < count; j++) {

				System.out.print(" ");
			}

			boolean rightSide = false;
			int right = i;
			for (int j = 1; j <= 1 + (2 * (i - 1)); j++) {
				int left = j;
				
				if (rightSide) {
					System.out.print(--right);
				} else {
					System.out.print(left++);
				}

				if (left-1 == i) {
					rightSide = true;
				}
			}
			System.out.println();
			count--;

		}
	}

	static Object[] modifiedArray(int arr[], int k) {

		if (arr.length == 0) {
			System.out.println("Empty Array");
			return null;
		}

		List<Integer> result = new ArrayList<Integer>();

		int dataToInsert[] = { 0, 1 };

		int indexForDataToInsert = 0;
		int increment = 1;
		for (int i = 0; i < arr.length; i = i + increment) {

			int j = i;
			increment = 1;
			if (arr[j] == 1) {

				// creating another list for inserting modified data in result array
				List<Integer> subList = new ArrayList<Integer>();
				subList.add(arr[i]);
				do {
					j = j + 1;
					if (j < arr.length && arr[j] == 1) {
						subList.add(arr[i]);
						increment++;
					} else {
						break;
					}

				}while (increment < k);

				// More than 1
				if (increment == k) {
					subList.add(dataToInsert[indexForDataToInsert]);
					result.addAll(subList);
					indexForDataToInsert = indexForDataToInsert == 0 ? 1 : 0;
				} else {
					result.addAll(subList);
				}

			} else {
				result.add(arr[i]);
			}
		}

		return result.toArray();
	}

	public static void main(String[] args) {

		System.out.println("Enter Numbers for Modification ");
		Scanner number = new Scanner(System.in);
		String numbers = number.nextLine();
		System.out.println("Enter Kth Time ");
		int k = number.nextInt();
		char[] characters = numbers.toCharArray();

		int array[] = new int[characters.length];

		for (int i = 0; i < characters.length; i++) {
			array[i] = characters[i] - '0';
		}

		Object result[] = modifiedArray(array,k);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();

		System.out.println("----");
		System.out.println("Enter Number for pyramid : ");

		pyramid(number.nextInt());
		number.close();
	}
}
