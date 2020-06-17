
public class ValidateBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
	}

	private boolean validate(TreeNode root, Integer min, Integer max) {
		if (root == null) { // base condition if this condition reaches then tree/subtree is valid bst.
			return true;
		} else if ((min != null && root.val <= min) || (max != null && root.val >= max)) { // if root is less than min
																							// or greater than max then
																							// not valid bst.
			return false;
		} else {
			return validate(root.left, min, root.val) && validate(root.right, root.val, max); // validating left subtree
																								// with max as root val
																								// validating right
																								// subtree with min as
																								// root val
		}
	}

	public static void main(String[] args) {
	}
}
