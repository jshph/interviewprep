public class PoolSize {

	public static int [][] geo = {
		{0,2,1,0},
		{0,1,0,1},
		{1,1,0,1},
		{0,1,0,1}
	};

	public static void main(String args[]) {
		for (int i = 0; i < geo.length; i++) {
			for (int j = 0; j < geo[0].length; j++) {
				if (geo[i][j] == 0)
					System.out.print(dfs(i, j) + ", ");
			}
		}
	}

	public static int dfs(int i, int j) {
		if( (i) < 0 || (i) >= geo.length || j < 0 || j >= geo.length || geo[i][j] != 0)
			return 0;

		int [] dx = {0,1,0,-1,1,-1,-1, 1};
		int [] dy = {1,0,-1,0,1, 1,-1,-1};
		int size = 1;
		geo[i][j] = -1;
		for (int c = 0; c < dx.length; c++) {
			size += dfs(i+dx[c], j+dy[c]);
		}

		return size;
	}

}