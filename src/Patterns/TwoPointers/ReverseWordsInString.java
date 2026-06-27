package Patterns.TwoPointers;

public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "   hello    world     ";
		System.out.println(reverseWords(s));

	}

	public static String reverseWords(String s) {
		
		//to eliminate trailing and leading spaces.
		int i = 0,  j =s.length()-1;
		
		while(!Character.isLetterOrDigit(s.charAt(i)))
			i++;
		
		while(!Character.isLetterOrDigit(s.charAt(j)))
			j--;
		
		//hello          world
		
		//to eliminate spaces inside
		int l = i;
		StringBuilder sb = new StringBuilder();
		while(l<=j) {
			
			if(Character.isLetterOrDigit(s.charAt(l)))
				sb.append(s.charAt(l));
			else {
				
				if(Character.isLetterOrDigit(sb.charAt(sb.length()-1))) {
					sb.append(s.charAt(l));
				}
			}
			l++;
		}
		
		//hello world
		
		//reverse the string builder
		sb.reverse();
		
		//dlrow olleh
	           	
		int end = 0, start=0;
		StringBuilder ans = new StringBuilder();
		while(end<sb.length()) {
			
			
			//if found ' ' reverse the words letters 
			if(sb.charAt(end)==' '  )
				
			{
				int k = end-1;
				while (start<k) {
					
					char temp = sb.charAt(k);
					sb.setCharAt(k, sb.charAt(start));
					sb.setCharAt(start, temp);
					start++;
					k--;
				}
				end++;
				start=end;
			}
			
			//if reaching the end of string 
			else if(end ==sb.length()-1){
				int k = end;
				while (start<k) {
					
					char temp = sb.charAt(k);
					sb.setCharAt(k, sb.charAt(start));
					sb.setCharAt(start, temp);
					start++;
					k--;
				}
				end++;
				start=end;
			}
			else
				end++;
			 
		}
		
		
		
		return new String(sb);
		
	
	}
	

	
	
	public static String reverseWords_naive(String s) {

		//to remove the leading and trailing spaces in string => returns a modified String.
		String rmTrailLeadSpaces = s.trim();
		
		//split (regex to match one or more spaces) => return array of split string
		String arr[] = rmTrailLeadSpaces.split("\\s+");

		//reverse the split string  by words
		int start = 0, end = arr.length - 1;
		while (start <end) {
			String temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		
		}
		
		//mutable string => string builder
		StringBuilder sb = new StringBuilder();
		for(String iter : arr) {
			sb.append(iter);
			sb.append(" ");
		}
		return new String(sb).trim();

	}
}
