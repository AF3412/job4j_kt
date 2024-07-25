package ru.af3412.base

fun defragment(array: Array<String?>) {

    var emptyCur = array.size - 1;
    var cur = 0;

    while (cur < emptyCur) {

        if (array[cur] == null && array[emptyCur] != null) {
            array[cur] = array[emptyCur]
            array[emptyCur] = null
            cur++
            emptyCur--
        } else if (array[cur] == null) {
            emptyCur--
        } else if (array[emptyCur] != null) {
            cur++
        } else {
            cur++
            emptyCur--
        }
    }

}