/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

	private static class BySlope implements Comparator<Point> {

		private Point inputP;

		public BySlope(Point point) {
			inputP = point;
		}

		@Override
		public int compare(Point p1, Point p2) {
			if (p1 == null || p2 == null) {
				throw new java.lang.NullPointerException();
			}
			double slopP1 = inputP.slopeTo(p1);
			double slopP2 = inputP.slopeTo(p2);
			if (slopP1 > slopP2) {
				return 1;
			}
			if (slopP1 == slopP2) {
				return 0;
			}
			return -1;
		}

	}

	// compare points by slope
	public final Comparator<Point> SLOPE_ORDER = new BySlope(this);

	private final int x; // x coordinate
	private final int y; // y coordinate

	// create the point (x, y)
	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	// plot this point to standard drawing
	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	// draw line between this point and that point to standard drawing
	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	// slope between this point and that point
	public double slopeTo(Point that) {
		boolean equalY = (y == that.y);
		boolean equalX = (x == that.x);

		if (equalY && equalX) {
			return -1 / 0.0;
		}
		if (equalY) {
			return +0;
		}
		if (equalX) {
			return 1 / 0.0;
		}

		return (that.y - y) / (double) (that.x - x);

	}

	// is this point lexicographically smaller than that one?
	// comparing y-coordinates and breaking ties by x-coordinates
	public int compareTo(Point that) {
		if (y < that.y || (y == that.y && x < that.x))
			return -1;
		if (y == that.y && x == that.x)
			return 0;
		return 1;
	}

	// return string representation of this point
	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}

	// unit test
	public static void main(String[] args) {
		/* YOUR CODE HERE */
	}
}
