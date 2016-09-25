import java.util.*;

public class BestLine {
	public static class Point {
		int x;
		int y;
		public Point(int x, int y) { this.x = x; this.y = y; }
		public double slope(Point pt2) {
			if (pt2.x == this.x)
				return Integer.MAX_VALUE;
			if (pt2.y == this.y)
				return 0;
			return ((double)pt2.y - this.y)/ ((double)pt2.x - this.x);
		}
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	public static class Line {
		double slope;
		int x1;
		int y1;
		public Line(int x, int y, double slope) {
			this.x1 = x; this.y1 = y; this.slope = slope;
		}
		public boolean colinear(int x, int y) {
			return (y - (double)y1) == (slope * (x - x1));
		}
		public String toString() {
			return slope + "x" + "+" + (slope * -x1 + y1);
		}
	}
	public static void main(String args[]) {
		HashMap<String, HashSet<Point>> histogram = new HashMap<>();
		LinkedList<Point> ptlist = new LinkedList<Point>();
		ptlist.add(new Point(1,3));
		ptlist.add(new Point(3,1));
		ptlist.add(new Point(5,-1));
		ptlist.add(new Point(5,2));
		ptlist.add(new Point(3,0));
		ptlist.add(new Point(7,3));
		ptlist.add(new Point(9,4));

		for (Point pt : ptlist) {
			for (Point pt2 : ptlist) {
				Line line = new Line(pt.x, pt.y, pt.slope(pt2));
				//System.out.println(pt + ", " + pt2 + ": " + slope);
				System.out.println(line);
				if (!histogram.containsKey(line.toString())) {
					histogram.put(line.toString(), new HashSet<Point>());
				}
				histogram.get(line.toString()).add(pt);
				histogram.get(line.toString()).add(pt2);
			}
		}

		String maxslope = "";
		double maxpoints = 0;
		for (Map.Entry<String, HashSet<Point>> h : histogram.entrySet()) {
			if (h.getValue().size() > maxpoints) {
				maxslope = h.getKey();
				maxpoints = h.getValue().size();
			}
		}
		System.out.println(maxslope);
		System.out.println(maxpoints);		
	}

}