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
 * <ul>
 *   <li>At each iteration, shift the elements by one position to the left circularly (i.e., first
 *       element becomes the last).
 *   <li>Perform this operation d times to rotate the elements to the left by d position.
 * </ul>
 *
 * <p>Example:
 *
 * <ul>
 *   <li>Let us take arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2.
 *   <li>First Step: => Rotate to left by one position. => arr[] = {2, 3, 4, 5, 6, 7, 1}
 *   <li>Second Step: => Rotate again to left by one position => arr[] = {3, 4, 5, 6, 7, 1, 2}
 *   <li>Rotation is done by 2 times. So the array becomes arr[] = {3, 4, 5, 6, 7, 1, 2}
 * </ul>
 *
 * <p>Steps to solve the array rotation problem.
 *
 * <ul>
 *   <li>Rotate the array to left by one position. For that do the following:
 *   <li>Store the first element of the array in a temporary variable.
 *   <li>Shift the rest of the elements in the original array by one place.
 *   <li>Update the last index of the array with the temporary variable.
 *   <li>Repeat the above steps for the number of left rotations required.
 * </ul>
 *
 * <pre>
 * Time Complexity: O(N * d)
 * Auxiliary Space: O(1)
 * </pre>
 *
 * @author Pratiyush Kumar Singh
 * @since 11 Sept 2022
 * @version 1.0
 */
public class ArrayRotationOneByOne {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayRotationOneByOne.class);

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
