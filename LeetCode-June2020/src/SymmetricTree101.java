
public class SymmetricTree101 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	TreeNode root;

	void insertKey(int x) {
		TreeNode node = new TreeNode(x);
		root = insertRecur(node, root);
	}

	private TreeNode insertRecur(TreeNode node, TreeNode root) {
		// Insert in left subtree.
		if(root == null) {
			return node;
		}
		if (node.val < root.val) {
			root.left = insertRecur(node, root.left);
		} else { // Insert in right subtree.
			root.right = insertRecur(node, root.right);
		}
		return root;
	}

	void inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.val + " ");
			inorderTraversal(root.right);
		}
	}

	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode node1, TreeNode node2) {
		// If both trees are empty then they are mirror image.
		if(node1 == null && node2 == null) {
			return true;
		}
		
		if(node1==null || node2 == null) {
			return false;
		}
		
		if(node1 != null && node2 != null) {
			if(node1.val == node2.val) {
				return ((isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left)));
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SymmetricTree101 tree = new SymmetricTree101();
		tree.insertKey(11);
		tree.insertKey(1);
		tree.insertKey(4);
		tree.insertKey(3);
		tree.insertKey(7);
		tree.insertKey(9);
		tree.inorderTraversal(tree.root);
		
		System.out.println(tree.isSymmetric(tree.root));
	}
}
