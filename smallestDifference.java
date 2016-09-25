import java.util.*;

public class smallestDifference {
  public static void main(String args[]) {
    System.out.println(getsmallestDifference(new int[]{1,3,7,7,7,7,7,7,7,15,11,2},new int[]{23,127,235, 19,8}));
  }

  public static int getsmallestDifference(int [] a, int [] b) {
    int aptr, bptr, minDiff = Integer.MAX_VALUE, currMin, delta;

    int ai = 0, bi = 0;

    Arrays.sort(a);
    Arrays.sort(b);

    while (ai < a.length && bi < b.length) {
      delta = a[ai] - b[bi];
      currMin = Math.abs(delta);
      minDiff = Math.min(currMin, minDiff);
      if (minDiff == 0)
        return minDiff;
      else if (delta > 0)
        bi++;
      else if (delta < 0) {
          ai++;
      }
    }

    return minDiff;
  }
}
