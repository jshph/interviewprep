public class CoinDenoms {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int numDs = sc.nextInt();
		int [] denoms = new int[numDs];
		for (int i = 0; i < numDs; i++)
			denoms[i] = sc.nextInt();
		System.out.println(countCoins(denoms, sum, 0, "", new int [sum + 1][denoms.length]));
	}

	public static int countCoins(int [] denoms, int rem, int denomIndex, String combi, int [][] map) {
		if (denomIndex < map[0].length && map[rem][denomIndex] > 0)
			 return map[rem][denomIndex];
		else if (rem < 0)
			return 0;
		else if (rem == 0) {
			System.out.println(combi);
			return 1;
		}
		else if (denomIndex >= denoms.length)
			return 0;

		int numWays = 0;
		for (int i = 0; i * denoms[denomIndex] <= rem; i++) {
			if (i > 0) combi = combi + denoms[denomIndex] + "";
			numWays += countCoins(denoms, rem - i*denoms[denomIndex], denomIndex+1, combi, map);
		}
		map[rem][denomIndex] = numWays;
		return numWays;
	}
}