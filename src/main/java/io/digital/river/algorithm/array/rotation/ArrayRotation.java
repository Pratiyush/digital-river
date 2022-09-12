package io.digital.river.algorithm.array.rotation;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayRotation {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayRotation.class);

    public static void main(final String[] args) {
        final int arrayToBeRotated[] = {1, 2, 3, 4, 5, 6, 7};
        final int rotateByElement = 2;
        final int arrayLength = arrayToBeRotated.length;
        rotate(arrayToBeRotated, rotateByElement, arrayLength);
    }

    public static void rotate(
            final int[] arrayToBeRotated, final int rotateByElement, final int arrayLength) {

        int rotatedArray[] = new int[arrayLength];
        int currentIndex = 0;
        for (int rotationCurrentIndex = rotateByElement;
                rotationCurrentIndex < arrayLength;
                currentIndex++, rotationCurrentIndex++) {
            rotatedArray[currentIndex] = arrayToBeRotated[rotationCurrentIndex];
        }

        for (int rotationCurrentIndex = 0;
                rotationCurrentIndex < rotateByElement;
                currentIndex++, rotationCurrentIndex++) {
            rotatedArray[currentIndex] = arrayToBeRotated[rotationCurrentIndex];
        }

        LOGGER.info(Arrays.toString(rotatedArray));
    }
}
