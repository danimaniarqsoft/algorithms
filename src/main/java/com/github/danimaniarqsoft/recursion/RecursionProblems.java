package com.github.danimaniarqsoft.recursion;

public class RecursionProblems {

    public static char[] reverse(char[] items, int left, int right) {

        if (left < right) {
            swap(items, left, right);
            reverse(items, left + 1, right - 1);
        }

        return items;
    }

    public static void swap(char[] items, int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public static void main(String[] args) {
        char[] items = "hola aloh".toCharArray();

        items = reverse(items, 0, items.length -1);

        System.out.println(new String(items).toString());

    }
}
