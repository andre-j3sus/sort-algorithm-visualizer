package sortingAlgorithms


import kotlinx.coroutines.delay


/**
 * Sorting Algorithm Insertion Sort
 */
object InsertionSort {


    /**
     * Insertion Sort of an IntArray.
     *
     * Time Complexity: O(n²)
     * @param a array
     */
    suspend fun sort(a: IntArray, delay: Long) {
        for (i in 1 until a.size) {
            val value = a[i]
            var currentIdx = i

            while (currentIdx > 0 && a[currentIdx - 1] > value) {
                a[currentIdx] = a[--currentIdx]
                delay(delay)
                ArrayPanel.repaint()
            }
            a[currentIdx] = value
        }
    }

}
