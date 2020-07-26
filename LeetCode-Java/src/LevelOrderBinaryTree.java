import java.util.ArrayList;
import java.util.List;

public class LevelOrderBinaryTree {

	LQueue queue = new LQueue();

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	class QNode {
		TreeNode node;
		QNode next;

		public QNode(TreeNode node) {
			this.node = node;
		}
	}

	class LQueue {
		QNode rear;
		QNode front;
		int count = 0;

		public LQueue() {
			rear = front = null;
			count = 0;
		}

		void enqueue(QNode node) {
			if (rear == null) {
				rear = front = node;
			} else {
				rear.next = node;
				rear = node;
			}
			count++;
		}

		QNode dequeue() {
			if (isQEmpty()) {
				return null;
			}
			QNode temp = front;
			front = front.next;
			if (front == null) {
				rear = null;
			}
			count--;
			return temp;
		}

		boolean isQEmpty() {
			if (rear == null) {
				return true;
			}
			return false;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> arrayList = new ArrayList<List<Integer>>();
		if (root == null) {
			return arrayList;
		}
		QNode qNode = new QNode(root);
		queue.enqueue(qNode);

		while (!queue.isQEmpty()) {
			int size = queue.count;
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				QNode cNode = queue.dequeue();

				list.add(cNode.node.val);
				if (cNode.node.left != null) {
					QNode qNodeL = new QNode(cNode.node.left);
					queue.enqueue(qNodeL);
				}
				if (cNode.node.right != null) {
					QNode qNodeR = new QNode(cNode.node.right);
					queue.enqueue(qNodeR);
				}
			}
			arrayList.add(list);
		}
		return arrayList;
	}

	TreeNode root;

	public static void main(String[] args) {

		LevelOrderBinaryTree lOrderBt = new LevelOrderBinaryTree();

		// [3,9,20,null,null,15,7]
		// [1,2,3,4,null,null,5]
		// [0,2,4,1,null,3,-1,5,1,null,6,null,8]
		lOrderBt.root = new TreeNode(0);
		lOrderBt.root.left = new TreeNode(2);
		lOrderBt.root.right = new TreeNode(4);
		lOrderBt.root.left.left = new TreeNode(1);
		lOrderBt.root.left.right = null;
		lOrderBt.root.right.left = new TreeNode(3);
		lOrderBt.root.right.right = new TreeNode(-1);
		lOrderBt.root.left.left.left = new TreeNode(5);
		lOrderBt.root.left.left.right = new TreeNode(1);
		lOrderBt.root.right.left.left = null;
		lOrderBt.root.right.left.left = new TreeNode(6);
		lOrderBt.root.right.right.right = new TreeNode(8);

		lOrderBt.levelOrder(lOrderBt.root);
	}
}
