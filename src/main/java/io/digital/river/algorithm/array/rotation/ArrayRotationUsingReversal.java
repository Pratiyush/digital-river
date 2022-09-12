package io.digital.river.algorithm.array.rotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Problem Statement: Given an int array arr[] of size N rotate the array by D positions to the
 * left.
 *
 * <p>Array Rotation One By One : Solution Synopsis.
 *
 * <p>Instead of moving one by one, divide the array into different sets where the number of sets is
 * equal to the GCD of N and d (say X. So the elements which are X distance apart are part of a set)
 * and rotate the elements within sets by 1 position to the left.
 *
 * <ul>
 *   <li>Calculate the GCD between the length and the distance to be moved.
 *   <li>The elements are only shifted within the sets.
 *   <li>We start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at
 *       the right place.
 * </ul>
 *
 * <p>Example:
 *
 * <pre>
 * If we observe closely, we can see that a group of array elements is changing its position. For example see the following array:
 * arr[] = {1, 2, 3, 4, 5, 6, 7} and d = 2. The rotated array is {3, 4, 5, 6, 7, 1, 2}
 *
 * The group having the first two elements is moving to the end of the array. This is like reversing the array.
 *
 * But the issue is that if we only reverse the array, it becomes {7, 6, 5, 4, 3, 2, 1}.
 * After rotation the elements in the chunks having the first 5 elements {7, 6, 5, 4, 3} and the last 2 elements {2, 1} should be in the actual order as of the initial array [i.e., {3, 4, 5, 6, 7} and {1, 2}]but here it gets reversed.
 * So if those blocks are reversed again we get the desired rotated array.
 *
 * So the sequence of operations is:
 *
 * Reverse the whole array
 * Then reverse the last ‘d’ elements and
 * Then reverse the first (N-d) elements.
 *
 * As we are performing reverse operations it is also similar to the following sequence:
 *
 * Reverse the first ‘d’ elements
 * Reverse last (N-d) elements
 * Reverse the whole array.
 * </pre>
 *
 * <p>Steps to solve the array rotation problem.
 *
 * <ul>
 *   Algorithm reverse(arr, start, end): mid = (start + end)/2 loop from i = start to mid: swap
 *   (arr[i], arr[end-(mid-i+1)])
 *   <p>Algorithm rotate(arr, d, N): reverse(arr, 1, d) ; reverse(arr, d + 1, N); reverse(arr, 1,
 *   N);
 *   <pre>
 * Time complexity : O(N)
 * Auxiliary Space : O(1)
 * </pre>
 *   <pre>
 *     Example:
 *
 *     For example take the array arr[] = {1, 2, 3, 4, 5, 6, 7} and d = 2.
 * +---+---+---+---+---+---+---+
 * | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
 * +---+---+---+---+---+---+---+
 *     The rotated array will look like:
 * +---+---+---+---+---+---+---+
 * | 3 | 4 | 5 | 6 | 7 | 1 | 2 |
 * +---+---+---+---+---+---+---+
 *
 * 1st Step: Consider the array as a combination of two blocks. One containing the first two elements and the other containing the remaining elements as shown above.
 *
 * +---+---+        +---+---+---+---+---+
 * | 1 | 2 |        | 3 | 4 | 5 | 6 | 7 |
 * +---+---+        +---+---+---+---+---+
 * FIRST BLOCK      SECOND BLOCK
 * Considered 2 blocks
 *
 * 2nd Step: Now reverse the first d elements. It becomes as shown in the image
 *
 * +---+---+                +---+---+---+---+---+
 * | 2 | 1 |                | 3 | 4 | 5 | 6 | 7 |
 * +---+---+                +---+---+---+---+---+
 * REVERSED FIRST BLOCK     SECOND BLOCK
 * Reverse the first K elements
 *
 * 3rd Step: Now reverse the last (N-d) elements. It become as it is shown in the below image:
 *
 * +---+---+                +---+---+---+---+---+
 * | 2 | 1 |                | 7 | 6 | 5 | 4 | 3 |
 * +---+---+                +---+---+---+---+---+
 * REVERSED FIRST BLOCK     REVERSED SECOND BLOCK
 * Reverse the last (N-K) elements
 *
 * 4th Step: Now the array is the exact reversed form of how it should be if left shifted d times. So reverse the whole array and you will get the required rotated array.
 *
 * +---+---+---+---+---+---+---+
 * | 3 | 4 | 5 | 6 | 7 | 1 | 2 |
 * +---+---+---+---+---+---+---+
 * The total array is reversed
 *
 * See that the array is now the same as the rotated array.
 * </pre>
 *
 * @author Pratiyush Kumar Singh
 * @since 11 Sept 2022
 * @version 1.0
 */
public class ArrayRotationUsingReversal {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayRotationUsingReversal.class);

    public static void main(final String[] args) {
        final int arr[] = {1, 2, 3, 4, 5, 6, 7};
        final int d = 2;
        final int n = arr.length;
        rotate(arr, d, n);
    }

    public static void rotate(final int[] arr, int d, final int n) {
        // Special Case 1: When D = 0, NO ROTATION REQUIRED
        if (d == 0) return;

        // Special Case 2: When D >= N
        d = d % n;

        // Reverse : First part of sub-array from index 0 - (D - 1)
        reverse(arr, 0, d - 1);

        // Reverse : Second part of sub-array from index D - (N - 1)
        reverse(arr, d, n - 1);

        // Reverse : Whole Array
        reverse(arr, 0, n - 1);

        LOGGER.info(Arrays.toString(arr));
    }

    private static void reverse(final int[] arr, int startIndex, int lastIndex) {
        while (startIndex <= lastIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[lastIndex];
            arr[lastIndex] = temp;
            lastIndex--;
            startIndex++;
        }
    }
}
