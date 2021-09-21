package sortingAlgorithms

import exchange
import kotlinx.coroutines.delay


/**
 * Sorting Algorithm Bubble Sort
 */
object BubbleSort {


    /**
     * Bubble Sort of an IntArray.
     *
     * Time Complexity: O(n²)
     * @param a array
     */
    suspend fun sort(a: IntArray, delay: Long) {
        var switched = true

        for (i in a.indices) {
            if (!switched) break
            switched = false

            for (j in a.lastIndex downTo i + 1) {
                if (a[j] < a[j - 1]) {
                    exchange(a, j, j - 1)
                    switched = true
                }
                delay(delay)
                ArrayPanel.repaint()
            }
        }
    }

}
