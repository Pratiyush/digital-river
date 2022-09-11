package io.digital.river.array.rotation;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem Statement: Given an array of integers arr[] of size N and an integer, the task is to
 * rotate the array elements to the left by d positions.
 *
 * <p>Solution Synopsis: Array Rotation using Auxiliary Array. After rotating d positions to the
 * left, the first d elements become the last d elements of the array
 *
 * <ul>
 *   <li>First store the elements from index d to N-1 into the temp array.
 *   <li>Then store the first d elements of the original array into the temp array.
 *   <li>Copy back the elements of the temp array into the original array
 * </ul>
 *
 * <p>Example:
 *
 * <pre>
 * Suppose the give array is arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2.
 *
 * First Step:
 *     => Store the elements from 2nd index to the last.
 *     => temp[] = [3, 4, 5, 6, 7]
 *
 * Second Step:
 *     => Now store the first 2 elements into the temp[] array.
 *     => temp[] = [3, 4, 5, 6, 7, 1, 2]
 *
 * Third Steps:
 *     => Copy the elements of the temp[] array into the original array.
 *     => arr[] = temp[] So arr[] = [3, 4, 5, 6, 7, 1, 2]
 * </pre>
 *
 * <p>Steps to solve the array rotation problem.
 *
 * <ul>
 *   <li>Follow the steps below to solve the given problem.
 *   <li>Initialize a temporary array(temp[n]) of length same as the original array
 *   <li>Initialize an integer(k) to keep a track of the current index
 *   <li>Store the elements from the position d to n-1 in the temporary array
 *   <li>Now, store 0 to d-1 elements of the original array in the temporary array
 *   <li>Lastly, copy back the temporary array to the original array
 * </ul>
 *
 * <pre>
 * Time complexity: O(N)
 * Auxiliary Space: O(N)
 * </pre>
 *
 * @author Pratiyush Kumar Singh
 * @since 11 Sept 2022
 * @version 1.0
 */
public class ArrayRotationUsingTempArray {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayRotationUsingTempArray.class);

    public static void main(final String[] args) {
        final int arrayToBeRotated[] = {1, 2, 3, 4, 5, 6, 7};
        final int d = 2;
        final int n = arrayToBeRotated.length;
        rotate(arrayToBeRotated, d, n);
    }

    private static void rotate(final int[] arrayToBeRotated, final int d, final int n) {

        // Current Value: {0,0,0,0,0,0,0}
        int rotatedArray[] = new int[n];
        int currentIndex = 0;

        // Moving numbers from index D - N
        // After Iteration : {3,4,5,6,7,0,0}
        for (int i = d; i < n; currentIndex++, i++) {
            rotatedArray[currentIndex] = arrayToBeRotated[i];
            LOGGER.info(Arrays.toString(rotatedArray));
        }

        // Moving numbers from index 0 - D
        // After Iteration : {3,4,5,6,7,1,2}
        for (int i = 0; i < d; currentIndex++, i++) {
            rotatedArray[currentIndex] = arrayToBeRotated[i];
            LOGGER.info(Arrays.toString(rotatedArray));
        }

        LOGGER.info(Arrays.toString(rotatedArray));
    }
}
