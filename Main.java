public class Main {
	public static void main(String args[]) {
		HashTable h = new HashTable(3);
		h.put(13, "a");
		h.put(14, "b");
		h.put(4, "c");
		h.put(3, "d");
		h.put(4, "e");
		h.put(4, "f");
		h.print();
	}
}

class HashTable {
	private class Entry {
		int key;
		String value;
		public Entry(int k, String v) {
			key = k;
			value = v;
		}
		public void setValue(String v) { value = v; }
		public void setKey(int k) { key = k; }
		public int key() {return key;}
		public String value() {return value;}
	}
	Entry [][] entries;
	int bucketSize;
	public HashTable(int b) {
		entries = new Entry [10][];
		bucketSize = b;
		for (int i = 0; i < 10; i++) {
			entries[i] = null;
		}
	}
	public boolean put(int key, String value) {
		int hash = key % 10;
		int bucketPos = 0;
		if (entries[hash] == null) {
			entries[hash] = new Entry[bucketSize];
			for (int i = 0; i < bucketSize; i++) entries[hash][i] = null;
			entries[hash][0] = new Entry(key, value);
			return true;
		} else {
			while (bucketPos < bucketSize && entries[hash][bucketPos] != null)
				bucketPos++;
			if (bucketPos >= bucketSize) {
				System.out.println("yelling");
				return false;
			}
			entries[hash][bucketPos] = new Entry(key, value);
			return true;
		}
	}
	public void print() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + ": ");
			if (entries[i] != null)
				for (int j = 0; j < bucketSize; j++) {
					Entry e = entries[i][j];
					if (e != null)
						System.out.print(e.value() + " ");
				}
			System.out.println();
		}
	}
}