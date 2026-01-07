package com.github.danimaniarqsoft.list;

import lombok.Data;

@Data
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
