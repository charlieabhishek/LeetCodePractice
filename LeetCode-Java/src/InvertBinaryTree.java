//Invert a binary tree.
public class InvertBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	TreeNode root;

	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		
		TreeNode left = invertTree(root.left); //Left subtree
		TreeNode right = invertTree(root.right); // Right subtree
		
		//Swap 
		root.left = right;
		root.right = left;
		
		return root;
	}
}
