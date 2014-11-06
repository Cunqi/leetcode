package com.cx363;

import com.cx363.entity.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {

		if (head == null || head.next == null)
			return false;

		ListNode oneStep = head;
		ListNode twoStep = head.next;

		while (twoStep != null) {

			if (oneStep == twoStep)
				return true;

			twoStep = twoStep.next;

			if (twoStep == null)
				break;

			oneStep = oneStep.next;
			twoStep = twoStep.next;
		}

		return false;
	}
}
