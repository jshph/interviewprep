import java.util.List;
import java.util.PriorityQueue;

public class PrimeExpressible {
	public static void main(String args[]) {

	}

	public static int nthExp(List<Integer> primes, int n) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (Integer num : primes) {
			minHeap.add(num);
		}

		while (minHeap.size() < n && ) {

		}
	}
}