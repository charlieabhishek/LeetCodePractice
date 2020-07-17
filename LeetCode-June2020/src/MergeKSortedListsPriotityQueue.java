import java.util.PriorityQueue;

public class MergeKSortedListsPriotityQueue {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for(ListNode list: lists) {
			while(list != null) {
				priorityQueue.add(list.val);
				list = list.next;
			}
		}
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		while(priorityQueue.size() > 0) {
			temp.next = new ListNode(priorityQueue.remove());
			temp = temp.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
	}
	
}
