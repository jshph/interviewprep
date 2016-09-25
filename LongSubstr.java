// Longest Substring Without Repeating Characters
/*Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.*/
// - collect letters in a subsequence, adding each to a HashSet, and collecting them within a queue.
// - if HashSet contains the character, dequeue from front until character is found. Dequeue that character. 
// - update the max substring length if needed.

import java.util.*;

public class LongSubstr {
	public static void main(String args[]) {
		String test = "abcabcbb";
		System.out.println(maxSubstrLen(test));
	}

	public static int maxSubstrLen(String input) {
		HashSet<Character> hs = new HashSet<Character>();
		LinkedList<Character> q = new LinkedList<>();

		int maxLen = 0;
		while ((input = input.substring(1)).length() != 0) {
			char c = input.charAt(0);
			if (!hs.contains(c)) {
				hs.add(c);
				q.add(c);
			} else {
				q.add(c);
				while (!q.peek().equals(c)) {
					q.remove(0);
				}n
				q.remove(0);
			}
			if (q.size() > maxLen) maxLen = q.size();
		}
		return maxLen;
	}
}