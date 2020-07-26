import java.util.ArrayList;
import java.util.List;

public class LeetCode94BinaryTreeInOrderTraversal {

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

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> arrayList = new ArrayList<Integer>();
		return inorderRecurTrav(root, arrayList);
	}

	private List<Integer> inorderRecurTrav(TreeNode root, List<Integer> arrayList) {
		if(root != null) {
			arrayList = inorderRecurTrav(root.left, arrayList);
			arrayList.add(root.val);
			arrayList = inorderRecurTrav(root.right, arrayList);
		}
		return arrayList;
	}

	public static void main(String[] args) {
	}
}
