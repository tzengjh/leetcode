
public class Solution{
	public char findTheDifference(String s, String t) {
		int charCode = t.charAt(s.length());
		for(int i = 0; i < s.length(); i++){
			charCode = charCode + t.charAt(i) - s.charAt(i);
		}
		return (char) charCode;
	}	
}
