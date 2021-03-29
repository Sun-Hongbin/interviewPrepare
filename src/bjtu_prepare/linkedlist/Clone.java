package bjtu_prepare.linkedlist;

/*
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone {
	public ListNode Clone(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode head = new ListNode(pHead.data);
		ListNode temp = head;
		while (temp.next != null) {
			temp.next = new ListNode(pHead.next.data);
			if (temp.Random != null) {
				temp.Random = new ListNode(pHead.Random.data);
			}
			pHead = pHead.next;
			temp = temp.next;
		}
		return head;

	}

}
