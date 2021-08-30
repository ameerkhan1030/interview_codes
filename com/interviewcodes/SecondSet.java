import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SecondSet {

	static class MinMax{
		
		int minimum;
		
		int maxinum;
		
		public MinMax(int min,int max) {
			
			minimum = min;
			maxinum = max;
		}

		public int getMinimum() {
			return minimum;
		}

		public void setMinimum(int minimum) {
			this.minimum = minimum;
		}

		public int getMaxinum() {
			return maxinum;
		}

		public void setMaxinum(int maxinum) {
			this.maxinum = maxinum;
		}
		
		
	}
	static int maxNumberOfCharsBWAnySameChars(String str) {
	
		int max = -1;
		if(str == null || str.length() == 0) {
			return max;
		}
		
		Map<Character,MinMax> charaterWithMinMax = new HashMap<Character, MinMax>();
		
		for (int i = 0; i < str.length(); i++) {
		
			if(charaterWithMinMax.get(str.charAt(i)) != null) {
				
				MinMax minMax = charaterWithMinMax.get(str.charAt(i));
				
				minMax.setMaxinum(i);
			}else {
				MinMax minMax = new MinMax(i,i);
				charaterWithMinMax.put(str.charAt(i), minMax);
			}
		}

		for (Character character : charaterWithMinMax.keySet()) {

			if (charaterWithMinMax.get(character) != null && charaterWithMinMax.get(character).maxinum > 1) {
				max = Math.max(max, charaterWithMinMax.get(character).maxinum - (1+charaterWithMinMax.get(character).minimum));
			}
		}
		
		return max;
	}
	
	static void sortingElementBasedOnRank(int array[],int rank[]) {
		
		if(array.length == 0 || rank.length ==0) {
			System.out.println("Both Elements shouldnt null or empty");
			return;
		}
		
		Map<Integer, Integer> elementWithRank = new LinkedHashMap<Integer,Integer>();
		
		List<Integer> elementInList = new ArrayList<Integer>();
		
		for (int i = 0; i < array.length; i++) {
			
			elementWithRank.put(array[i], rank[i]);
			elementInList.add(array[i]);
		}
		
		Comparator<Integer> elementComparatorBasedOnRank = (Integer i,Integer j) -> {
			
			int rankComparison = elementWithRank.get(i).compareTo(elementWithRank.get(j));
			
			int elementComparison = i.compareTo(j);
			
			if(rankComparison == 0) {
				return elementComparison;
			}else {
				return rankComparison;
			}
		};
		
		Collections.sort(elementInList, elementComparatorBasedOnRank);
		
		System.out.println(elementInList);
		
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Enter String for find out max number of characters ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		System.out.println(maxNumberOfCharsBWAnySameChars(str));
		
		
		System.out.println("Enter the elements : ");
		String elements = scanner.nextLine();
		String[] characters = elements.split(",");

		int array[] = new int[characters.length];

		for (int i = 0; i < characters.length; i++) {
			array[i] = Integer.parseInt(characters[i]);
		}
		
		System.out.println("Enter the respective Rank : ");
		
		String ranks = scanner.nextLine();
		String[] characterRanks = ranks.split(",");

		int rank[] = new int[characterRanks.length];

		for (int i = 0; i < characterRanks.length; i++) {
			rank[i] = Integer.parseInt(characterRanks[i]);
		}
		sortingElementBasedOnRank(array, rank);
		scanner.close();
		
	}
}
