public class MergeSort {
	public static void main(String args[]) {
		int [] ary = {0, 3, 4, 7, 5, 6, 10, 14, 13};
		// TRACE:
		// mid index = 8 / 2 = 4.
		// partitions are: {0 3 4 7 5} {6 10 14 13}
		// {0 3 4} {7 5}  --  {6 10} {14 13}
		ary = mergeSort(ary);
		for (int i = 0; i < ary.length; i++) {
			System.out.print(ary[i] + " ");
		}
	}

	public static int [] mergeSort(int [] a) {
		mergeSort(a, new int [a.length], 0, a.length - 1);
		return a;
	}

	// mergeSort serves only to partition into a into many sections to be handled by different mergesort calls.
	public static void mergeSort(int [] a, int [] aux, int lo, int hi) {
		if (hi <= lo) return; // base case, hi index has shrunken to lower index, empty partition
		int mid = lo + (hi - lo) / 2;
		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid + 1, hi); // aux, a are passed in by value. But a is finally modified by reference.
		merge(a, aux, lo, mid, hi); // merges partitions from lo -> mid and mid + 1 -> hi.
	}

	// Merge is called on the smallest sections, then on the small sorted sections.
	// why does merge work on two sorted sections? The intermediate elements are merged normally, and then the first element of the tail array that simply gets copied is guaranteed to be larger than all previous elements. 
	public static void merge(int [] a, int [] aux, int lo, int mid, int hi) {
		// copy all values from a to aux temporarily. values will be finally modified in a
		for (int i = lo; i <= hi; i++) {
			// precondition: this section of a being copied has been sorted, possibly by innermost calls of mergeSort.
			aux[i] = a[i];
			// postcondition: the corresponding section of aux reflects a.
		}

		// initialize partition runners.
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			System.out.println(hi);
			if (i > mid)
				a[k] = aux[j++]; // after this point i is no longer modified in the loop. Copy j -> end to a.
			else if (j > hi)
				a[k] = aux[i++]; // same as above for j.
			else if (aux[j] < aux[i])
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
		// loop that compares values in aux, to merge to a.
	}
}