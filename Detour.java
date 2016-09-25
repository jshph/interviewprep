import java.util.Scanner;

public class Detour {
	private static class LatLong {
		double lt;
		double lg;
		public LatLong(double lt, double lg) {
			this.lt = lt;
			this.lg = lg;
		}
	}
	private static class Journey {
		LatLong origin;
		LatLong dest;
		private double dist;
		public Journey(LatLong origin, LatLong dest) {
			this.origin = origin;
			this.dest = dest;
			this.dist = Math.sqrt(Math.pow(dest.lg - origin.lg, 2) + Math.pow(dest.lt - origin.lt, 2));
		}
		public double getDist() { return this.dist; }

	}

	private double shorterDist; 

	public Detour(LatLong dr1_o, LatLong dr1_d, LatLong dr2_o, LatLong dr2_d) {
		// Compare |dr2_o-dr1_o| + |dr1_d-dr1_o| + |dr2_d-dr1_d| vs. |dr1_o-dr2_o| + |dr2_d-dr2_o| + |dr1_d-dr2_d|,
		// the total distance traveled in trip ... reduced to |dr1_d`-dr1_o| vs. |dr2_d-dr2_o| as the total difference
		double dr1_dist = (new Journey(dr1_o, dr1_d)).getDist();
		System.out.println(dr1_dist);
		double dr2_dist = (new Journey(dr2_o, dr2_d)).getDist();
		System.out.println(dr2_dist);
		this.shorterDist = dr1_dist < dr2_dist ? dr1_dist : dr2_dist;
	}

	public double getShorterDist() { return this.shorterDist; }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		LatLong dr1_o = new LatLong(sc.nextDouble(), sc.nextDouble());
		LatLong dr1_d = new LatLong(sc.nextDouble(), sc.nextDouble());
		LatLong dr2_o = new LatLong(sc.nextDouble(), sc.nextDouble());
		LatLong dr2_d = new LatLong(sc.nextDouble(), sc.nextDouble());
		System.out.println((new Detour(dr1_o, dr1_d, dr2_o, dr2_d)).getShorterDist());
	}
}