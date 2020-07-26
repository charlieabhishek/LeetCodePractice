
public class MergeKSortedLists {

	class Node{
		int val;
		int index;

		public Node(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	class MinHeap {
		int capacity;
		int heapSize;
		Node[] heapArr;

		public MinHeap(int capacity) {
			this.capacity = capacity;
			this.heapArr = new Node[capacity];
		}

		int parent(int i) {
			return (i-1)/2;
		}

		int left(int i) {
			return (2*i + 1);
		}

		int right(int i) {
			return (2*i + 2);
		}

		void swap(int x, int y) {
			Node temp = heapArr[x];
			heapArr[x] = heapArr[y];
			heapArr[y] = temp;
		}

		void insert(Node node) {
			if(heapSize == capacity) {
				System.out.println("Heap is Full");
				return;
			}

			heapSize++;
			int i = heapSize-1;
			heapArr[i] = node;
			while(i!=0 && heapArr[parent(i)].val > heapArr[i].val) {
				swap(i, parent(i));
				i = parent(i);
			}
		}

		void minHeapify(int i) {
			int l = left(i);
			int r = right(i);
			int smallest = i;

			if(l < heapSize && heapArr[l].val < heapArr[smallest].val) {
				smallest = l;
			}
			if(r < heapSize && heapArr[r].val < heapArr[smallest].val) {
				smallest = r;
			}

			if(smallest != i) {
				swap(i, smallest);
				minHeapify(smallest); 
			}
		}

		Node extractMin() {
			if(heapSize == 0) {
				return null;
			}
			Node node = heapArr[0];
			heapArr[0] = heapArr[heapSize-1];
			heapSize--;
			minHeapify(0);
			return node;
		}

	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val){
			this.val = val;
		}
	}

	ListNode addNode(ListNode node, ListNode head) {
		if(head == null) {
			head = new ListNode(node.val);
		} else {
			ListNode temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		return head;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		if(lists.length == 1) {
			return lists[0];
		}
		
		int k = lists.length;
		ListNode[] tempPtrArr = new ListNode[k];

		int i = 0;
		int sizeTempPtr = 0;
		while(i<lists.length) {
			if(lists[i] != null) {
				tempPtrArr[i] = lists[i];	
				sizeTempPtr++;
			}
			i++;
		}
		if(sizeTempPtr == 0) {
			return null;
		}

		ListNode resultNode = null;   

		MinHeap minHeap = new MinHeap(k);
		do {
			int x = 0;
			if(minHeap.heapSize == 0) {
				while(x < k) {
					ListNode tempPtr = tempPtrArr[x];
					if(tempPtr != null) {
						Node node = new Node(tempPtr.val, x);
						minHeap.insert(node);					
					}
					x++;	
				}
			} 

			Node node = minHeap.extractMin();
			ListNode extractedNode = new ListNode(node.val);
			resultNode = addNode(extractedNode, resultNode);			
			tempPtrArr[node.index] = tempPtrArr[node.index].next;
			if(tempPtrArr[node.index] != null) {
				Node xNode = new Node(tempPtrArr[node.index].val, node.index);	
				minHeap.insert(xNode);
			}
		} while (minHeap.heapSize != 0);

		return resultNode;
	}
	
	public static void main(String[] args) {
		MergeKSortedLists mergeKSortedList = new MergeKSortedLists();
		
		ListNode listNode1 = new ListNode(1);
		listNode1.next = new ListNode(4);
		listNode1.next.next = new ListNode(5);
		
		ListNode listNode2 = new ListNode(1);
		listNode2.next = new ListNode(3);
		listNode2.next.next = new ListNode(4);
		
		ListNode listNode3 = new ListNode(2);
		listNode3.next = new ListNode(6);
		
 		ListNode[] lists = {listNode1, listNode2, listNode3};
		
		ListNode resultNode = mergeKSortedList.mergeKLists(lists);
	}

}
