package com.github.danimaniarqsoft.list;

import lombok.Data;

@Data
public class ListNodeWithKey {

    private int key;
    private int val;
    private ListNodeWithKey next;

    public ListNodeWithKey(int val) {
        this.val = val;
    }

    public ListNodeWithKey(int key, int val) {
        this.key = key;
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
