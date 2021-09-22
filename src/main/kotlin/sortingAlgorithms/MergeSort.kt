package sortingAlgorithms

import Element
import kotlinx.coroutines.delay


/**
 * Sorting Algorithm Merge Sort
 */
object MergeSort {

    /**
     * Merge of two Arrays.
     *
     * Time Complexity: O(n)
     * @param newArray resulting array
     * @param l left index
     * @param a first array
     * @param b second array
     */
    private fun merge(newArray: Array<Element>, l: Int, a: Array<Element>, b: Array<Element>) {
        var aIdx = 0
        var bIdx = 0
        var currentIdx = l

        while (aIdx < a.size && bIdx < b.size) {
            newArray[currentIdx++] = if (a[aIdx].num <= b[bIdx].num) a[aIdx++] else b[bIdx++]
            newArray[currentIdx].type = ElementType.SORTED
        }

        while (aIdx < a.size) {
            newArray[currentIdx++] = a[aIdx++]
        }

        while (bIdx < b.size) {
            newArray[currentIdx++] = b[bIdx++]
        }
    }


    /**
     * Merge left and right parts of an Array.
     *
     * Time Complexity: O(n)
     * @param a array
     * @param l left index
     * @param mid mid index
     * @param r right index
     */
    private fun mergeLeftAndRight(a: Array<Element>, l: Int, mid: Int, r: Int) {
        val leftArray = a.copyOfRange(l, mid + 1) // toIndex -> exclusive
        val rightArray = a.copyOfRange(mid + 1, r + 1)
        merge(a, l, leftArray, rightArray)
    }


    /**
     * Merge Sort of an Array.
     *
     * Time Complexity: O(nlog₂n)
     * @param a array
     * @param l left index
     * @param r right index
     * @param delay algorithm delay
     */
    suspend fun sort(a: Array<Element>, l: Int, r: Int, delay: Long) {
        if (l < r) {
            val mid = l + (r - l) / 2
            sort(a, l, mid, delay)
            sort(a, mid + 1, r, delay)
            mergeLeftAndRight(a, l, mid, r)
        }
        delay(delay)
        ArrayPanel.repaint()
    }

}
