import java.util.*;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node(int in) {
		val = in;
		left = null;
		right = null;
	}
}

public class CostRootNode {
	public static void main(String args[]) {
		Node n1 = new Node(5);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n6 = new Node(6);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n6;

		System.out.println(findCost(n1, 4));
	}
	public static int findCost(Node root, int target) {
		Stack<Node> s = new Stack<>();
		Node cur;
		int cost = 0;
		
		s.push(root);
		int numLevel = 0;
		int prevLevel = 1;

		while (!s.isEmpty()) {
			for (int i = 0; i < prevLevel; i++) {
				cur = s.pop();
				if (cur.left != null) {
					s.push(cur.left);
					numLevel++;
				}
				if (cur.right != null) {
					s.push(cur.right);
					numLevel++;
				}
				if (cur.val == target) {
					return cost + 1;
				}
			}
			cost++;
			prevLevel = numLevel;
			numLevel = 0;
		}
		return cost;
	}
}