

public class CyclicOrAcyclicList {
	
	private CANode head;

	public CyclicOrAcyclicList() {
		this.head = new CANode("head");
	}

	public CANode head() {
		return head;
	}

	public void appendIntoTail(CANode node) {
		CANode current = head;

		// find last element of LinkedList i.e. tail
		while (current.next() != null) {
			current = current.next();
		}
		// appending new node to tail in LinkedList
		current.setNext(node);
	}

	/*
	 * If singly LinkedList contains Cycle then following would be true 1) slow
	 * and fast will point to same node i.e. they meet On the other hand if fast
	 * will point to null or next node of fast will point to null then
	 * LinkedList does not contains cycle.
	 */
	public boolean isCyclic() {
		CANode fast = head;
		CANode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			// if fast and slow pointers are meeting then LinkedList is cyclic
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		CANode current = head.next();
		while (current != null) {
			sb.append(current).append("-->");
			current = current.next();
		}
		sb.delete(sb.length() - 3, sb.length()); // to remove --> from last node
		return sb.toString();
	}

	public static class CANode {
		private CANode next;
		private String data;

		public CANode(String data) {
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public CANode next() {
			return next;
		}

		public void setNext(CANode next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return this.data;
		}
	}

	public static void main(String args[]) {

		// creating LinkedList with 5 elements including head
		CyclicOrAcyclicList linkedList = new CyclicOrAcyclicList();
		linkedList.appendIntoTail(new CyclicOrAcyclicList.CANode("101"));
		linkedList.appendIntoTail(new CyclicOrAcyclicList.CANode("201"));
		linkedList.appendIntoTail(new CyclicOrAcyclicList.CANode("301"));
		linkedList.appendIntoTail(new CyclicOrAcyclicList.CANode("401"));

		System.out.println("Linked List : " + linkedList);

		if (linkedList.isCyclic()) {
			System.out
					.println("Linked List is cyclic as it contains cycles or loop");
		} else {
			System.out
					.println("LinkedList is not cyclic, no loop or cycle found");
		}

	}

}
