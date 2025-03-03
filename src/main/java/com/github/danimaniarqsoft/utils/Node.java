package com.github.danimaniarqsoft.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node<T> {

    private T value;

    private Node<T> next;

}
