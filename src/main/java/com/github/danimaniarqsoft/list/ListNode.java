package com.github.danimaniarqsoft.list;

import lombok.Data;

@Data
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
