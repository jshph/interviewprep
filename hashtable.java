import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		HashTable h = new HashTable(3);
		h.put(13, "a");
		h.put(14, "b");
		h.put(4, "c");
		h.put(3, "d");
		h.put(4, "e");
		h.print();
	}
}

class HashTable {
	private class Entry {
		int key;
		String value;
	}
	ArrayList<Entry []> entries;
	int bucketSize;
	public HashTable(int bucketSize) {
		this.entries = new ArrayList<Entry []>();
		this.bucketSize = bucketSize;
		for (int i = 0; i < 10; i++) {
			this.entries.set(i, new Entry [bucketSize]);
		}
	}
	public boolean put(int key, String value) {
		int hash = key % entries.size();
		int bucketPos = 0;
		while (entries.get(hash)[bucketPos] != null)
			bucketPos++;
		if (bucketPos >= bucketSize) return false;
		entries.get(hash)[bucketPos].value = value; //keyword required?
		entries.get(hash)[bucketPos].key = key; //keyword required?
		return true;
	}
	public void print() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < bucketSize; j++) {
				System.out.print(this.entries.get(i)[j].value + " ");
			}
			System.out.println();
		}
	}
}