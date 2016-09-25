import java.util.*;

public class TwoSumTree {
	public static void main(String args[]) {
		int [] a = {1,4,3,6,7,8,2};
		Tree tr = new Tree();
		for (int i : a)
			tr.insert(i);
		tr.intrav(5);
	}
}

class Tree {
	Node root;
	public Tree() {
		this.root = null;
	}
	public void insert(int data) {
		if (this.root == null) {
			this.root = new Node(data);
			return;
		}
		Node cur = this.root, parent = null;
		while (cur != null) {
			parent = cur;
			if (data < cur.data)
				cur = cur.left;
			else
				cur = cur.right;
		}
		cur = new Node(data);
		if (data < parent.data)
			parent.left = cur;
		else parent.right = cur;
	}
	public void print() {
		LinkedList<Node> q = new LinkedList<>();
		LinkedList<Node> q2 = new LinkedList<>();
		LinkedList<Node> temp;
		q.add(this.root);
		while(!q.isEmpty()) {
			while (!q.isEmpty()) {
				Node p = q.remove();
				if (p != null) {
					System.out.print(p.data + " ");
					if (p.left != null) q2.add(p.left);
					if (p.right != null) q2.add(p.right);
				}
			}
			System.out.println();
			if (!q2.isEmpty()) {
				temp = q2;
				q2 = q;
				q = temp;
			}
		}
	}
	public void intrav(int sum) {
		Stack<Node> less = new Stack<>();
		Stack<Node> more = new Stack<>();

		boolean done = false;
		Node cur = this.root;
		while (!done) {
			if (cur != null) {
				less.push(cur);
				cur = cur.left;
			}
			else if (!less.isEmpty()) {
				cur = less.pop();
				// node previously pushed to stack was leftmost.
				System.out.print(cur.data + " ");
				cur = cur.right;
			}
			else done = true;
		}
	}
}

class Node {
	Node left;
	Node right;
	int data;
	public Node(int data) {
		this.left = null;
		this.right = null;
		this.data = data;
	}
	public boolean contains(int target, Node root) {
		if (root.data == target)
			return true;
		else if (target < root.data)
			return contains(target, root.left);
		else
			return contains(target, root.right);
	}
}