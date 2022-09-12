package io.digital.river.algorithm.sorting;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.toptal.com/developers/sorting-algorithms
 * https://sadanandpai.github.io/sorting-visualizer/dist/
 * https://www.geeksforgeeks.org/sorting-algorithms/?ref=lbp#Basic https://visualgo.net/en/sorting
 */
public class SelectionSort {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectionSort.class);

    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        int n = arr.length;
        sort(arr, n);
    }

    public static void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minimumValueIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minimumValueIndex]) {
                    minimumValueIndex = j;
                }
            }
            swap(arr, minimumValueIndex, i);
        }
        LOGGER.info(Arrays.toString(arr));
    }

    private static void swap(int arr[], int minIndex, int swapIndex) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[swapIndex];
        arr[swapIndex] = temp;
    }
}
