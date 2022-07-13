package sortingAlgorithms

import ArrayPanel
import Element
import ElementType
import kotlinx.coroutines.delay

/**
 * Insertion Sort of an Array.
 *
 * Time Complexity: O(n²)
 * @param a array
 * @param delay algorithm delay
 */
suspend fun insertionSort(a: Array<Element>, delay: Long) {
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
