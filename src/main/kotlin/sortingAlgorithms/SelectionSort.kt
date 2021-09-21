package sortingAlgorithms

import exchange
import kotlinx.coroutines.delay


/**
 * Sorting Algorithm Selection Sort
 */
object SelectionSort {

    /**
     * Selection Sort of an IntArray.
     *
     * Time Complexity: O(n²)
     * @param a array
     */
    suspend fun sort(a: IntArray, delay: Long) {
        var currentIdx = 0
        for (i in a.indices) {
            exchange(a, currentIdx++, minIdx(a, i, a.lastIndex))
            delay(delay)
            ArrayPanel.repaint()
        }
    }


    /**
     * Returns the index of the minimum element of an IntArray in a certain range.
     *
     * Time Complexity: O(n)
     * @param a array
     * @param l minimum index
     * @param r maximum index
     */
    private fun minIdx(a: IntArray, l: Int, r: Int): Int {
        var minIdx = l
        for (i in l..r) {
            if (a[i] < a[minIdx]) minIdx = i
        }
        return minIdx
    }

}
