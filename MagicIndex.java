0  1  2  3  4  5  6  7  8  9  10
   1     2  3        4

public static int magicIndex(int [] a) {
	int i = a.length - 1;
	while (i > 0) {
		if (a[i] < i)
			i = a[i];
		else if (a[i] == i)
			return i;
		else i--;
	}
}

// doesn't work. test case is invalid. if an element is smaller than its index,
// then moving left will decrease the index and can only decrease the element.
// Hence, index and element will never match. Possibilities exist for the right
// hand side, where element can jump.