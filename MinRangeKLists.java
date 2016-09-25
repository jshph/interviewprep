import java.util.PriorityQueue;

public class MinRangeKLists {
	public static void main(String args[]) {

	}

	public static int [] returnMinRange(List<List<Integer>>) {
		int [] minAry = new int [2];

		PriorityQueue<Integer, AssocIndex> minHeap = new PriorityQueue<>();
		//int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < lists.length; i++) {
			minHeap.add(new AssocIndex(lists[i][0], 0, lists[i]));
		}

		do {

		} while ()
	}

	public static int findGreaterThanMin(int [] array, int index, int heapMin) {
		while (array[index] < heapMin)
			index++;
		return array[index];
	}

	private class AssocIndex implements Comparable{
		public int value;
		public int index;
		public int [] array;
		public AssocIndex(int value, int index, int [] array) {
			this.value = value;
			this.index = index;
			this.array = array;
		}
		@Override
		public int compareTo(AssocIndex y) {
			return this.value - y.value;
		}
	}
}