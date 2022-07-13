package sortingAlgorithms

import ArrayPanel
import Element
import ElementType
import exchange
import kotlinx.coroutines.delay

/**
 * Bubble Sort of an Array.
 *
 * Time Complexity: O(n²)
 * @param a array
 * @param delay algorithm delay
 */
suspend fun bubbleSort(a: Array<Element>, delay: Long) {
    var switched = true

    for (i in a.indices) {
        if (!switched) break
        switched = false

        for (j in a.lastIndex downTo i + 1) {
            if (a[j].num < a[j - 1].num) {
                exchange(a, j, j - 1)
                switched = true
            }
            delay(delay)
            ArrayPanel.repaint()
        }
        a[i].type = ElementType.SORTED
    }
}
