
public class AddTwoNumbers {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int data) {
			this.val = data;
		}
	}

	static class CLinkList {
		ListNode head;

		void addNode(ListNode node) {
			if (head == null) {
				head = node;
			} else {
				node.next = head;
				head = node;
			}
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode currRes = result;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		
		int carry = 0;
		while(temp1 != null || temp2 != null) {
			int temp1Val = (temp1 != null) ? temp1.val:0;
			int temp2Val = (temp2 != null) ? temp2.val:0;
			int sum = temp1Val + temp2Val + carry;
			currRes.next = new ListNode(sum % 10);
			currRes = currRes.next;
			carry = sum / 10;
			if(temp1 != null)
			temp1 = temp1.next;
			if(temp2 != null)
			temp2 = temp2.next;
		}
		if(carry > 0) {
			ListNode node = new ListNode(carry);
			currRes.next = node;
			currRes = currRes.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		AddTwoNumbers add2Nums = new AddTwoNumbers();
		ListNode head1 = new ListNode(1);
		
		ListNode head2 = new ListNode(9);
		head2.next = new ListNode(9);
		
		add2Nums.addTwoNumbers(head1, head2);
	}
}
