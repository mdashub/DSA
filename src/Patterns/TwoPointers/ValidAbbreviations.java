package Patterns.TwoPointers;

public class ValidAbbreviations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String word = "apple";
		// String abbr = "a3e";

		String word = "internationalization";
		String abbr = "i18n";
		System.out.println(validWordAbbreviation(word, abbr));
	}

	public static boolean validWordAbbreviation(String word, String abbr) {

		int i_abbr = 0;
		int j_word = 0;

		// pointers should be in range
		while (i_abbr < abbr.length() && j_word < word.length()) {

			// check for numbers in abbr
			if (Character.isDigit(abbr.charAt(i_abbr)))

			{
				// if leading zero X
				if ((abbr.charAt(i_abbr) - '0') == 0)
					return false;
				
				
				//get the number in abbr
				int sum = 0;
				while (i_abbr < abbr.length() && Character.isDigit(abbr.charAt(i_abbr)))
					sum = sum * 10 + (abbr.charAt(i_abbr++) - '0');
				
				i_abbr --;
				j_word = j_word + sum - 1;
			}

			else if (abbr.charAt(i_abbr) != word.charAt(j_word))
				return false;

			j_word++;
			i_abbr++;
		}

		// both the pointer have reached the end of string.
		boolean flag = ((i_abbr == abbr.length()) && (j_word == word.length())) ? true : false;
		return flag;
	}
	

}
