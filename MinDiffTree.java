import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;

public class MinDiffTree {
	public static void main(String args[]) {
		// Build tree
		Scanner sc = new Scanner(System.in);
		int numnodes = sc.nextInt();
		sc.nextLine();
		String [] nodeVals_s = sc.nextLine().split(" ");
		int [] nodeVals = new int [nodeVals_s.length];
		for (int i = 0; i < nodeVals.length; i++) {
			nodeVals[i] = Integer.parseInt(nodeVals_s[i]);
		}


		HashMap<Integer, Node> nodes = new HashMap<>();
		while (sc.hasNext()){
			int node = sc.nextInt(), neighbor = sc.nextInt();

			Node newNode;
			if (!nodes.containsKey(node)) {
				newNode = new Node(node);
			} else {
				newNode = nodes.get(node);
			}
			newNode.value = nodeVals[node-1];

			Node newNeighbor;
			if (!nodes.containsKey(neighbor)) {
				newNeighbor = new Node(neighbor);
			} else {
				newNeighbor = nodes.get(neighbor);
			}
			newNeighbor.value = nodeVals[neighbor-1];

			newNode.addNeighbor(newNeighbor);
			newNeighbor.addNeighbor(newNode);
			nodes.put(node, newNode);
			nodes.put(neighbor, newNeighbor);
		}
		for (Node n : nodes.values()) {
			n.print();
			System.out.print(": ");
			for (Node ne : n.neighbors)
				ne.print();
			System.out.println();
		}
		Node root = nodes.get(1);
		updateVals(root, new HashSet<Node>());
		for (Node n : nodes.values()) {
			n.print();
			System.out.print(": ");
			for (Node ne : n.neighbors)
				ne.print();
			System.out.println();
		}

		System.out.println(getMaxDiff(root));
	}
	public static int updateVals(Node root, HashSet<Node> visited) {
		boolean allVisited = true;
		for (Node ne : root.neighbors) {
			if (!visited.contains(ne))
				allVisited = false;
		}
		if (allVisited) // is leaf
			return root.value;
		visited.add(root);

		for (Node ne : root.neighbors) {
			System.out.print(ne.id);
			if (!visited.contains(ne)) {
				root.value += updateVals(ne, visited);
			}
		}
		
		return root.value;
	}

	public static int getMaxDiff(Node root) {
		int minDiff = Integer.MAX_VALUE;
		int hi = root.value;
		HashSet<Node> v = new HashSet<>();
		LinkedList<Node> q = new LinkedList<>();
		q.add(root);
		v.add(root);
		while(!q.isEmpty()) {
			Node n = q.poll();
			for (Node ne : n.neighbors) {
				if (v.contains(ne)) continue;
				v.add(ne);
				q.add(ne);
				if (Math.abs(hi - 2*ne.value) < minDiff) {
					minDiff = Math.abs(hi - 2*ne.value);
					System.out.println(hi - ne.value + " - " + ne.value + " = " + minDiff);
				}
			}
		}
		return minDiff;

	}



/*	public static void printGraph(Node root) {
		LinkedList<Node> q = new LinkedList<>();
		HashSet<Node> visited = new HashSet<>();
		q.add(root);
		while (!q.isEmpty()) {
			for (Node n : q.neighbors) {
				if (!visited.contains(n)) {
					n.print();
					q.add(n);
					visited.add(n);
				}
			}
		}
	}*/

}



class Node {
	int id;
	int value;
	LinkedList<Node> neighbors;
	public Node(int id) {
		this.id = id;
		this.neighbors = new LinkedList<>();
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void addNeighbor(Node neighbor) {
		this.neighbors.add(neighbor);
	}
	/*public Node getNeighbor(int id) {
		return this.neighbors.get(id);
	}*/
	public void print() {
		System.out.print("(" + this.id + ", " + this.value + ")");
	}
}