package sortingAlgorithms

import Element
import exchange
import kotlinx.coroutines.delay


/**
 * Sorting Algorithm Selection Sort
 */
object SelectionSort {

    /**
     * Selection Sort of an Array.
     *
     * Time Complexity: O(n²)
     * @param a array
     * @param delay algorithm delay
     */
    suspend fun sort(a: Array<Element>, delay: Long) {
        var currentIdx = 0
        for (i in a.indices) {
            exchange(a, currentIdx++, minIdx(a, i, a.lastIndex))
            a[i].type = ElementType.SORTED
            delay(delay)
            ArrayPanel.repaint()
        }
    }


    /**
     * Returns the index of the minimum element of an Array in a certain range.
     *
     * Time Complexity: O(n)
     * @param a array
     * @param l minimum index
     * @param r maximum index
     */
    private fun minIdx(a: Array<Element>, l: Int, r: Int): Int {
        var minIdx = l
        for (i in l..r) {
            if (a[i].num < a[minIdx].num) minIdx = i
        }
        return minIdx
    }

}
