import java.util.Arrays;

public class Count123Steps {
	public static void main(String [] args) {
		int [] memo = new int[21];
		Arrays.fill(memo, -1);
		System.out.println(step(20, memo));
	}
	public static int step(int n, int [] memo) {
		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;
		else if (memo[n] > -1)
			return memo[n];
		else {
			memo[n] = step(n-1, memo) + step(n-2, memo) + step(n-3, memo);
			return memo[n];
		}
	}
}