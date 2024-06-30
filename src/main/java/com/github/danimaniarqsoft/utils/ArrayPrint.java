package com.github.danimaniarqsoft.utils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ArrayPrint {

    private ArrayPrint() {
    }

    public static final void print(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n\n");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(i);
        }
        sb.append("\r\n");
        log.info("Printing Array: {}", sb.toString());
    }
}
