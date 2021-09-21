package sortingAlgorithms


import Element
import kotlinx.coroutines.delay


/**
 * Sorting Algorithm Insertion Sort
 */
object InsertionSort {


    /**
     * Insertion Sort of an Array.
     *
     * Time Complexity: O(n²)
     * @param a array
     * @param delay algorithm delay
     */
    suspend fun sort(a: Array<Element>, delay: Long) {
        for (i in a.indices) {
            val value = a[i]
            var currentIdx = i

            while (currentIdx > 0 && a[currentIdx - 1].num > value.num) {
                a[currentIdx] = a[--currentIdx]
                delay(delay)
                ArrayPanel.repaint()
            }
            a[currentIdx] = value
            a[currentIdx].type = ElementType.SORTED
        }
    }

}
