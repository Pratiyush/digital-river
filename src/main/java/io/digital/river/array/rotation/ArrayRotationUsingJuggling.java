package io.digital.river.array.rotation;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem Statement: Given an array of integers arr[] of size N and an integer, the task is to
 * rotate the array elements to the left by d positions.
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
 * Let arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12} and d = 3
 *
 * First step:
 *         => First set is {1, 4, 7, 10}.
 *         => Rotate this set by one position to the left.
 *         => This set becomes {4, 7, 10, 1}
 *         => Array arr[] = {4, 2, 3, 7, 5, 6, 10, 8, 9, 1, 11, 12}
 *
 * Second step:
 *         => Second set is {2, 5, 8, 11}.
 *         => Rotate this set by one position to the left.
 *         => This set becomes {5, 8, 11, 2}
 *         => Array arr[] = {4, 5, 3, 7, 8, 6, 10, 11, 9, 1, 2, 12}
 *
 * Third step:
 *         => Third set is {3, 6, 9, 12}.
 *         => Rotate this set by one position to the left.
 *         => This set becomes {6, 9, 12, 3}
 *         => Array arr[] = {4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3}
 * </pre>
 *
 * <p>Steps to solve the array rotation problem.
 *
 * <ul>
 *   <li>Perform d%n in order to keep the value of d within the range of the array where d is the
 *       number of times the array is rotated and N is the size of the array.
 *   <li>Calculate the GCD(N, d) to divide the array into sets.
 *   <li>Run a for loop from 0 to the value obtained from GCD.
 *   <li>Store the value of arr[i] in a temporary variable (the value of i denotes the set number).
 *   <li>Run a while loop to update the values according to the set.
 *   <li>After exiting the while loop assign the value of arr[j] as the value of the temporary
 *       variable (the value of j denotes the last element of the ith set).
 * </ul>
 *
 * <pre>
 * Time complexity : O(N)
 * Auxiliary Space : O(1)
 * </pre>
 *
 * @author Pratiyush Kumar Singh
 * @since 11 Sept 2022
 * @version 1.0
 */
public class ArrayRotationUsingJuggling {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayRotationUsingJuggling.class);

    public static void main(final String[] args) {
        final int arrayToBeRotated[] = {1, 2, 3, 4, 5, 6, 7};
        final int d = 2;
        final int n = arrayToBeRotated.length;
        rotate(arrayToBeRotated, d, n);
    }

    public static void rotate(final int[] arrayToBeRotated, final int d, final int n) {

        for (int i = 0; i < d; i++) {
            int firstIndexData = arrayToBeRotated[0];
            for (int j = 0; j < n - 1; j++) {
                arrayToBeRotated[j] = arrayToBeRotated[j + 1];
            }
            arrayToBeRotated[n - 1] = firstIndexData;
            LOGGER.info(Arrays.toString(arrayToBeRotated));
        }
    }
}
