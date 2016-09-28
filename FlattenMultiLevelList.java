
// Java program to flatten linked list with next and child pointers

class FlattenMultiLevelList {

	static MultiLevelNode head;

	class MultiLevelNode {

		int data;
		MultiLevelNode next, child, prev;

		MultiLevelNode(int d) {
			data = d;
			next = child = null;
			prev = child = null;
		}
	}

	// A utility function to create a linked list with n nodes. The data
	// of nodes is taken from arr[]. All child pointers are set as NULL
	MultiLevelNode createList(int arr[], int n) {
		MultiLevelNode node = null;
		MultiLevelNode p = null;

		int i;
		for (i = 0; i < n; ++i) {
			if (node == null) {
				node = p = new MultiLevelNode(arr[i]);
			} else {
				p.next = new MultiLevelNode(arr[i]);
				p = p.next;
			}
			p.next = p.child = null;
		}
		return node;
	}

	// A utility function to print all nodes of a linked list
	void printList(MultiLevelNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("");
	}

	MultiLevelNode createList() {
		int arr1[] = new int[] { 10, 5, 12, 7, 11 };
		int arr2[] = new int[] { 4, 20, 13 };
		int arr3[] = new int[] { 17, 6 };
		int arr4[] = new int[] { 9, 8 };
		int arr5[] = new int[] { 19, 15 };
		int arr6[] = new int[] { 2 };
		int arr7[] = new int[] { 16 };
		int arr8[] = new int[] { 3 };

		/* create 8 linked lists */
		MultiLevelNode head1 = createList(arr1, arr1.length);
		MultiLevelNode head2 = createList(arr2, arr2.length);
		MultiLevelNode head3 = createList(arr3, arr3.length);
		MultiLevelNode head4 = createList(arr4, arr4.length);
		MultiLevelNode head5 = createList(arr5, arr5.length);
		MultiLevelNode head6 = createList(arr6, arr6.length);
		MultiLevelNode head7 = createList(arr7, arr7.length);
		MultiLevelNode head8 = createList(arr8, arr8.length);

		/* modify child pointers to create the list shown above */
		head1.child = head2;
		head1.next.next.next.child = head3;
		head3.child = head4;
		head4.child = head5;
		head2.next.child = head6;
		head2.next.next.child = head7;
		head7.child = head8;

		/*
		 * Return head pointer of first linked list. Note that all nodes are
		 * reachable from head1
		 */
		return head1;
	}

	/* The main function that flattens a multilevel linked list */
	void flattenList(MultiLevelNode node) {

		/* Base case */
		if (node == null) {
			return;
		}

		MultiLevelNode tmp = null;

		/* Find tail node of first level linked list */
		MultiLevelNode tail = node;
		while (tail.next != null) {
			tail = tail.next;
		}

		// One by one traverse through all nodes of first level
		// linked list till we reach the tail node
		MultiLevelNode cur = node;
		while (cur != tail) {

			// If current node has a child
			if (cur.child != null) {

				// then append the child at the end of current list
				tail.next = cur.child;

				// and update the tail to new last node
				tmp = cur.child;
				while (tmp.next != null) {
					tmp = tmp.next;
				}
				tail = tmp;
			}

			// Change current node
			cur = cur.next;
		}
	}

	public MultiLevelNode unflattenList(MultiLevelNode head) {
		MultiLevelNode p, p1;
		p = head;
		while (p != null) {
			if (p.child != null) {
				p1 = p.child;
				if (p1.prev != null) {
					p1.prev.next = null;
					p1.prev = null;
				}
				unflattenList(p1);
			}
			p = p.next;
		}
		return head;
	}

	public void printUnflattenList(MultiLevelNode head) {
		MultiLevelNode p = head;
		while (p != null) {
			System.out.println("Head: " + p.data + " ");
			if (p.child != null) {
				System.out.println("Child/Children: " + p.child.data);
				printUnflattenList(p.child);
			}
			p = p.next;
		}
		System.out.println("\n");
	}

	public int hasLoop(MultiLevelNode first) {
		MultiLevelNode slow = first;
		MultiLevelNode fast = first;

		while (fast != null && fast.next != null) {
			slow = slow.next; // 1 hop
			fast = fast.next.next; // 2 hops

			if (slow == fast) // fast caught up to slow, so there is a loop
				System.out.println("This list is cyclic");
				return 1;
			
		}
		System.out.println("This list is acyclic");
		return 0; // fast reached null, so the list terminates
	}

	public static void main(String[] args) {
		FlattenMultiLevelList list = new FlattenMultiLevelList();
		head = list.createList();
		list.hasLoop(head);
		
		System.out.println("before flatten \n");
		list.printUnflattenList(head);

		System.out.println("after flatten \n");
		list.flattenList(head);
		list.printList(head);

		System.out.println("after deflatten \n");
		list.unflattenList(head);
		list.printUnflattenList(head);
		
		
	}
}