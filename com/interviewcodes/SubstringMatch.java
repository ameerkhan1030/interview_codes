package com.interviewcodes;

public class SubstringMatch {

	static boolean isMatch(char charsPattern[], char actualValue) {

		boolean result = false;

		return result;
	}

	static boolean isSubstring(char value[], char[] substring) {

		int count = 0;
		boolean result = false;

		for (int i = 0; i < value.length; i++) {

			if (value[i] == substring[count]) {
				count++;
			} else {
				count = 0;
			}

			if (count == substring.length) {
				result = true;
				break;
			}
		}

		return result;
	}

	static String mirrorCharcters(char values[]) {

		String reverseAlphabet = "zyxwvutsrqponmlkjihgfedcba";

		String answer = "";

		for (int i = 0; i < values.length; i++) {
			answer = answer + reverseAlphabet.charAt(values[i] - 'a');
		}
		return answer;

	}

	static char[] fillAlternateDuplicateWithZero(char values[]) {


		for (int i = 0; i < values.length - 1; i++) {

			for (int j = i + 1; j < values.length; j++) {

				if (values[i] == values[j]) {
					values[j] = '0';
					break;
				}
			}

		}
		return values;
	}

	public static void main(String[] args) {

		String string = "Hello world";
		String substring = "ld";
		

		System.out.println(isSubstring(string.toCharArray(), substring.toCharArray()));

		System.out.println(mirrorCharcters(substring.toCharArray()));

		System.out.println(fillAlternateDuplicateWithZero("2235636".toCharArray()));
	}

}
