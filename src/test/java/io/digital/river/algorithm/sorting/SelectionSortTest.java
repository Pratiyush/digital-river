package io.digital.river.algorithm.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SelectionSortTest {

    @Test
    void shouldShort() {
        final int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        SelectionSort.sort(arr, arr.length);
        final int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    void shouldShortWithNegativeValues() {
        final int[] arr = {3, 2, 1, 0, -1, -2, -3};
        SelectionSort.sort(arr, arr.length);
        final int[] expected = {-3, -2, -1, 0, 1, 2, 3};
        assertArrayEquals(expected, arr);
    }

    @Test
    void shouldShortOneElement() {
        final int[] arr = {1};
        SelectionSort.sort(arr, arr.length);
        final int[] expected = {1};
        assertArrayEquals(expected, arr);
    }

    @Test
    void shouldShortTwoElement() {
        final int[] arr = {2, 1};
        SelectionSort.sort(arr, arr.length);
        final int[] expected = {1, 2};
        assertArrayEquals(expected, arr);
    }

    @Test
    void shouldShortEmptyElement() {
        final int[] arr = {};
        SelectionSort.sort(arr, arr.length);
        final int[] expected = {};
        assertArrayEquals(expected, arr);
    }
}
