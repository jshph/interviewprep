import java.util.Scanner;

public class MaxContigSubseqSum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int aSize;
		while (sc.hasNext()) {
			aSize = sc.nextInt();
			int [] ary = new int [aSize];
			int [] memo = new int [aSize];
			for (int i = 0; i < aSize; i++) {
				ary[i] = sc.nextInt();
				System.out.print(ary[i] + " ");
				memo[i] = 0;
			}
			System.out.println();
			System.out.println(maxSumDP(ary.length -1, ary, memo));
			for (int i = 0 ; i < aSize; i++) {
				System.out.print(memo[i] + " ");
			}
		}
	}
	public static int maxSumDP(int index, int [] ary, int [] memo) {
		int maxBeforeI;
		if (index < 1)
			return ary[0];
		if (memo[index - 1] != 0)
			maxBeforeI = memo[index-1];
		else {
			maxBeforeI = maxSumDP(index - 1, ary, memo);
			memo[index - 1] = maxBeforeI;
		}
		return Math.max(maxSumDP(index - 1, ary, memo) + ary[index], ary[index]);
	}

}