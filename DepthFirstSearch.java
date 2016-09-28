import java.util.Stack;

public class DepthFirstSearch {

	public void DFS(DFSNode root) {
		Stack<DFSNode> s = new Stack<DFSNode>();
		s.add(root);
		while (s.isEmpty() == false) {
			DFSNode x = s.pop();
			if (x.right != null)
				s.add(x.right);
			if (x.left != null)
				s.add(x.left);
			System.out.print(" " + x.data);
		}
	}

	public static void main(String args[]) {
		DFSNode root = new DFSNode(1);
		root.left = new DFSNode(2);
		root.left.left = new DFSNode(4);
		root.left.right = new DFSNode(5);
		root.right = new DFSNode(3);
		root.right.left = new DFSNode(6);
		root.right.right = new DFSNode(7);

		DepthFirstSearch b = new DepthFirstSearch();
		System.out.println("Depth-First-Search : ");
		b.DFS(root);
	}
}

class DFSNode {
	int data;
	DFSNode left;
	DFSNode right;

	public DFSNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
