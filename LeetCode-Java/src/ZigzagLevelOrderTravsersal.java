import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagLevelOrderTravsersal {

	TreeNode root;

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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		boolean isLeftToRight = true;
		List<List<Integer>> arrayList = new ArrayList<List<Integer>>();
		if (root == null) {
			return arrayList;
		}
		QNode node = new QNode(root);
		queue.enqueue(node);
		while (!queue.isQEmpty()) {
			List<Integer> levelList = new ArrayList<>();
			int size = queue.count;
			for (int i = 0; i < size; i++) {
				QNode dNode = queue.dequeue();

				if (dNode.node.left != null) {
					QNode nodeLeft = new QNode(dNode.node.left);
					queue.enqueue(nodeLeft);
				}
				if (dNode.node.right != null) {
					QNode nodeRight = new QNode(dNode.node.right);
					queue.enqueue(nodeRight);
				}
				if (isLeftToRight) {
					levelList.add(dNode.node.val);
				} else {
					levelList.add(0, dNode.node.val);
				}
			}
			arrayList.add(levelList);
			isLeftToRight = !isLeftToRight;
		}
		return arrayList;
	}

	public static void main(String[] args) {
		ZigzagLevelOrderTravsersal zigZagLOrderTrav = new ZigzagLevelOrderTravsersal();
		zigZagLOrderTrav.root = new TreeNode(3);
		zigZagLOrderTrav.root.left = new TreeNode(5);
		zigZagLOrderTrav.root.right = new TreeNode(8);
		zigZagLOrderTrav.root.left.left = new TreeNode(9);
		zigZagLOrderTrav.root.left.left = new TreeNode(10);
		zigZagLOrderTrav.root.right.left = new TreeNode(7);
		zigZagLOrderTrav.root.right.right = new TreeNode(16);
		zigZagLOrderTrav.root.left.left.left = new TreeNode(0);
		zigZagLOrderTrav.root.left.left.right = new TreeNode(11);
		zigZagLOrderTrav.root.right.left.right = new TreeNode(18);
		zigZagLOrderTrav.root.right.right.left = new TreeNode(19);
		zigZagLOrderTrav.zigzagLevelOrder(zigZagLOrderTrav.root);
	}
}
