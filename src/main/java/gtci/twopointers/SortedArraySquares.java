package gtci.twopointers;

/**
 * Given a sorted array, create a new array containing squares of all the number of the input array
 * in the sorted order.
*/
public class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1, i = n - 1;
        int[] squares = new int[n];

        while (left <= right) {
            int leftSq = arr[left] * arr[left];
            int rightSq = arr[right] * arr[right];

            if (leftSq > rightSq) {
                squares[i--] = leftSq;
                left++;
            } else {
                squares[i--] = rightSq;
                right--;
            }
        }

        return squares;
    }
    /**
     * This is a straightforward question. The only trick is that we can have negative numbers in
     * the input array, which will make it a bit difficult to generate the output array with squares
     * in sorted order.
     *
     * An easier approach could be to first find the index of the first non-negative number in the
     * array. After that, we can use Two Pointers to iterate the array. One pointer will move
     * forward to iterate the non-negative numbers and the other pointer will move backward to
     * iterate the negative numbers. At any step, whichever number gives us a bigger square will
     * be added to the output array.
     *
     * Since the numbers at both the ends can give us the largest square, an alternate approach
     * could be to use two pointers starting at both the ends of the input array. At any step,
     * whichever pointer gives us the bigger square we add it to the result array and move to the
     * next/previous number according to the pointer.
     */
    public static int[] makeSquaresRef(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }
}
